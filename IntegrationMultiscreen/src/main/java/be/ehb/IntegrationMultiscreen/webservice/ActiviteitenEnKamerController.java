package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.ActiviteitenDAO;
import be.ehb.IntegrationMultiscreen.DAO.ActiviteitenEnKamerDAO;
import be.ehb.IntegrationMultiscreen.viewModel.ActiviteitenEnKamer;
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
@RequestMapping("/activiteitEnKamer")
public class ActiviteitenEnKamerController {
    @RequestMapping("/getAll")
    public ArrayList<ActiviteitenEnKamer> getAllActiviteitEnKamer(){
       ArrayList<ActiviteitenEnKamer> ALleActiviteitenEnKamer = ActiviteitenEnKamerDAO.getActiviteitenEnKamer();
       return ALleActiviteitenEnKamer;
    }
    
    @RequestMapping("/getById")
	public ActiviteitenEnKamer getActiviteitEnKamer(@RequestParam(value = "id", defaultValue = "1") int id) {
                ActiviteitenEnKamer newActiviteitenEnKamer = ActiviteitenEnKamerDAO.getActiviteitenEnKamerById(id);
		return newActiviteitenEnKamer;
	}
        @RequestMapping(value ="/post",method = RequestMethod.POST)
	public void PostActiviteitEnKamer(@RequestBody ActiviteitenEnKamer newActiviteitenEnKamer) {
                ActiviteitenEnKamerDAO.voegActiviteitenEnKamerToe(newActiviteitenEnKamer);    
}
}
