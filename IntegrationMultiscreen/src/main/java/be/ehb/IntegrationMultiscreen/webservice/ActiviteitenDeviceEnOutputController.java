package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.ActiviteitenDAO;
import be.ehb.IntegrationMultiscreen.DAO.ActiviteitenDeviceEnOutputDAO;
import be.ehb.IntegrationMultiscreen.viewModel.ActiviteitenDeviceEnOutput;
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
@RequestMapping("/activiteitDeviceEnOutput")
public class ActiviteitenDeviceEnOutputController {
    @RequestMapping("/getAll")
    public ArrayList<ActiviteitenDeviceEnOutput> getAllActiviteitDeviceEnOutput(){
       ArrayList<ActiviteitenDeviceEnOutput> ALleActiviteitenDeviceEnOutput = ActiviteitenDeviceEnOutputDAO.getActiviteitenDeviceEnOutput();
       return ALleActiviteitenDeviceEnOutput;
    }
    
    @RequestMapping("/getById")
	public ActiviteitenDeviceEnOutput getActiviteitDeviceEnOutput(@RequestParam(value = "id", defaultValue = "0") int id) {
                ActiviteitenDeviceEnOutput newActiviteitenDeviceEnOutput = ActiviteitenDeviceEnOutputDAO.getActiviteitenDeviceEnOutputById(id);
		return newActiviteitenDeviceEnOutput;
	}
        @RequestMapping(value ="/post",method = RequestMethod.POST)
	public void PostActiviteitDeviceEnOutput(@RequestBody ActiviteitenDeviceEnOutput newActiviteitenDeviceEnOutput) {
                ActiviteitenDeviceEnOutputDAO.voegActiviteitenDeviceEnOutputToe(newActiviteitenDeviceEnOutput);    
}
}
