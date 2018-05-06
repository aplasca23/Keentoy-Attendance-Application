package io.github.keentoy.attendanceapp;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

public class databaseHandler {
    SQLiteDatabase database;
    Activity activity;


    public databaseHandler(Activity activity) {
        this.activity = activity;
        database = activity.openOrCreateDatabase("ASSIST", activity.MODE_PRIVATE, null);

    }
}
