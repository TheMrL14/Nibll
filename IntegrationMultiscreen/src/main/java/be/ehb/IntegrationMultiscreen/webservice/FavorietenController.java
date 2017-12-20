/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.FavorietenDAO;
import be.ehb.IntegrationMultiscreen.model.Favoriet;
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
@RequestMapping("/favoriet")
public class FavorietenController {
    @RequestMapping("/getAll")
    public ArrayList<Favoriet> getAllFavorieten(){
       ArrayList<Favoriet> alleFavorieten = FavorietenDAO.getFavorieten();
       return alleFavorieten;
    }
    @RequestMapping("/getId")
	public Favoriet getFavorietById(@RequestParam(value = "id", defaultValue = "0") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten
                                    Favoriet favoriet = FavorietenDAO.getFavorietById(id);
		return favoriet;
	}
        @RequestMapping(value ="/post",method = RequestMethod.POST)
	public void PostFavoriet(@RequestBody Favoriet newFavoriet) {
		// Defaults aanroepen met
		// http://localhost:8080/test/Postactiviteiten
		// newActiviteit = (new Activiteit(0,newActiviteit.getNaamActiviteit("naamActiviteit"),);
                FavorietenDAO.voegFavorietToe(newFavoriet);    
}
}
