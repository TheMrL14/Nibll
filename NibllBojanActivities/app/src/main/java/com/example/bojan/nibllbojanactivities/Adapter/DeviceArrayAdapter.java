package com.example.bojan.nibllbojanactivities.Adapter;

/**
 * Created by bojan on 20-Dec-17.
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bojan.nibllbojanactivities.R;
import com.example.bojan.nibllbojanactivities.model.Device;
import com.example.bojan.nibllbojanactivities.model.Sensor;

import java.util.List;

/**
 * Created by nick on 10/12/2017.
 */

public class DeviceArrayAdapter extends ArrayAdapter<Object> {
    public DeviceArrayAdapter(Context context, List<Object> objects) {
        super((Context) context, -1, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater mijnLayoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Alle XML elementen van de listviewitem_trein layout omzetten naar objecten van overeenkomstige View-klasses
        View gridViewItem = null;


        Object weerTeGevenObject = this.getItem(position);
        if(weerTeGevenObject.getClass() == Device.class){
            gridViewItem = mijnLayoutInflater.inflate(R.layout.tiledevice, parent, false);
            ImageView deviceIcon = (ImageView)gridViewItem.findViewById(R.id.deviceIcon);
            ImageView deviceIcon2 = (ImageView)gridViewItem.findViewById(R.id.deviceIcon2);
            TextView deviceText = (TextView)gridViewItem.findViewById(R.id.deviceText);
            Device weerTeGevenDevice = (Device) weerTeGevenObject;
            deviceText.setText(weerTeGevenDevice.getName());
            deviceIcon.setImageResource(weerTeGevenDevice.getIconId());
            deviceIcon2.setImageResource(weerTeGevenDevice.getExtraId());
            if(weerTeGevenDevice.getStatus()){
                deviceIcon.setColorFilter(0xFFFFFFFF);
                deviceIcon2.setColorFilter(0xFFFFFFFF);

                LinearLayout backgroundColor = (LinearLayout) gridViewItem.findViewById(R.id.tileBlock);
                backgroundColor.setBackgroundColor(0xFF5EACC7);
            }else{
                deviceIcon.setColorFilter(0xFF326270);

                deviceIcon2.setColorFilter(0xFF326270);

                LinearLayout backgroundColor = (LinearLayout) gridViewItem.findViewById(R.id.tileBlock);
                backgroundColor.setBackgroundColor(0xFF4587A0);
            }
        }else if(weerTeGevenObject.getClass() == Sensor.class){
            gridViewItem = mijnLayoutInflater.inflate(R.layout.tilesensor, parent, false);
            TextView sensorName = (TextView)gridViewItem.findViewById(R.id.sensorName);
            TextView sensorInput = (TextView) gridViewItem.findViewById(R.id.sensorInput);
            Sensor weerTeGevenSensor = (Sensor) weerTeGevenObject;
            sensorName.setText(weerTeGevenSensor.getNaamSensor());
            sensorInput.setText(Double.toString(weerTeGevenSensor.getStatus()) + " °C");

//            deviceIcon.setImageResource(weerTeGevenDevice.getIconId());
//            deviceIcon2.setImageResource(weerTeGevenDevice.getExtraId());
        }



        return gridViewItem;
    }
}
