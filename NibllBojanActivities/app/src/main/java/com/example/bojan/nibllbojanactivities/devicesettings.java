package com.example.bojan.nibllbojanactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.bojan.nibllbojanactivities.model.Device;
import com.example.bojan.nibllbojanactivities.utils.MySingleton;

public class devicesettings extends AppCompatActivity {

    Button buttonOn;
    Button buttonOff;
    boolean click = false;
    String urlOn = "http://localhost:8080/device/statusChangeById?id=0&status=0";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devicesettings);

        Bundle doorgestuurdeGegevens = getIntent().getExtras();



        if (doorgestuurdeGegevens == null) {
            Log.d(this.getClass().getName(), "Er werden geen gegevens doorgestuurd!!");
            finish();
        } else {
            final Device doorgestuurdeDevice = (Device) doorgestuurdeGegevens.get("device");

            TextView deviceNaam = (TextView) findViewById(R.id.devicenaam);
            deviceNaam.setText(doorgestuurdeDevice.getName());

            findViewById(R.id.seekBar).setPadding(0,0,0,0);

            buttonOn = (Button) findViewById(R.id.onButton);
            buttonOff = (Button) findViewById(R.id.offButton);

            if(doorgestuurdeDevice.getStatus()){
                buttonOff.setTextColor(0xFF326270);
                buttonOff.setBackgroundColor(0xFFFFFFFF);
                buttonOn.setTextColor(0xFFFFFFFF);
                buttonOn.setBackgroundColor(0xFF326270);
            }else{
                buttonOn.setTextColor(0xFF326270);
                buttonOn.setBackgroundColor(0xFFFFFFFF);
                buttonOff.setTextColor(0xFFFFFFFF);
                buttonOff.setBackgroundColor(0xFF326270);
            }

           buttonOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    turnDeviceOnOff(true, doorgestuurdeDevice.getDeviceId());
                    buttonOff.setTextColor(0xFF326270);
                    buttonOff.setBackgroundColor(0xFFFFFFFF);
                    buttonOn.setTextColor(0xFFFFFFFF);
                    buttonOn.setBackgroundColor(0xFF326270);
                }
            });

            buttonOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    turnDeviceOnOff(false, doorgestuurdeDevice.getDeviceId());
                    buttonOn.setTextColor(0xFF326270);
                    buttonOn.setBackgroundColor(0xFFFFFFFF);
                    buttonOff.setTextColor(0xFFFFFFFF);
                    buttonOff.setBackgroundColor(0xFF326270);
                }
            });

        }

    }

    private void turnDeviceOnOff(Boolean on, int deviceId) {
        String url =  "http://192.168.1.131:8080/device/statusChangeById?";
        url += "id=" + deviceId;
        if(on){
            url += "&status=1";
        }else{
            url += "&status=0";
        }
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.toString() + " lol");
                    }
                }
        );

        MySingleton.getInstance(this).addToRequestQueue(postRequest);
    }
}
