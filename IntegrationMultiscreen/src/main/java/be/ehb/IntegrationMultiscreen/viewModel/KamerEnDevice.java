/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.viewModel;

/**
 *
 * @author lione
 */
public class KamerEnDevice {
    private int idKamerEnDevice;
    private int kamerId;
    private int deviceId;

    public int getIdKamerEnDevice() {
        return idKamerEnDevice;
    }

    public void setIdKamerEnDevice(int idKamerEnDevice) {
        this.idKamerEnDevice = idKamerEnDevice;
    }

    public int getKamerId() {
        return kamerId;
    }

    public void setKamerId(int kamerId) {
        this.kamerId = kamerId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public KamerEnDevice(int idKamerEnDevice, int kamerId, int deviceId) {
        this.idKamerEnDevice = idKamerEnDevice;
        this.kamerId = kamerId;
        this.deviceId = deviceId;
    }
    
    public KamerEnDevice() {
        
    }
    
    
}
