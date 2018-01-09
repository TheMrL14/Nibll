/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.DeviceDAO;
import be.ehb.IntegrationMultiscreen.model.Device;
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
public class DeviceController {
    @RequestMapping("/getAll")
    public ArrayList<Device> getAllDevice(){
       ArrayList<Device> alleDevice = DeviceDAO.getDevice();
       return alleDevice;
    }
    @RequestMapping("/getById")
	public Device getDeviceById(@RequestParam(value = "id", defaultValue = "1") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/device/getById
		// Custom aanroepen met
		// http://localhost:8080/device/getById?id=1
                                    Device device = DeviceDAO.getDeviceById(id);
		return device;
	}
        @RequestMapping(value ="/Post",method = RequestMethod.POST)
	public void PostDevice(@RequestBody Device newDevice) {
		// Defaults aanroepen met
		// http://localhost:8080/device/post
                DeviceDAO.voegDeviceToe(newDevice);    
}
      @RequestMapping(value ="/statusChangeById")
	public void PostDevice(@RequestParam(value = "id", defaultValue = "1") int id,@RequestParam(value = "status", defaultValue = "0") int status) {
		// Defaults aanroepen met
		// http://localhost:8080/device/statusChangeById
		//Custom aanroepen met
                // http://localhost:8080/device/statusChangeById?id=1&status=0
                DeviceDAO.setStatusById(id,status);    
}  
}
