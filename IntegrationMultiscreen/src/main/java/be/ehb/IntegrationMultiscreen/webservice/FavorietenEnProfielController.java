/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.FavorietenEnProfielDAO;
import be.ehb.IntegrationMultiscreen.viewModel.FavorietenEnProfiel;
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
@RequestMapping("/favorietEnProfiel")
public class FavorietenEnProfielController {
    @RequestMapping("/getAll")
    public ArrayList<FavorietenEnProfiel> getAllFavorietenEnProfielenEnProfiel(){
       ArrayList<FavorietenEnProfiel> alleFavorietenEnProfielenEnProfiel = FavorietenEnProfielDAO.getFavorietenEnProfiel();
       return alleFavorietenEnProfielenEnProfiel;
    }
    @RequestMapping("/getId")
	public FavorietenEnProfiel getFavorietenEnProfielById(@RequestParam(value = "id", defaultValue = "0") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten
                                    FavorietenEnProfiel favoriet = FavorietenEnProfielDAO.getFavorietenEnProfielById(id);
		return favoriet;
	}
        @RequestMapping(value ="/post",method = RequestMethod.POST)
	public void PostFavorietenEnProfiel(@RequestBody FavorietenEnProfiel newFavorietenEnProfiel) {
		// Defaults aanroepen met
		// http://localhost:8080/test/Postactiviteiten
		// newActiviteit = (new Activiteit(0,newActiviteit.getNaamActiviteit("naamActiviteit"),);
                FavorietenEnProfielDAO.voegFavorietenEnProfielToe(newFavorietenEnProfiel);    
}
}
