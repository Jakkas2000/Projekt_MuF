package com.example.muf_projekt.VM;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.muf_projekt.Daten.DataGYR;
import com.example.muf_projekt.DatabaseMUF;
import com.example.muf_projekt.daoGYRData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GyrVM extends BaseVM {

    private ExecutorService executorService;
    private daoGYRData dao;
    private LiveData<List<DataGYR>> listDG;

    public GyrVM(@NonNull Application app) {
        super(app);

        DatabaseMUF dbMUF = DatabaseMUF.getInstance(app);
        dao = dbMUF.getDaoGyrData();
        listDG = dao.getGyrData();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<DataGYR>> getListDG(){
        return dao.getGyrData();
    }

    public void insert(DataGYR data){
        executorService.execute(()->
                dao.insert(data)
        );
    }
}
