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
    private int deviceID;
    private double inputWaarde;
    private double outputWaarde;
    private boolean status;
    private String naamDevice;
    private int sensorID;
    
    //--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__SETTERS EN GETTERS

    public int getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
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

    public boolean isStatus() {
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

    public int getSensorID() {
        return sensorID;
    }

    public void setSensorID(int sensorID) {
        this.sensorID = sensorID;
    }
  //--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__CONSTRUCTOR  

    public Device(int deviceID, double inputWaarde, double outputWaarde, boolean status, String naamDevice, int sensorID) {
        this.deviceID = deviceID;
        this.inputWaarde = inputWaarde;
        this.outputWaarde = outputWaarde;
        this.status = status;
        this.naamDevice = naamDevice;
        this.sensorID = sensorID;
    }
    
    
}
