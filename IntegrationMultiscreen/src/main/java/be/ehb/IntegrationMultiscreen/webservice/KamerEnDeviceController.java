package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.KamerEnDeviceDAO;
import be.ehb.IntegrationMultiscreen.viewModel.KamerEnDevice;
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
@RequestMapping("/kamerEnDevice")
public class KamerEnDeviceController {

    @RequestMapping("/getAll")
    public ArrayList<KamerEnDevice> getAllKamerEnDevice(){
       ArrayList<KamerEnDevice> alleKamerEnDevice = KamerEnDeviceDAO.getKamerEnDevice();
       return alleKamerEnDevice;
    }
    
    @RequestMapping("/getById")
	public KamerEnDevice getKamerEnDeviceById(@RequestParam(value = "id", defaultValue = "1") int id) {
                KamerEnDevice newKamerEnDevice = KamerEnDeviceDAO.getKamerEnDeviceById(id);
		return newKamerEnDevice;
	}
        @RequestMapping(value ="/post",method = RequestMethod.POST)
	public void PostKamerEnDevice(@RequestBody KamerEnDevice newKamerEnDevice) {
                KamerEnDeviceDAO.voegKamerEnDeviceToe(newKamerEnDevice);    
}
}

