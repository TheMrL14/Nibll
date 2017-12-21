/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.viewModel;

/**
 *
 * @author lione
 */
public class FavorietenEnProfiel {
    private int idDeviceEnSensor;
    private int favorietenId;
    private int profielId;

    public int getIdDeviceEnSensor() {
        return idDeviceEnSensor;
    }

    public void setIdDeviceEnSensor(int idDeviceEnSensor) {
        this.idDeviceEnSensor = idDeviceEnSensor;
    }

    public int getFavorietenId() {
        return favorietenId;
    }

    public void setFavorietenId(int favorietenId) {
        this.favorietenId = favorietenId;
    }

    public int getProfielId() {
        return profielId;
    }

    public void setProfielId(int profielId) {
        this.profielId = profielId;
    }

    public FavorietenEnProfiel(int idDeviceEnSensor, int favorietenId, int profielId) {
        this.idDeviceEnSensor = idDeviceEnSensor;
        this.favorietenId = favorietenId;
        this.profielId = profielId;
    }
    
    public FavorietenEnProfiel() {
    
    }
    
    
            
}
