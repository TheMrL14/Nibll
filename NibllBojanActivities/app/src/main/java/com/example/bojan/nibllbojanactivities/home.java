package com.example.bojan.nibllbojanactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
                    ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().voegNieuweDeviceToe(new Device(0, R.drawable.lamp_icon, R.drawable.lamp_scroll_off, "Bureau Lamp"));
                    ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().voegNieuweDeviceToe(new Device(0, R.drawable.airco_icon, R.drawable.airco_arrow, "Airco Bedroom"));
                    ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().voegNieuweDeviceToe(new Device(0, R.drawable.lamp_icon, R.drawable.lamp_scroll_off, "The Lights"));
                    ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().voegNieuweDeviceToe(new Device(0, R.drawable.lamp_icon, R.drawable.lamp_scroll_off, "Keuken"));
                    ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().voegNieuweDeviceToe(new Device(0, R.drawable.lamp_icon, R.drawable.lamp_scroll_off, "Keuken"));
                    alleDevices = ApplicatieDatabase.getDatabase(home.super.getApplicationContext()).getDeviceDao().getAlleDevice();
                }
                for(Device huidigeDevice : alleDevices) {
                    Log.d("DatabaseLezen", huidigeDevice.getName());
                }
                vulLijstOp(alleDevices);

                GridView lstDevices = (GridView)findViewById(R.id.deviceGridview);

                lstDevices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    boolean click = false;
                    @Override

                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Toast.makeText(home.this, "Short Press", Toast.LENGTH_LONG).show();

                        click = !click;
                        if (click == true) {
                            ImageView icon = (ImageView) findViewById(R.id.deviceIcon);
                            icon.setColorFilter(0xFFFFFFFF);

                            ImageView icon2 = (ImageView) findViewById(R.id.deviceIcon2);
                            icon2.setColorFilter(0xFFFFFFFF);

                            LinearLayout backgroundColor = (LinearLayout) findViewById(R.id.tileBlock);
                            backgroundColor.setBackgroundColor(0xFF5EACC7);
                        } else if (click == false) {
                            ImageView icon = (ImageView) findViewById(R.id.deviceIcon);
                            icon.setColorFilter(0xFF326270);

                            ImageView icon2 = (ImageView) findViewById(R.id.deviceIcon2);
                            icon2.setColorFilter(0xFF326270);

                            LinearLayout backgroundColor = (LinearLayout) findViewById(R.id.tileBlock);
                            backgroundColor.setBackgroundColor(0xFF4587A0);
                        }

                        Device mijnGeselecteerdeDevice = (Device)parent.getItemAtPosition(position);
                        Log.d("Naam", mijnGeselecteerdeDevice.getName());

//                        Intent mijnIntent = new Intent(home.this, TreinDetailActivity.class);
//                        mijnIntent.putExtra("weergeven", mijnGeselecteerdeDevice);
//                        startActivity(mijnIntent);
                    }
//
//
                });
                lstDevices.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                        Toast.makeText(home.this, "Long Press", Toast.LENGTH_LONG).show();

                        Intent intentLoadNewActivity = new Intent(home.this, devicesettings.class);
                        startActivity(intentLoadNewActivity);

                        Device mijnGeselecteerdeDevice = (Device)parent.getItemAtPosition(position);
                        Log.d("Naam", mijnGeselecteerdeDevice.getName());

//                        Intent mijnIntent = new Intent(home.this, TreinDetailActivity.class);
//                        mijnIntent.putExtra("weergeven", mijnGeselecteerdeDevice);
//                        startActivity(mijnIntent);
                        return false;
                    }
//
//
                });
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

