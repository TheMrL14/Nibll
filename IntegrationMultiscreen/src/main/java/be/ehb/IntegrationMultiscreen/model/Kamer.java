/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.model;

/**
 *
 * @author Nibbl
 */
public class Kamer {
    private int kamerId;
    private int sensorId;
    private int deviceId;
    private String naamKamer;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    
    
    
    
    public int getKamerId() {
        return kamerId;
    }

    public void setKamerId(int kamerId) {
        this.kamerId = kamerId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public String getNaamKamer() {
        return naamKamer;
    }

    public void setNaamKamer(String naamKamer) {
        this.naamKamer = naamKamer;
    }

    public Kamer(int kamerId, int sensorId,int deviceId, String naamKamer) {
        this.kamerId = kamerId;
        this.sensorId = sensorId;
        this.naamKamer = naamKamer;
    }
}
