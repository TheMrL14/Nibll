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
import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import be.ehb.IntegrationMultiscreen.model.Product;

@RestController
public class controllers {

    
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
       

}