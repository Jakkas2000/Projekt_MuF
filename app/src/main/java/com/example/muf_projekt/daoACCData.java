package com.example.muf_projekt;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.muf_projekt.Daten.DataACC;

import java.util.List;

@Dao
abstract public class daoACCData {
    //Query zur Abfrage der Datensätze aus der Datenbank
    @Query("SELECT * FROM dataacc order by id desc")
    public abstract LiveData<List<DataACC>> getAccData();

    // Insert zum Einfügen eines neuen Datensatzes, bei selbem Primary Key REPLACE
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long insert(DataACC accData);
}
