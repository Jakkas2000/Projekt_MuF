package com.example.muf_projekt;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.muf_projekt.Daten.DataGYR;
import com.example.muf_projekt.VM.GyrVM;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class FeedbackFragment extends Fragment {
private Sensor sensorGYR;
private SensorManager sensorMngr;
private TextView feedbackTV;
private GyrVM gyrVM;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        feedbackTV = view.findViewById(R.id.sensorFeedback);
        final NavController controller = Navigation.findNavController(view);
        view.findViewById(R.id.btnFeedback).setOnClickListener(buttonFeedNav -> controller.navigate(FeedbackFragmentDirections.actionFeedbackToNavigation()));
    }
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        gyrVM = new ViewModelProvider(getActivity()).get(GyrVM.class);
        View v = inflater.inflate(R.layout.fragment_feedback, container, false);
        sensorMngr = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        sensorGYR = sensorMngr.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        gyrVM = new ViewModelProvider(this).get(GyrVM.class);
        return v;
    }



    @Override
    public void onResume() {
        super.onResume();
        sensorMngr.registerListener(sensorEventListener, sensorGYR, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorMngr.unregisterListener(sensorEventListener);
    }
    private SensorEventListener sensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            float gyr_x = event.values[0];
            float gyr_y = event.values[1];
            float gyr_z = event.values[2];

            DataGYR dataGYR = new DataGYR(gyr_x,gyr_y,gyr_z, System.currentTimeMillis());
            feedbackTV.setText(String.format("x-axis: %f ; y-axis: %f ; z-axis: %f ; ",gyr_x,gyr_y,gyr_z));
            gyrVM.insert(dataGYR);
        }
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };
}



