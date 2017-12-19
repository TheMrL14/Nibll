/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.ActiviteitenDAO;
import be.ehb.IntegrationMultiscreen.model.Activiteit;
import java.util.ArrayList;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Lennert
 */
public class NibllController {

	@RequestMapping("/getAllActiviteit")
    public ArrayList<Activiteit> getAll(){
       ArrayList<Activiteit> alleActiviteiten = ActiviteitenDAO.getActiviteit();
       return alleActiviteiten;
    }
    @RequestMapping("/getAllSensor")
    public ArrayList<Activiteit> getAll(){
       ArrayList<Activiteit> alleActiviteiten = ActiviteitenDAO.getActiviteit();
       return alleActiviteiten;
    }@RequestMapping("/getAllDevice")
    public ArrayList<Activiteit> getAll(){
       ArrayList<Activiteit> alleActiviteiten = ActiviteitenDAO.getActiviteit();
       return alleActiviteiten;
    }@RequestMapping("/getAllFavorieten")
    public ArrayList<Activiteit> getAll(){
       ArrayList<Activiteit> alleActiviteiten = ActiviteitenDAO.getActiviteit();
       return alleActiviteiten;
    }@RequestMapping("/getAllActiviteit")
    public ArrayList<Activiteit> getAll(){
       ArrayList<Activiteit> alleActiviteiten = ActiviteitenDAO.getActiviteit();
       return alleActiviteiten;
    }@RequestMapping("/getAllActiviteit")
    public ArrayList<Activiteit> getAll(){
       ArrayList<Activiteit> alleActiviteiten = ActiviteitenDAO.getActiviteit();
       return alleActiviteiten;
    }
}
