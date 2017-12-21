package com.example.bojan.nibllbojanactivities.model;

/**
 * Created by bojan on 20-Dec-17.
 */

public class Device {
    private int deviceId;
    private int iconId;
    private int extraId;
    private String name;

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

    public Device(int deviceId, int iconId, int extraId, String name) {
        this.deviceId = deviceId;
        this.iconId = iconId;
        this.extraId = extraId;
        this.name = name;
    }
}
