package com.example.bojan.nibllbojanactivities;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.bojan.nibllbojanactivities.model.Device;
import com.example.bojan.nibllbojanactivities.utils.MySingleton;
import org.json.JSONException;
import org.json.JSONObject;


public class devicesettings extends AppCompatActivity {
    CountDownTimer countDownTimer;
    Button buttonOn;
    Button buttonOff;
    Device device;
    int deviceId;
    String url = "http://localhost:8080/device/statusChangeById?";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devicesettings);

        Bundle doorgestuurdeGegevens = getIntent().getExtras();



        if (doorgestuurdeGegevens == null) {
            Log.d(this.getClass().getName(), "Er werden geen gegevens doorgestuurd!!");
            finish();
        } else {
            device = (Device) doorgestuurdeGegevens.get("device");

            deviceId = device.getDeviceId();

            TextView deviceNaam = (TextView) findViewById(R.id.devicenaam);
            deviceNaam.setText(device.getName());

            findViewById(R.id.seekBar).setPadding(0,0,0,0);

            changeButtonLayout(device.getStatus());

            haalDetailsOp();

           buttonOn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    turnDeviceOnOff(true, deviceId);
                    changeButtonLayout(true);
                }
            });

            buttonOff.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    turnDeviceOnOff(false, deviceId);
                    changeButtonLayout(false);
                }
            });

        }

    }

private void haalDetailsOp() //hierin worden alle gegevens van het apparaat opgehaald
{
    JsonObjectRequest jsObjRequest = new JsonObjectRequest
            (Request.Method.GET, "http://192.168.1.128:8080/device/getById?id=" + deviceId, null, new Response.Listener<JSONObject>() {


                @Override
                public void onResponse(JSONObject response) {

                    try {
                        device = new Device(Integer.parseInt(response.get("deviceId").toString()), R.drawable.lamp_icon, R.drawable.lamp_scroll_off, response.get("naamDevice").toString(), Boolean.parseBoolean(response.get("status").toString()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    changeButtonLayout(device.getStatus());

                    countDownTimer = new CountDownTimer(2000, 2000) { //haal elke 2 seconden opnieuw de data van het apparaat op

                        @Override
                        public void onTick(long l) {

                        }

                        public void onFinish() {
                            haalDetailsOp();
                        }
                    }.start();

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                }

            });
    MySingleton.getInstance(devicesettings.this).addToRequestQueue(jsObjRequest);
}
    private void changeButtonLayout(Boolean on){ //voor de buttonlayout te wijzigen als het apparaat word in/ uitgeschakeld
        buttonOn = (Button) findViewById(R.id.onButton);
        buttonOff = (Button) findViewById(R.id.offButton);

        if(on){
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
    }

    private void turnDeviceOnOff(Boolean on, int deviceId) {
        String url =  "http://192.168.1.128:8080/device/statusChangeById?";
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
                        Log.d("Error.Response", error.toString());
                    }
                }
        );

        MySingleton.getInstance(this).addToRequestQueue(postRequest);
    }
}
