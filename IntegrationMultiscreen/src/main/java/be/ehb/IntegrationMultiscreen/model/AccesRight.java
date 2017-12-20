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
public class AccesRight {
   private int accesRightId;
   private int deviceId;
   private int profielId;

    public int getAccesRightId() {
        return accesRightId;
    }

    public void setAccesRightId(int accesRightId) {
        this.accesRightId = accesRightId;
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

    public AccesRight(int accesRightId, int deviceId, int profielId) {
        this.accesRightId = accesRightId;
        this.deviceId = deviceId;
        this.profielId = profielId;
    }
    public AccesRight(){
        
    }
    
}
