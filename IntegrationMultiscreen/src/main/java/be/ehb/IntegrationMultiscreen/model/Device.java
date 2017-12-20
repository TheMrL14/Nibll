/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.model;

/**
 *
 * @author Lennert
 */
public class Device {
    private int deviceId;
    private double inputWaarde;
    private double outputWaarde;
    private boolean status;
    private String naamDevice;
    private int sensorId;
    
    //--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__SETTERS EN GETTERS

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public double getInputWaarde() {
        return inputWaarde;
    }

    public void setInputWaarde(double inputWaarde) {
        this.inputWaarde = inputWaarde;
    }

    public double getOutputWaarde() {
        return outputWaarde;
    }

    public void setOutputWaarde(double outputWaarde) {
        this.outputWaarde = outputWaarde;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getNaamDevice() {
        return naamDevice;
    }

    public void setNaamDevice(String naamDevice) {
        this.naamDevice = naamDevice;
    }

    public int getSensorId() {
        return sensorId;
    }

    public void setSensorId(int sensorId) {
        this.sensorId = sensorId;
    }
  //--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__CONSTRUCTOR  

    public Device(int deviceId, double inputWaarde, double outputWaarde, boolean status, String naamDevice, int sensorId) {
        this.deviceId = deviceId;
        this.inputWaarde = inputWaarde;
        this.outputWaarde = outputWaarde;
        this.status = status;
        this.naamDevice = naamDevice;
        this.sensorId = sensorId;
    }
   public Device(){
       
   } 
    
}
