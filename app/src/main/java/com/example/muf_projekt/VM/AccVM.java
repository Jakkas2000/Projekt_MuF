package com.example.muf_projekt.VM;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.muf_projekt.Daten.DataACC;
import com.example.muf_projekt.DatabaseMUF;
import com.example.muf_projekt.daoACCData;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

public class AccVM extends BaseVM {

    private ExecutorService executorService;
    private daoACCData dao;
    private LiveData<List<DataACC>> listDA;

    public AccVM(@NonNull Application app) {
        super(app);

        DatabaseMUF dbMUF = DatabaseMUF.getInstance(app);
        dao = dbMUF.getDaoAccData();
        listDA = dao.getAccData();
        executorService = Executors.newSingleThreadExecutor();
    }

    public LiveData<List<DataACC>> getListDA(){
        return listDA;
    }

    public void insert(DataACC data){
        //Exekutor ruft Dao Methode Insert auf
        executorService.execute(()->
                dao.insert(data)
        );
    }
}
