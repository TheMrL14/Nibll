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
public class Activiteit {
    private int activiteitId;
    private String naamActiviteit;
    private int deviceId;
    private String outputActie;
    private int profielId;
    private int kamerId;
    
    //-----------------------------------------GETTERS/SETTERS

    public int getActiviteitId() {
        return activiteitId;
    }

    public void setActiviteitId(int activiteitenId) {
        this.activiteitId = activiteitenId;
    }

    public String getNaamActiviteit() {
        return naamActiviteit;
    }

    public void setNaamActiviteit(String naamActiviteit) {
        this.naamActiviteit = naamActiviteit;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getOutputActie() {
        return outputActie;
    }

    public void setOutputActie(String outputActie) {
        this.outputActie = outputActie;
    }

    public int getProfielId() {
        return profielId;
    }

    public void setProfielId(int profielId) {
        this.profielId = profielId;
    }

    public int getKamerId() {
        return kamerId;
    }

    public void setKamerId(int kamerId) {
        this.kamerId = kamerId;
    }
    //----------------------------------------------------Constructors

    public Activiteit(int activiteitId, String naamActiviteit, int deviceId, String outputActie, int profielId, int kamerId) {
        this.activiteitId = activiteitId;
        this.naamActiviteit = naamActiviteit;
        this.deviceId = deviceId;
        this.outputActie = outputActie;
        this.profielId = profielId;
        this.kamerId = kamerId;
    }
    
    
}
