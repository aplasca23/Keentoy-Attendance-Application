package io.github.keentoy.attendanceapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridView;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


public class AppBase extends AppCompatActivity {

    ArrayList<String> basicFields;
    gridAdapter adapter;
    public static ArrayList<String> divisions;
    GridView gridView;
    public static databaseHandler handler;
    public static Activity activity;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected  void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);
        basicFields = new ArrayList<>();
        handler = new databaseHandler(this);
        activity = this;

        getSupportActionBar().show();
        divisions = new ArrayList<>();
        divisions.add("1st Yr. Information Technology");
        divisions.add("2nd Yr. Information Technology");
        divisions.add("3rd Yr. Information Technology");
        divisions.add("4th Yr. Information Technology");
        gridView = (GridView) findViewById(R.id.grid);
        basicFields.add("ATTENDANCE");
        basicFields.add("SCHEDULER");
        basicFields.add("NOTES");
        basicFields.add("PROFILE");
        basicFields.add("GRADE CALCULATOR");
        adapter = new gridAdapter(this, basicFields);
        gridView.setAdapter(adapter);
    }

    public void loadSettings(MenuItem item) {
        Intent launchIntent = new Intent(this, settingsActivity.class);
        startActivity(launchIntent);
    }

    public void loadAbout(MenuItem item) {
        Intent launchIntent = new Intent(this, About.class);
        startActivity(launchIntent);
    }
}
