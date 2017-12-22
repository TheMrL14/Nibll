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

        androidButtonOn = (Button) findViewById(R.id.onButton);
        androidButtonOff = (Button) findViewById(R.id.offButton);

        androidButtonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button buttonOn = (Button) findViewById(R.id.onButton);
                Button buttonOff = (Button) findViewById(R.id.offButton);
                buttonOn.setTextColor(0x4587A0); //this is green color
                buttonOn.setBackgroundColor(0xFFFFFF);
                buttonOff.setTextColor(0xFFFFFF);
                buttonOff.setBackgroundColor(0x4587A0);
            }
        });

        androidButtonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button buttonOn = (Button) findViewById(R.id.onButton);
                Button buttonOff = (Button) findViewById(R.id.offButton);
                buttonOff.setTextColor(0x4587A0); //this is green color
                buttonOff.setBackgroundColor(0xFFFFFF);
                buttonOn.setTextColor(0xFFFFFF);
                buttonOn.setBackgroundColor(0x4587A0);
            }
        });
    }
}
