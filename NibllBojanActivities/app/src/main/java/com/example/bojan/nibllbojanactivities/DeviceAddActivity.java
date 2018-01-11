package com.example.bojan.nibllbojanactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.bojan.nibllbojanactivities.utils.MySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DeviceAddActivity extends AppCompatActivity {
    EditText deviceNaam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_toevoegen);


    }

    public void voegtoe (View view){

        String url = "http://192.168.1.128:8080/device/Post";
        JSONObject jsonObject = new JSONObject();
        deviceNaam = (EditText)  findViewById(R.id.deviceNaam);
        try {
            jsonObject.put("inputWaarde", 0);
            jsonObject.put("outputWaarde", 0);
            jsonObject.put( "status", false);
            jsonObject.put("naamDevice", deviceNaam.getText());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest req = new JsonObjectRequest( Request.Method.POST, url,
                jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        // Handle response
                        DeviceAddActivity.super.finish();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //   Handle Error
                    }
                }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json; charset=utf-8");
                return headers;
            }
        };
        MySingleton.getInstance(this).addToRequestQueue(req);
        }
    }




