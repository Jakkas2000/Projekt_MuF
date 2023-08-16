package com.example.muf_projekt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.muf_projekt.Daten.AdapterDataACC;
import com.example.muf_projekt.VM.AccVM;

public class MonitoringFragment extends Fragment {
    private AccVM accVM;
    private AdapterDataACC adapter;
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_monitoring,container, false);;
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        accVM = new ViewModelProvider(
                getActivity(),
                (ViewModelProvider.Factory) ViewModelProvider.AndroidViewModelFactory.getInstance(getActivity().getApplication())
        ).get(AccVM.class);

        RecyclerView recyclerView = view.findViewById(R.id.monitoringRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        adapter = new AdapterDataACC();
        recyclerView.setAdapter(adapter);
        AccVM accViewModel= new ViewModelProvider(this).get(AccVM.class);
        accViewModel.getListDA().observe(getViewLifecycleOwner(), DataACC -> {
            adapter.setlistDA(DataACC);
        });

        final NavController controller = Navigation.findNavController(view);
        view.findViewById(R.id.btnMonitoring).setOnClickListener(buttonMonNav -> {
            controller.navigate(MonitoringFragmentDirections.actionMonitoringToNavigation());
        });
    }
}
