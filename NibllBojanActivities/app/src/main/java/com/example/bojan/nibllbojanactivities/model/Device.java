package com.example.bojan.nibllbojanactivities.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

/**
 * Created by bojan on 20-Dec-17.
 */
@Entity
public class Device implements Serializable{
    @PrimaryKey(autoGenerate = true)
    private int deviceId;
    private int iconId;
    private int extraId;
    private String name;
    private Boolean status;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public int getExtraId() {
        return extraId;
    }

    public void setExtraId(int extraId) {
        this.extraId = extraId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Device(int deviceId, int iconId, int extraId, String name, Boolean status) {
        this.deviceId = deviceId;
        this.iconId = iconId;
        this.extraId = extraId;
        this.name = name;
        this.status = status;
    }
}
