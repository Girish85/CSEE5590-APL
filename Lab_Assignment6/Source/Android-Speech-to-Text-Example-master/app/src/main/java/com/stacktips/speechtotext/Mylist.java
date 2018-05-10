package com.stacktips.speechtotext;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.*;
import java.util.ArrayList;

public class Mylist extends AppCompatActivity {
    ListView listView;
    ArrayList<String> items;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylist);
        items = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.item,R.id.textView10,items);
        SQLiteDatabase mydatabase = openOrCreateDatabase("MYDB",MODE_PRIVATE,null);
        Cursor resultSet = mydatabase.rawQuery("Select text from Words",null);
        if (resultSet.moveToFirst())
        {
            do {
                items.add(resultSet.getString(0));
                arrayAdapter.notifyDataSetChanged();
            }while (resultSet.moveToNext());
        }
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);
        //Toast.makeText(getApplicationContext(),resultSet.toString(),Toast.LENGTH_LONG).show();
    }
}
