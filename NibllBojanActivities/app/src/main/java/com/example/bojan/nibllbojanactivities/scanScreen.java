package com.example.bojan.nibllbojanactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class scanScreen extends AppCompatActivity {

    ImageButton androidImageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_screen);

        androidImageButton = (ImageButton) findViewById(R.id.image_button_scan);

        androidImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(scanScreen.this, "Nibll was found", Toast.LENGTH_LONG).show();
                Intent intentLoadNewActivity = new Intent(scanScreen.this, home.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }
}
