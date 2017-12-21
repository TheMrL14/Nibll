package com.example.bojan.nibllbojanactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.bojan.nibllbojanactivities.Adapter.DeviceArrayAdapter;
import com.example.bojan.nibllbojanactivities.database.ApplicatieDatabase;
import com.example.bojan.nibllbojanactivities.model.Device;

import java.util.List;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Thread mijnThread = new Thread(new Runnable() {
            @Override
            public void run() {


                List<Device> alleDevices = ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().getAlleDevice();
                if(alleDevices.size() == 0){
                    ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().voegNieuweDeviceToe(new Device(0, R.drawable.airco_icon, R.drawable.airco_arrow, "Airco Bedroom"));
                    ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().voegNieuweDeviceToe(new Device(0, R.drawable.lamp_icon, R.drawable.lamp_scroll_off, "Bureau Lamp"));
                    ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().voegNieuweDeviceToe(new Device(0, R.drawable.lamp_icon, R.drawable.lamp_scroll_off, "The Lights"));
                    alleDevices = ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().getAlleDevice();
                }
                for(Device huidigeDevice : alleDevices) {
                    Log.d("DatabaseLezen", huidigeDevice.getName());
                }
                vulLijstOp(alleDevices);

                GridView lstDevices = (GridView)findViewById(R.id.deviceGridview);
            }
        });
        mijnThread.start();
    }
    public void vulLijstOp(List<Device> alleDevices){
        DeviceArrayAdapter mijnAdapter = new DeviceArrayAdapter(this, alleDevices);
        GridView mijnAdapterView = (GridView) findViewById(R.id.deviceGridview);
        mijnAdapterView.setAdapter(mijnAdapter);
    }
    }

