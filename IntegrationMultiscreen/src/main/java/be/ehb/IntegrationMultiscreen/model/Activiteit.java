/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.model;

/**
 *
 * @author Lennert
 */
public class Activiteit {
    private int activiteitId;
    private String naamActiviteit;
    private String outputActie;
   
    
    //-----------------------------------------GETTERS/SETTERS

    public int getActiviteitId() {
        return activiteitId;
    }

    public void setActiviteitId(int activiteitenId) {
        this.activiteitId = activiteitenId;
    }

    public String getNaamActiviteit() {
        return naamActiviteit;
    }

    public void setNaamActiviteit(String naamActiviteit) {
        this.naamActiviteit = naamActiviteit;
    }

 
    public String getOutputActie() {
        return outputActie;
    }

    public void setOutputActie(String outputActie) {
        this.outputActie = outputActie;
    }

 
    //----------------------------------------------------Constructors

    public Activiteit(int activiteitId, String naamActiviteit,  String outputActie) {
        this.activiteitId = activiteitId;
        this.naamActiviteit = naamActiviteit;

        this.outputActie = outputActie;
  
    }
    
    public Activiteit(){
        
    }
    
}
