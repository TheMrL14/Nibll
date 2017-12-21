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
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bojan.nibllbojanactivities.R;
import com.example.bojan.nibllbojanactivities.model.Device;

import java.util.List;

/**
 * Created by nick on 10/12/2017.
 */

public class DeviceArrayAdapter extends ArrayAdapter<Device> {
    public DeviceArrayAdapter (Context context, List<Device> objects) {
        super((Context) context, -1, objects);
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mijnLayoutInflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //Alle XML elementen van de listviewitem_trein layout omzetten naar objecten van overeenkomstige View-klasses
        GridView gridView = (GridView) mijnLayoutInflater.inflate(R.layout.tileitemlayout, parent, false);
        ImageView deviceIcon = (ImageView)gridView.findViewById(R.id.deviceIcon);
        ImageView deviceIcon2 = (ImageView)gridView.findViewById(R.id.deviceIcon2);
        TextView deviceText = (TextView)gridView.findViewById(R.id.deviceText);


        Device weerTeGevenDevice = this.getItem(position);
        deviceText.setText(weerTeGevenDevice.getName());
        deviceIcon.setImageResource(weerTeGevenDevice.getIconId());
        deviceIcon2.setImageResource(weerTeGevenDevice.getExtraId());
        return gridView;
    }
}
