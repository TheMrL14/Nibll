/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.DeviceDAO;
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
	public Sensor getSensorById(@RequestParam(value = "id", defaultValue = "1") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/sensor/getById
		// Custom aanroepen met
		// http://localhost:8080/sensor/getById?id=1
                                    Sensor sensor = SensorDAO.getSensorById(id);
		return sensor;
	}
        @RequestMapping(value ="/post",method = RequestMethod.POST)
	public void PostDevice(@RequestBody Sensor newSensor) {
		// Defaults aanroepen met
		// http://localhost:8080/sensor/post
		// newActiviteit = (new Activiteit(0,newActiviteit.getNaamActiviteit("naamActiviteit"),);
                SensorDAO.voegSensorToe(newSensor);    
}  
         @RequestMapping(value ="/statusChangeById")
	public void PostDevice(@RequestParam(value = "id", defaultValue = "1") int id,@RequestParam(value = "status", defaultValue = "0") int status) {
		// Defaults aanroepen met
		// http://localhost:8080/sensor/statusChangeById
		//Custom aanroepen met
                // http://localhost:8080/sensor/statusChangeById?id=1&status=0
                SensorDAO.setStatusById(id,status);    
}  
}
