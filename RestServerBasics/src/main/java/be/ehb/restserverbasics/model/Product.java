/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.restserverbasics.model;

/**
 *
 * @author MaartenH
 */
public class Product {
    	private String naam;
	private double prijs;

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public double getPrijs() {
		return prijs;
	}

	public void setPrijs(double prijs) {
		this.prijs = prijs;
	}
	
	public Product(String naam, double prijs) {
		this.naam = naam;
		this.prijs = prijs;
	}
	
	//Default constructor nodig voor automatische omzetting van JSON naar objecten
	public Product() {
		
	}
}
