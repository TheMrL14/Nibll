package com.example.bojan.nibllbojanactivities.model;

/**
 * Created by nickv on 11/01/2018.
 */

public class Sensor {
    private int sensorID;
    private String naamSensor;
    private double inputWaarde;
    private int status;

    public int getSensorID() {
        return sensorID;
    }

    public void setSensorID(int sensorID) {
        this.sensorID = sensorID;
    }

    public String getNaamSensor() {
        return naamSensor;
    }

    public void setNaamSensor(String naamSensor) {
        this.naamSensor = naamSensor;
    }

    public double getInputWaarde() {
        return inputWaarde;
    }

    public void setInputWaarde(double inputWaarde) {
        this.inputWaarde = inputWaarde;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Sensor(int sensorID, String naamSensor, double inputWaarde, int status) {
        this.sensorID = sensorID;
        this.naamSensor = naamSensor;
        this.inputWaarde = inputWaarde;
        this.status = status;
    }

    public Sensor() {
    }
}
