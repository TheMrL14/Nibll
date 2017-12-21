/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.AccesRightDAO;
import be.ehb.IntegrationMultiscreen.viewModel.AccesRight;
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
@RequestMapping("/activiteit")
public class AccesRightController {
    
  	@RequestMapping("/getAll")
    public ArrayList<AccesRight> getAllActiviteit(){
       ArrayList<AccesRight> alleActiviteiten = AccesRightDAO.getAccesRight();
       return alleActiviteiten;
    }
    
    @RequestMapping("/getById")
	public AccesRight getActiviteitById(@RequestParam(value = "id", defaultValue = "1") int id) {
                AccesRight activiteit = AccesRightDAO.getAccesRightById(id);
		return activiteit;
	}
        @RequestMapping(value ="/post",method = RequestMethod.POST)
	public void Postactiviteiten(@RequestBody AccesRight newActiviteit) {
		// Defaults aanroepen met
		// http://localhost:8080/test/Postactiviteiten
		// newActiviteit = (new Activiteit(0,newActiviteit.getNaamActiviteit("naamActiviteit"),);
                AccesRightDAO.voegAccesRightToe(newActiviteit);    
}
}
