package com.example.usgir.tripwise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class Signup extends AppCompatActivity {
    EditText id,pwd;
    String id1,pwd1;
    Button login;
    CallbackManager callbackManager;
    LoginButton loginButton;
    private static final String EMAIL = "email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        id = (EditText)findViewById(R.id.editText3);
        pwd = (EditText)findViewById(R.id.editText4);
        login = (Button) findViewById(R.id.button3);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);
        callbackManager = CallbackManager.Factory.create();
        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                Toast.makeText(getApplicationContext(),"Yup",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
        //boolean loggedIn = AccessToken.getCurrentAccessToken() == null;
        //LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id1 = id.getText().toString();
                pwd1 = pwd.getText().toString();
                if (id1.equalsIgnoreCase("Girish")&&pwd1.equalsIgnoreCase("AaBbCc585"))
                {
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Signup.this,Home.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Login Failed Retry",Toast.LENGTH_SHORT).show();
                    id.setText(" ");
                    pwd.setText(" ");
                }
            }
        });
    }
}
