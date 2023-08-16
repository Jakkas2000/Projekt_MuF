package com.example.muf_projekt.VM;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.muf_projekt.AppMUF;
import com.example.muf_projekt.DatabaseMUF;

public abstract class BaseVM extends AndroidViewModel {
    public BaseVM(@NonNull Application application) {
        super(application);
    }

    public DatabaseMUF getDatabase(){
        return ((AppMUF)getApplication()).getDatabaseMUF();
    }
}
