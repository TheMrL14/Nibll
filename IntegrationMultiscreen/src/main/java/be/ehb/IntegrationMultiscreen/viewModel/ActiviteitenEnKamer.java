/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.viewModel;

/**
 *
 * @author Lennert
 */
public class ActiviteitenEnKamer {
    private int idActiviteitenEnKamer;
    private int kamerId;
    private int activiteitenId;
    
    //*******************************************************************GET/SET

    public int getActiviteitenEnKamerId() {
        return idActiviteitenEnKamer;
    }

    public void setActiviteitenEnKamerId(int activiteitenEnKamerId) {
        this.idActiviteitenEnKamer = activiteitenEnKamerId;
    }

    public int getKamerId() {
        return kamerId;
    }

    public void setKamerId(int kamerId) {
        this.kamerId = kamerId;
    }

    public int getActiviteitenId() {
        return activiteitenId;
    }

    public void setActiviteitenId(int activiteitenId) {
        this.activiteitenId = activiteitenId;
    }
    //*******************************************************constructor

    public ActiviteitenEnKamer(int idActiviteitenEnKamer, int kamerId, int activiteitenId) {
        this.idActiviteitenEnKamer = idActiviteitenEnKamer;
        this.kamerId = kamerId;
        this.activiteitenId = activiteitenId;
    }
    
    public ActiviteitenEnKamer(){
        
    }
    
}
