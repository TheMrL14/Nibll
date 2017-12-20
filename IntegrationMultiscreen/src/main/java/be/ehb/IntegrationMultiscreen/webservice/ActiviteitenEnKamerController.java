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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lennert
 */
@RestController
@RequestMapping("/ActiviteitenEnKamer")
public class ActiviteitenEnKamerController {
    @RequestMapping("/getAll")
    public ArrayList<ActiviteitenEnKamer> getAllActiviteit(){
       ArrayList<ActiviteitenEnKamer> ALleActiviteitenEnKamer = ActiviteitenEnKamerDAO.getActiviteitenEnKamer();
       return ALleActiviteitenEnKamer;
    }
    
    @RequestMapping("/getById")
	public ActiviteitenEnKamer getActiviteitById(@RequestParam(value = "id", defaultValue = "0") int id) {
                ActiviteitenEnKamer newActiviteitenEnKamer = ActiviteitenEnKamerDAO.getActiviteitenEnKamerById(id);
		return newActiviteitenEnKamer;
	}
        @RequestMapping(value ="/post",method = RequestMethod.POST)
	public void Postactiviteiten(@RequestBody ActiviteitenEnKamer newActiviteitenEnKamer) {
		// Defaults aanroepen met
		// http://localhost:8080/test/Postactiviteiten
		// newActiviteit = (new Activiteit(0,newActiviteit.getNaamActiviteit("naamActiviteit"),);
                ActiviteitenEnKamerDAO.voegActiviteitenEnKamerToe(newActiviteitenEnKamer);    
}
}
