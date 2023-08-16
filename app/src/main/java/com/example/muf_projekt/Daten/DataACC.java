package com.example.muf_projekt.Daten;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
//Festlegen als Entity für die Datenbank
@Entity(tableName = "dataacc")
public class DataACC {
    //Konstruktor mit allen 4 Attributen
    public DataACC(long timestamp, float acc_x, float acc_y, float acc_z){
        this.timestamp = timestamp;
        this.acc_x = acc_x;
        this.acc_y = acc_y;
        this.acc_z = acc_z;
    }
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long timestamp;
    private float acc_x;
    private float acc_y;
    private float acc_z;

    //ID
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    //Timestamp
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    //accdata
    public float getAcc_x() {
        return acc_x;
    }
    public void setAcc_x(float acc_x) {
        this.acc_x = acc_x;
    }
    public float getAcc_y() {
        return acc_y;
    }
    public void setAcc_y(float acc_y) {
        this.acc_y = acc_y;
    }
    public float getAcc_z() {
        return acc_z;
    }
    public void setAcc_z(float acc_z) {
        this.acc_z = acc_z;
    }

}
