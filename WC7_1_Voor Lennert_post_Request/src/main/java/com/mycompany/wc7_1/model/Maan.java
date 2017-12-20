/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wc7_1.model;

/**
 *
 * @author lione
 */
public class Maan {
    private int maanId;
     private int planeetId;    
     private String naam;

    public int getMaanId() {
        return maanId;
    }

    public void setMaanId(int maanId) {
        this.maanId = maanId;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getPlaneetId() {
        return planeetId;
    }

    public void setPlaneetId(int planeetId) {
        this.planeetId = planeetId;
    }

    public Maan(int maanId, int planeetId, String naam) {
        this.maanId = maanId;
        this.naam = naam;
        this.planeetId = planeetId;
    }
     
}
