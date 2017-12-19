/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.ActiviteitenDAO;
import be.ehb.IntegrationMultiscreen.DAO.DeviceDAO;
import be.ehb.IntegrationMultiscreen.DAO.FavorietenDAO;
import be.ehb.IntegrationMultiscreen.DAO.KamerDAO;
import be.ehb.IntegrationMultiscreen.DAO.ProfielDAO;
import be.ehb.IntegrationMultiscreen.DAO.sensorDAO;
import be.ehb.IntegrationMultiscreen.model.Activiteit;
import be.ehb.IntegrationMultiscreen.model.Device;
import be.ehb.IntegrationMultiscreen.model.Favoriet;
import be.ehb.IntegrationMultiscreen.model.Kamer;
import be.ehb.IntegrationMultiscreen.model.Profiel;
import be.ehb.IntegrationMultiscreen.model.Sensor;
import java.util.ArrayList;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lennert
 */
public class NibllController {
 //--------------------------------------------------------------------------------------------------------------------/GET ALL
//--------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------
	@RequestMapping("/getAllActiviteit")
    public ArrayList<Activiteit> getAllActiviteit(){
       ArrayList<Activiteit> alleActiviteiten = ActiviteitenDAO.getActiviteit();
       return alleActiviteiten;
    }
    @RequestMapping("/getAllSensor")
    public ArrayList<Sensor> getAllSensor(){
       ArrayList<Sensor> alleActiviteiten = sensorDAO.getSensor();
       return alleActiviteiten;
    }@RequestMapping("/getAllDevice")
    public ArrayList<Device> getAllDevice(){
       ArrayList<Device> alleDevice = DeviceDAO.getDevice();
       return alleDevice;
    }@RequestMapping("/getAllFavorieten")
    public ArrayList<Favoriet> getAllFavorieten(){
       ArrayList<Favoriet> alleFavorieten = FavorietenDAO.getFavorieten();
       return alleFavorieten;
    }@RequestMapping("/getAllKamer")
    public ArrayList<Kamer> getAllKamer(){
       ArrayList<Kamer> alleKamer = KamerDAO.getKamers();
       return alleKamer;
    }@RequestMapping("/getAllProfiel")
    public ArrayList<Profiel> getAllProfiel(){
       ArrayList<Profiel> alleProfiel = ProfielDAO.getProfielen();
       return alleProfiel;
    }
//--------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------/getById
//--------------------------------------------------------------------------------------------------------------------
    
    
    
    //--------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------/getById
//--------------------------------------------------------------------------------------------------------------------
}
