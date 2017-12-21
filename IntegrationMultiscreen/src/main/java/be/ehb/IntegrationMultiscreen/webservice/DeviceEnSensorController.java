/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.DeviceEnSensorDAO;
import be.ehb.IntegrationMultiscreen.viewModel.DeviceEnSensor;
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
@RequestMapping("/device")
public class DeviceEnSensorController {
    @RequestMapping("/getAll")
    public ArrayList<DeviceEnSensor> getAllDeviceEnSensor(){
       ArrayList<DeviceEnSensor> alleDeviceEnSensor = DeviceEnSensorDAO.getDeviceEnSensor();
       return alleDeviceEnSensor;
    }
    @RequestMapping("/getId")
	public DeviceEnSensor getDeviceEnSensorById(@RequestParam(value = "id", defaultValue = "1") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten
                                    DeviceEnSensor device = DeviceEnSensorDAO.getDeviceEnSensorById(id);
		return device;
	}
        @RequestMapping(value ="/Post",method = RequestMethod.POST)
	public void PostDeviceEnSensor(@RequestBody DeviceEnSensor newDeviceEnSensor) {
		// Defaults aanroepen met
		// http://localhost:8080/test/Postactiviteiten
		// newActiviteit = (new Activiteit(0,newActiviteit.getNaamActiviteit("naamActiviteit"),);
                DeviceEnSensorDAO.voegDeviceEnSensorToe(newDeviceEnSensor);    
}
}
