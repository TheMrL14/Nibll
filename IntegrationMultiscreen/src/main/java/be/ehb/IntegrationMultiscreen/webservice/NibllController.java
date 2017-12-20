/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.SensorDAO;
import be.ehb.IntegrationMultiscreen.model.Sensor;

import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lennert
 */
@RestController
public class NibllController {
 
     @RequestMapping(value ="/checkStatus",method = RequestMethod.GET)
	public void checkStatus(@RequestBody Sensor newSensor) {
		// Defaults aanroepen met
		// http://localhost:8080/test/Postactiviteiten
		// newActiviteit = (new Activiteit(0,newActiviteit.getNaamActiviteit("naamActiviteit"),);
                SensorDAO.voegSensorToe(newSensor);    
}         
        
<<<<<<< Updated upstream
}
=======
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
                    System.out.println(id);
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
>>>>>>> Stashed changes
