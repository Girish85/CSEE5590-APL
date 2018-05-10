package com.stacktips.speechtotext;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Launching extends AppCompatActivity {
    Button b1,b2,b3;
    SQLiteDatabase sqLiteDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);
        b3 = (Button)findViewById(R.id.button3);
        sqLiteDatabase = openOrCreateDatabase("MYDB",MODE_PRIVATE,null);
        //sqLiteDatabase.execSQL("Drop TABLE Words");
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS Words(ID INTEGER PRIMARY KEY ,text VARCHAR);");
        //int j = (int)(Math.random()*1000);
        //sqLiteDatabase.execSQL("INSERT INTO Words VALUES("+j+",'buffet');");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Listen.class);
                startActivity(intent);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Mylist.class);
                startActivity(intent);
            }
        });

    }
}
