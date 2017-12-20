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
public class Planeet {
    private int planeetId;
    private  int planeetDiameter;
    private String planeetNaam;

    public int getPlaneetId() {
        return planeetId;
    }

    public int getPlaneetDiameter() {
        return planeetDiameter;
    }

    public String getPlaneetNaam() {
        return planeetNaam;
    }

    public void setPlaneetId(int planeetId) {
        this.planeetId = planeetId;
    }

    public void setPlaneetDiameter(int planeetDiameter) {
        this.planeetDiameter = planeetDiameter;
    }

    public void setPlaneetNaam(String planeetNaam) {
        this.planeetNaam = planeetNaam;
    }

    public Planeet(int planeetId, int planeetDiameter, String planeetNaam) {
        this.planeetId = planeetId;
        this.planeetDiameter = planeetDiameter;
        this.planeetNaam = planeetNaam;
    }
}
