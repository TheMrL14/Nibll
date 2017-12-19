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

import be.ehb.IntegrationMultiscreen.DAO.SensorDAO;
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
import org.springframework.web.bind.annotation.RequestParam;
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
       ArrayList<Sensor> alleActiviteiten = SensorDAO.getSensor();
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
 @RequestMapping("/getActiviteitById")
	public Activiteit getActiviteitById(@RequestParam(value = "id", defaultValue = "0") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten
                                    Activiteit activiteit = ActiviteitenDAO.getActiviteitById(id);
		return activiteit;
	}
        
        @RequestMapping("/getSensorById")
	public Sensor getSensorById(@RequestParam(value = "id", defaultValue = "0") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten
                                    Sensor sensor = SensorDAO.getSensorById(id);
		return sensor;
	}
        @RequestMapping("/getDeviceById")
	public Device getDeviceById(@RequestParam(value = "id", defaultValue = "0") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten
                                    Device device = DeviceDAO.getDeviceById(id);
		return device;
	}
        @RequestMapping("/getFavorietentById")
	public Favoriet getFavorietById(@RequestParam(value = "id", defaultValue = "0") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten
                                    Favoriet favoriet = FavorietenDAO.getFavorietById(id);
		return favoriet;
	}
        @RequestMapping("/getKamerById")
	public Kamer getKamerById(@RequestParam(value = "id", defaultValue = "0") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten
                                    Kamer kamer = KamerDAO.getKamerById(id);
		return kamer;
	}
        @RequestMapping("/getProfielById")
	public Profiel getProfielById(@RequestParam(value = "id", defaultValue = "0") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten
                                    Profiel profiel = ProfielDAO.getProfielById(id);
		return profiel;
        }   
    @RequestMapping("/test")
	public String test() {
		// Defaults aanroepen met
		// http://localhost:8080/test
		// Custom aanroepen met
                System.out.println("hallo");
                                    String test = "hallo";
		return test;
        }   

//--------------------------------------------------------------------------------------------------------------------
//--------------------------------------------------------------------------------------------------------------------/getById
//--------------------------------------------------------------------------------------------------------------------
}
