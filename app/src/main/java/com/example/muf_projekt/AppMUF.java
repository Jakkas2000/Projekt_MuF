package com.example.muf_projekt;
import android.app.Application;
import androidx.room.Room;

public class AppMUF extends Application {
    private DatabaseMUF DatabaseMUF;
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseMUF = Room.databaseBuilder(this, DatabaseMUF.class, "muf").build();
    }
    public DatabaseMUF getDatabaseMUF(){
        return DatabaseMUF;
    }
}
