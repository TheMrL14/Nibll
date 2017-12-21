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
public class DeviceEnSensor {
     private int idDeviceEnSensor;
     private int deviceId;
     private int sensorId;

    public int getIdDeviceEnSensor() {
        return idDeviceEnSensor;
    }

    public void setIdDeviceEnSensor(int idDeviceEnSensor) {
        this.idDeviceEnSensor = idDeviceEnSensor;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }

    public DeviceEnSensor(int idDeviceEnSensor, int deviceId, int sensorId) {
        this.idDeviceEnSensor = idDeviceEnSensor;
        this.deviceId = deviceId;
        this.sensorId = sensorId;
    }
    
    public DeviceEnSensor() {
      
    }
     
     
}
