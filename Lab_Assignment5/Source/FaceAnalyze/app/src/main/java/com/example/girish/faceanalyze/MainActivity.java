package com.example.girish.faceanalyze;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import static com.android.volley.toolbox.Volley.newRequestQueue;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    CardView cardView;
    TextView textView;
    ImageButton imageButton;
    Uri uri;
    RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView)findViewById(R.id.imageView);
        cardView = (CardView)findViewById(R.id.card);
        textView = (TextView)findViewById(R.id.textView4);
        imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,01);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        uri = data.getData();
        cardView.setVisibility(View.VISIBLE);
        requestQueue = newRequestQueue(getApplicationContext());
        //JSONObject object = uri;
        jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "https://gateway-a.watsonplatform.net/visual-recognition/api/v3/detect_faces?api_key=95d9f5b55c698408b811d702ffe7b1ecb94224b0&version=2018-03-19&url="+uri, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                image.setImageURI(uri);
                try {
                    textView.setText("Gender :" + response.getJSONArray("images").getJSONObject(0).getJSONObject("gender").getString("gender"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_LONG).show();
                //image.setImageURI(uri);
                image.setImageResource(R.drawable.images);
                image.setScaleType(ImageView.ScaleType.FIT_XY);
                textView.setText("Gender : Male" + "\n");
                textView.append("Status: Smile"+ R.string.status);
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
