/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.ActiviteitenDAO;
import be.ehb.IntegrationMultiscreen.model.Activiteit;
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
@RequestMapping("/Activiteit")
public class ActiviteitenController {
    
  	@RequestMapping("/getAll")
    public ArrayList<Activiteit> getAllActiviteit(){
       ArrayList<Activiteit> alleActiviteiten = ActiviteitenDAO.getActiviteit();
       return alleActiviteiten;
    }
    
    @RequestMapping("/getById")
	public Activiteit getActiviteitById(@RequestParam(value = "id", defaultValue = "0") int id) {
                Activiteit activiteit = ActiviteitenDAO.getActiviteitById(id);
		return activiteit;
	}
        @RequestMapping(value ="/Postactiviteiten",method = RequestMethod.POST)
	public void Postactiviteiten(@RequestBody Activiteit newActiviteit) {
		// Defaults aanroepen met
		// http://localhost:8080/test/Postactiviteiten
		// newActiviteit = (new Activiteit(0,newActiviteit.getNaamActiviteit("naamActiviteit"),);
                ActiviteitenDAO.voegActiviteitToe(newActiviteit);    
}
}
