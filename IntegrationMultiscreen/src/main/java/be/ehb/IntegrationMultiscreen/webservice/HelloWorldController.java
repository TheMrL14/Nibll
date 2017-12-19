package be.ehb.IntegrationMultiscreen.webservice;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import be.ehb.IntegrationMultiscreen.model.Product;

@RestController
public class HelloWorldController {

    
	@RequestMapping("/zonderParametersEnZonderReturn")
	public void zonderParametersEnZonderReturn() {
		// Aanroepen met
		// http://localhost:8080/zonderParametersEnZonderReturn
		System.out.println("Hello world!");
	}

	@RequestMapping("/zonderParametersEnEenvoudigeReturn")
	public String zonderParametersEnEenvoudigeReturn() {
		// Aanroepen met
		// http://localhost:8080/zonderParametersEnEenvoudigeReturn
		return "Hello world!";
	}

	@RequestMapping("/metEnkelvoudigeGetParameterEnEenvoudigeReturn")
	public String metEnkelvoudigeGetParameterEnEenvoudigeReturn(@RequestParam(value = "naam", defaultValue = "my dear") String naam) {
		// Defaults aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metEnkelvoudigeGetParameterEnEenvoudigeReturn?naam=Maarten

		return "Hallo " + naam + "!";
	}

	@RequestMapping("/metMeervoudigeGetParametersEnEenvoudigeReturn")
	public String metMeervoudigeGetParametersEnEenvoudigeReturn(@RequestParam(value = "voornaam", defaultValue = "Maarten") String voornaam, @RequestParam(value = "achternaam", defaultValue = "Heylen") String achternaam) {
		// Defaults aanroepen met
		// http://localhost:8080/metMeervoudigeGetParametersEnEenvoudigeReturn
		// Custom aanroepen met
		// http://localhost:8080/metMeervoudigeGetParametersEnEenvoudigeReturn?voornaam=Jan&achternaam=Peeters

		return "Uw voornaam is " + voornaam + " en uw achternaam is " + achternaam;
	}

	
	
	@RequestMapping("/zonderParametersEnMeervoudigeGeavanceerdeReturn")
	public ArrayList<Product> zonderParametersEnMeervoudigeGeavanceerdeReturn() {
		// Defaults aanroepen met
		// http://localhost:8080/zonderParametersEnMeervoudigeGeavanceerdeReturn
		ArrayList<Product> producten = new ArrayList<Product>();
		producten.add(new Product("Smartphone", 299.99));
		producten.add(new Product("Laptop", 999.99));
		producten.add(new Product("Smartwatch", 50));
		return producten;
	}

	
	@RequestMapping(value = "/metEnkelvoudigePostParameterEnEenvoudigeReturn", method = RequestMethod.POST)
	public String metEnkelvoudigePostParameterEnEenvoudigeReturn(@RequestBody MultiValueMap<String, String> parameters) {
		// Aanroepen met
		// http://localhost:8080/metEnkelvoudigePostParameterEnEenvoudigeReturn
		// Geef parameter mee in de body: naam=Maarten
		// Content type van de POST request is application/x-www-form-urlencoded
		return "Hallo " + parameters.getFirst("naam") + "!";
	}
	
	@RequestMapping(value = "/metMeervoudigePostParameterEnEenvoudigeReturn", method = RequestMethod.POST)
	public String metMeervoudigePostParameterEnEenvoudigeReturn(@RequestBody MultiValueMap<String, String> parameters) {
		// Aanroepen met
		// http://localhost:8080/metMeervoudigePostParameterEnEenvoudigeReturn
		// Geef parameter mee in de body: achternaam=Heylen&voornaam=Maarten
		// Content type van de POST request is application/x-www-form-urlencoded
		return "Hallo " + parameters.getFirst("voornaam") + " " + parameters.getFirst("achternaam") + "!";
	}
	
	@RequestMapping(value = "/metGeavanceerdePostParameterEnEenvoudigeReturn", method = RequestMethod.POST)
	public String metGeavanceerdePostParameterEnEenvoudigeReturn(@RequestBody Product mijnProduct) {
		// Aanroepen met
		// http://localhost:8080/metGeavanceerdePostParameterEnEenvoudigeReturn
		// Geef parameter mee in de body: {"naam":"Smartphone","prijs":299.99}
		// Content type van de POST request is application/json
		// Default constructor nodig bij Product-klasse voor automatische omzetting van JSON naar objecten
		return "Naam product: " + mijnProduct.getNaam() + ", prijs product: " + mijnProduct.getPrijs();
	}
	
	@RequestMapping(value = "/metGeavanceerdePostParameterLijstEnEenvoudigeReturn", method = RequestMethod.POST)
	public String metGeavanceerdePostParameterLijstEnEenvoudigeReturn(@RequestBody ArrayList<Product> productenLijst) {
		// Aanroepen met
		// http://localhost:8080/metGeavanceerdePostParameterLijstEnEenvoudigeReturn
		// Geef parameter mee in de body: [{"naam":"Smartphone","prijs":299.99},{"naam":"Laptop","prijs":999.99},{"naam":"Smartwatch","prijs":50.0}]
		// Content type van de POST request is application/json
		// Default constructor nodig bij Product-klasse voor automatische omzetting van JSON naar objecten
		String resultaat = "Productenlijst: ";
		for(Product huidigProduct: productenLijst){
			resultaat = resultaat + " " + huidigProduct.getNaam();
		}
		return resultaat;
	}
	
	

}