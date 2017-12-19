/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.model;

/**
 *
 * @author lione
 */
public class Profiel {
    private int profielId;
    private String naamProfiel;

    public int getProfielId() {
        return profielId;
    }

    public void setProfielId(int profielId) {
        this.profielId = profielId;
    }

    public String getNaamProfiel() {
        return naamProfiel;
    }

    public void setNaamProfiel(String naamProfiel) {
        this.naamProfiel = naamProfiel;
    }

    public Profiel(int profielId, String naamProfiel) {
        this.profielId = profielId;
        this.naamProfiel = naamProfiel;
    }
}
