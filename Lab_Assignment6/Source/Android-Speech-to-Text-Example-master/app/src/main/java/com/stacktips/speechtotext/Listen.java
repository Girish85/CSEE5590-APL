package com.stacktips.speechtotext;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Listen extends AppCompatActivity {
    Speaker speaker;
    EditText text;
    Button button;
    SQLiteDatabase sqLiteDatabase;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listen);
        sqLiteDatabase = openOrCreateDatabase("MYDB",MODE_PRIVATE,null);
        speaker = new Speaker(getApplicationContext());
        text = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.button4);
        imageView = (ImageView)findViewById(R.id.imageView2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = text.getText().toString();
                if (!(txt.equals("")))
                {
                    int j = (int)(Math.random()*1000);
                    sqLiteDatabase.execSQL("INSERT INTO Words VALUES("+j+",'"+txt+"');");
                    Toast.makeText(getApplicationContext(),"Added "+txt+"to your List",Toast.LENGTH_LONG).show();
                }
            }
        });
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                text.setText("");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String string = text.getText().toString();
                speaker.allow(true);
                speaker.speak(string);
            }
        });
    }
}
