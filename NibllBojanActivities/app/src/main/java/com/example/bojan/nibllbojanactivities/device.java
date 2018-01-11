package com.example.bojan.nibllbojanactivities;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.bojan.nibllbojanactivities.Adapter.DeviceArrayAdapter;
import com.example.bojan.nibllbojanactivities.model.Device;
import com.example.bojan.nibllbojanactivities.utils.MySingleton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class device extends AppCompatActivity {
    CountDownTimer countDownTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);


        Thread mijnThread = new Thread(new Runnable() {
            @Override
            public void run() {
                getAllDevice();
            }
        }); //haal device op in aparte thread

        mijnThread.start();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(device.this, DeviceAddActivity.class);
                startActivity(intentLoadNewActivity);
            }
        });
    }

    private void vulLijstOp(List<Device> alleDevices) { //vul de lijst van alle apparaten op
        DeviceArrayAdapter mijnAdapter = new DeviceArrayAdapter(this, alleDevices);
        GridView mijnAdapterView = (GridView) findViewById(R.id.deviceGridview);
        mijnAdapterView.setAdapter(mijnAdapter);
    }

    private void turnDeviceOnOff(Boolean on, int deviceId) { //voer een post request uit voor een apparaat aan/uit te zetten
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
                        getAllDevice();
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
private void getAllDevice(){ //hierin word de json file met alle apparaten die zich in de database bevinden, opgehaald
    JsonArrayRequest jsObjRequest = new JsonArrayRequest
            (Request.Method.GET, "http://192.168.1.128:8080/device/getAll", null, new Response.Listener<JSONArray>() {


                @Override
                public void onResponse(JSONArray response) {

                    List<Device> alleDevice = new ArrayList<Device>();

                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject responseObject = response.getJSONObject(i);

                            alleDevice.add(new Device(Integer.parseInt(responseObject.get("deviceId").toString()), R.drawable.lamp_icon, R.drawable.lamp_scroll_off, responseObject.get("naamDevice").toString(), Boolean.parseBoolean(responseObject.get("status").toString())));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                    vulLijstOp(alleDevice);

                  countDownTimer =  new CountDownTimer(2000, 2000) { //haal elke 2 seconden alle apparaten opnieuw op, voor de laatste status te weten

                      @Override
                      public void onTick(long l) {

                      }

                      public void onFinish() {
                            getAllDevice();
                        }
                    }.start();

                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO Auto-generated method stub
                    Log.d("lol", "onErrorResponse: " + error);
                }

            });
    MySingleton.getInstance(device.this).addToRequestQueue(jsObjRequest);
    GridView lstDevices = (GridView) findViewById(R.id.deviceGridview);
    lstDevices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        boolean click = false;

        @Override

        public void onItemClick(AdapterView<?> parent, View view, int position, long id) { //als er op een apparaat geklikt wordt, wordt dit aan/uitgezet
            List<Device> alleDevice;
            Device device = (Device) parent.getItemAtPosition(position);

            Device mijnGeselecteerdeDevice = (Device) parent.getItemAtPosition(position);
            turnDeviceOnOff(!mijnGeselecteerdeDevice.getStatus() ,mijnGeselecteerdeDevice.getDeviceId());
        }
    });
    lstDevices.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) { //als er lang op een apparaat wordt gedrukt, dan zal er een detail pagina over het apparaat openenen

                        Intent intentLoadNewActivity = new Intent(device.this, devicesettings.class);


                        Device mijnGeselecteerdeDevice = (Device) parent.getItemAtPosition(position);
                        intentLoadNewActivity.putExtra("device",mijnGeselecteerdeDevice);
                        startActivity(intentLoadNewActivity);
                        return false;
                    }
//
//
                });
}
}

