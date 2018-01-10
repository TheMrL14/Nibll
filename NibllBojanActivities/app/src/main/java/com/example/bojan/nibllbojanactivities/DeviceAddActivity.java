package com.example.bojan.nibllbojanactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class DeviceAddActivity extends AppCompatActivity {
    EditText deviceNaam
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_toevoegen);
        deviceNaam = (EditText)  findViewById(R.id.deviceNaam);

    }




    String url = "http://192.168.1.128:8080/device/Post";
    StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            //This code is executed if the server responds, whether or not the response contains data.
            //The String 'response' contains the server's response.
        }
    }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
        @Override
        public void onErrorResponse(VolleyError error) {
            //This code is executed if there is an error.
        }
    }) {
        protected Map<String, String> getParams() {
            Map<String, String> MyData = new HashMap<String, String>();
            MyData.put("inputWaarde", "0");
            MyData.put("inputWaarde", "0");
            MyData.put("inputWaarde", "0");
            MyData.put("inputWaarde", deviceNaam.getText().toString());
            return MyData;
        }
    };
}



