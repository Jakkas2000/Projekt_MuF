package com.example.muf_projekt;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.muf_projekt.Daten.DataGYR;
import com.example.muf_projekt.daoGYRData;

@Database(entities = {DataGYR.class}, version = 2)
public abstract class DatabaseMUF extends RoomDatabase {
    private static DatabaseMUF instance;
    public abstract daoGYRData getDaoGyrData();

    public static synchronized DatabaseMUF getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            DatabaseMUF.class,"MUF_database").fallbackToDestructiveMigration().build();
        }return instance;
    }
}
