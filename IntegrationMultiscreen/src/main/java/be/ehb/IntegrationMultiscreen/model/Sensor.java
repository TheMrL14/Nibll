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
public class Sensor {
    private int sensorID;
    private String naamSensor;
    private double inputWaarde;
    private int status;
  //--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--GETTERS EN SETTERS  

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
    
    public int getStatus(){
    return status;
    }
    
    public void setStatus(int status){
     this.status=status;   
    }
 //--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--__--CONSTRUCTOR    

    public Sensor(int sensorID, String naamSensor, double inputWaarde,int status) {
        this.sensorID = sensorID;
        this.naamSensor = naamSensor;
        this.inputWaarde = inputWaarde;
        this.status = status;
    }
    public Sensor(){
        
    }
    
}
