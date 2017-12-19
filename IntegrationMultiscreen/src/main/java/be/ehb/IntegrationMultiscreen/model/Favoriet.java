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
public class Favoriet {
    private int favorietId;
    private String naamFavoriet;
    private int deviceId;
    private int profielId;

    public int getFavorietId() {
        return favorietId;
    }

    public void setFavorietId(int favorietenId) {
        this.favorietId = favorietId;
    }

    public String getNaamFavoriet() {
        return naamFavoriet;
    }

    public void setNaamFavoriet(String naamFavoriet) {
        this.naamFavoriet = naamFavoriet;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getProfielId() {
        return profielId;
    }

    public void setProfielId(int profielId) {
        this.profielId = profielId;
    }

    public Favoriet(int favorietId, String naamFavoriet, int deviceId, int profielId) {
        this.favorietId = favorietId;
        this.naamFavoriet = naamFavoriet;
        this.deviceId = deviceId;
        this.profielId = profielId;
    }
}
