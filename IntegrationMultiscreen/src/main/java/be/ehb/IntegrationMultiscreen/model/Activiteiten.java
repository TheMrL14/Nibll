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
public class Activiteiten {
    private int activiteitenId;
    private String naamActiviteit;
    private String deviceId;
    private String outputActie;
    private int profielId;
    private int kamerId;
    
    //-----------------------------------------GETTERS/SETTERS

    public int getActiviteitenId() {
        return activiteitenId;
    }

    public void setActiviteitenId(int activiteitenId) {
        this.activiteitenId = activiteitenId;
    }

    public String getNaamActiviteit() {
        return naamActiviteit;
    }

    public void setNaamActiviteit(String naamActiviteit) {
        this.naamActiviteit = naamActiviteit;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
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

    public Activiteiten(int activiteitenId, String naamActiviteit, String deviceId, String outputActie, int profielId, int kamerId) {
        this.activiteitenId = activiteitenId;
        this.naamActiviteit = naamActiviteit;
        this.deviceId = deviceId;
        this.outputActie = outputActie;
        this.profielId = profielId;
        this.kamerId = kamerId;
    }
    
    
}
