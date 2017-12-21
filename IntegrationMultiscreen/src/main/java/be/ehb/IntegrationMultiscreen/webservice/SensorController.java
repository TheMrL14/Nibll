/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.SensorDAO;
import be.ehb.IntegrationMultiscreen.model.Sensor;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Lennert
 */
@RestController
@RequestMapping("/sensor")
public class SensorController {
  @RequestMapping("/getAll")
    public ArrayList<Sensor> getAllSensor(){
       ArrayList<Sensor> alleActiviteiten = SensorDAO.getSensor();
       return alleActiviteiten;
    }
     @RequestMapping("/getById")
	public Sensor getSensorById(@RequestParam(value = "id", defaultValue = "0") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten
                                    Sensor sensor = SensorDAO.getSensorById(id);
		return sensor;
	}
        @RequestMapping(value ="/Post",method = RequestMethod.POST)
	public void PostDevice(@RequestBody Sensor newSensor) {
		// Defaults aanroepen met
		// http://localhost:8080/test/Postactiviteiten
		// newActiviteit = (new Activiteit(0,newActiviteit.getNaamActiviteit("naamActiviteit"),);
                SensorDAO.voegSensorToe(newSensor);    
}  
}