package com.example.muf_projekt;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.muf_projekt.Daten.DataGYR;

import java.util.List;

@Dao
abstract public class daoGYRData {
    @Query("SELECT * FROM datagyr order by timestamp asc")
    public abstract LiveData<List<DataGYR>> getGyrData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insert(DataGYR gyrData);
}
