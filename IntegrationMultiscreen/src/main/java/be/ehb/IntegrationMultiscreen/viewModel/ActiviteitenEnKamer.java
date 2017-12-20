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
    private int activiteitenEnKamerId;
    private int kamerId;
    private int activiteitenId;
    
    //*******************************************************************GET/SET

    public int getActiviteitenEnKamerId() {
        return activiteitenEnKamerId;
    }

    public void setActiviteitenEnKamerId(int activiteitenEnKamerId) {
        this.activiteitenEnKamerId = activiteitenEnKamerId;
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

    public ActiviteitenEnKamer(int activiteitenEnKamerId, int kamerId, int activiteitenId) {
        this.activiteitenEnKamerId = activiteitenEnKamerId;
        this.kamerId = kamerId;
        this.activiteitenId = activiteitenId;
    }
    
    public ActiviteitenEnKamer(){
        
    }
    
}
