package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.KamerEnSensorDAO;
import be.ehb.IntegrationMultiscreen.viewModel.KamerEnSensor;
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
@RequestMapping("/kamerEnSensor")
public class KamerEnSensorController {

    @RequestMapping("/getAll")
    public ArrayList<KamerEnSensor> getAllKamerEnSensor(){
       ArrayList<KamerEnSensor> alleKamerEnSensor = KamerEnSensorDAO.getKamerEnSensor();
       return alleKamerEnSensor;
    }
    
    @RequestMapping("/getById")
	public KamerEnSensor getKamerEnSensorById(@RequestParam(value = "id", defaultValue = "1") int id) {
                KamerEnSensor newKamerEnSensor = KamerEnSensorDAO.getKamerEnSensorById(id);
		return newKamerEnSensor;
	}
        @RequestMapping(value ="/post",method = RequestMethod.POST)
	public void PostKamerEnSensor(@RequestBody KamerEnSensor newKamerEnSensor) {
                KamerEnSensorDAO.voegKamerEnSensorToe(newKamerEnSensor);    
}
}

