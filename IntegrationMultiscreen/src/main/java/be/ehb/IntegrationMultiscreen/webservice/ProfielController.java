/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.ProfielDAO;
import be.ehb.IntegrationMultiscreen.model.Profiel;
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
@RequestMapping("/Favoriet")
public class ProfielController {
     @RequestMapping("/getAllProfiel")
    public ArrayList<Profiel> getAllProfiel(){
       ArrayList<Profiel> alleProfiel = ProfielDAO.getProfielen();
       return alleProfiel;
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
        @RequestMapping(value ="/PostProfiel",method = RequestMethod.POST)
	public void PostProfiel(@RequestBody Profiel newProfiel) {
		// Defaults aanroepen met
		// http://localhost:8080/test/Postactiviteiten
		// newActiviteit = (new Activiteit(0,newActiviteit.getNaamActiviteit("naamActiviteit"),);
                ProfielDAO.voegProfielToe(newProfiel);    
}
}
