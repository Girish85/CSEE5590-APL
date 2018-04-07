package com.example.usgir.tripwise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;
    Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper = (ViewFlipper)findViewById(R.id.flip);
        flipper.setFlipInterval(1000);
        login = (Button)findViewById(R.id.button2);
        signup = (Button)findViewById(R.id.button);
        Animation in = AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.slide_out_right);
        flipper.setInAnimation(in);
        flipper.setOutAnimation(out);
        flipper.startFlipping();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Signup.class);
                startActivity(intent);
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
            }
        });

    }
}
