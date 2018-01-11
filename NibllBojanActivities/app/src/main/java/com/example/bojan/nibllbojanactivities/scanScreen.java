package com.example.bojan.nibllbojanactivities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.bojan.nibllbojanactivities.utils.MySingleton;

public class scanScreen extends AppCompatActivity {

    ImageButton androidImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_screen);

        androidImageButton = (ImageButton) findViewById(R.id.image_button_scan);

        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //Als er op de knop geklikt word, word er een geluid afgespeeld op zowel de gsm als de raspberry pi en wordt de device pagina geopend
                Toast.makeText(scanScreen.this, "Nibll was found", Toast.LENGTH_LONG).show();
                Intent intentLoadNewActivity = new Intent(scanScreen.this, device.class);
                String url ="http://192.168.1.128:5000/play/plop.mp3";

                final MediaPlayer mediaPlayer = MediaPlayer.create(scanScreen.this, R.raw.plop);
                mediaPlayer.start();

                StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(scanScreen.class.toString(), "onErrorResponse: " + error);
                    }
                });
                MySingleton.getInstance(scanScreen.this).addToRequestQueue(stringRequest);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
