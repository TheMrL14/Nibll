package com.example.bojan.nibllbojanactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class devicesettings extends AppCompatActivity {

    Button androidButtonOn;
    Button androidButtonOff;
    boolean click = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devicesettings);

        findViewById(R.id.seekBar).setPadding(0,0,0,0);

        androidButtonOn = (Button) findViewById(R.id.onButton);
        androidButtonOff = (Button) findViewById(R.id.offButton);

        androidButtonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button buttonOn = (Button) findViewById(R.id.onButton);
                Button buttonOff = (Button) findViewById(R.id.offButton);
                buttonOff.setTextColor(0xFF326270);
                buttonOff.setBackgroundColor(0xFFFFFFFF);
                buttonOn.setTextColor(0xFFFFFFFF);
                buttonOn.setBackgroundColor(0xFF326270);
            }
        });

        androidButtonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button buttonOn = (Button) findViewById(R.id.onButton);
                Button buttonOff = (Button) findViewById(R.id.offButton);
                buttonOn.setTextColor(0xFF326270);
                buttonOn.setBackgroundColor(0xFFFFFFFF);
                buttonOff.setTextColor(0xFFFFFFFF);
                buttonOff.setBackgroundColor(0xFF326270);
            }
        });
    }
}
