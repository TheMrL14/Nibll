/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.KamerDAO;
import be.ehb.IntegrationMultiscreen.model.Kamer;
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
@RequestMapping("/kamer")
public class KamerController {
    @RequestMapping("/getAll")
    public ArrayList<Kamer> getAllKamer(){
       ArrayList<Kamer> alleKamer = KamerDAO.getKamers();
       return alleKamer;
    }
    @RequestMapping("/getById")
	public Kamer getKamerById(@RequestParam(value = "id", defaultValue = "1") int id) {
		// Defaults aanroepen met
		// http://localhost:8080/kamer/getById
		// Custom aanroepen met
		// http://localhost:8080/kamer/getById?id=1
                                    Kamer kamer = KamerDAO.getKamerById(id);
		return kamer;
	}
        @RequestMapping(value ="/post",method = RequestMethod.POST)
	public void PostKamer(@RequestBody Kamer newKamer) {
		// Defaults aanroepen met
		// http://localhost:8080/kamer/post
                KamerDAO.voegKamerToe(newKamer);    
}
}
