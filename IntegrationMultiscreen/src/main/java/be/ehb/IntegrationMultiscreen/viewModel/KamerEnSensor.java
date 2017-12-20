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
public class KamerEnSensor {
    private int idKamerEnSensor;
    private int kamerId;
    private int sensorId;

    public int getIdKamerEnSensor() {
        return idKamerEnSensor;
    }

    public void setIdKamerEnSensor(int idKamerEnSensor) {
        this.idKamerEnSensor = idKamerEnSensor;
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

    public KamerEnSensor(int idKamerEnSensor, int kamerId, int sensorId) {
        this.idKamerEnSensor = idKamerEnSensor;
        this.kamerId = kamerId;
        this.sensorId = sensorId;
    }
}
