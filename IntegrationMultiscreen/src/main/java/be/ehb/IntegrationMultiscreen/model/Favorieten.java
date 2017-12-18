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
public class Favorieten {
    int favorietenId;
    String naamFavoriet;
    int deviceId;
    int profielId;

    public int getFavorietenId() {
        return favorietenId;
    }

    public void setFavorietenId(int favorietenId) {
        this.favorietenId = favorietenId;
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

    public Favorieten(int favorietenId, String naamFavoriet, int deviceId, int profielId) {
        this.favorietenId = favorietenId;
        this.naamFavoriet = naamFavoriet;
        this.deviceId = deviceId;
        this.profielId = profielId;
    }
}
