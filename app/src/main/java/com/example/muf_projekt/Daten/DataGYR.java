package com.example.muf_projekt.Daten;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "datagyr")
public class DataGYR {
    public DataGYR(double gyr_x, double gyr_y, double gyr_z,long timestamp){
        this.gyr_x = gyr_x;
        this.gyr_y = gyr_y;
        this.gyr_z = gyr_z;
        this.timestamp = timestamp;
    }
    @PrimaryKey(autoGenerate = true)
    private long id;
    private long timestamp;
    private double gyr_x;
    private double gyr_y;
    private double gyr_z;

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
    public double getGyr_x() {
        return gyr_x;
    }
    public void setGyr_x(float gyr_x) {
        this.gyr_x = gyr_x;
    }
    public double getGyr_y() {
        return gyr_y;
    }
    public void setGyr_y(float gyr_y) {
        this.gyr_y = gyr_y;
    }
    public double getGyr_z() {
        return gyr_z;
    }
    public void setGyr_z(float gyr_z) {
        this.gyr_z = gyr_z;
    }

}
