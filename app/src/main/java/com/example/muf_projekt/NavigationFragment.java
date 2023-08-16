package com.example.muf_projekt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class NavigationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //Layout Inflaten
        View v = inflater.inflate(R.layout.fragment_navigation,container, false);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final NavController controller = Navigation.findNavController(view);
        view.findViewById(R.id.btnMonitoring).setOnClickListener(btnMonitoring -> {
            controller.navigate(NavigationFragmentDirections.actionNavigationToMonitoring());
        });
        view.findViewById(R.id.btnFeedback).setOnClickListener(btnFeedback -> {
            controller.navigate(NavigationFragmentDirections.actionNavigationToFeedback());
        });
    }
}
