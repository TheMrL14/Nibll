/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
/**
 *
 * @author MaartenH
 */
@SpringBootApplication
@CrossOrigin
public class Webservice {
        public static void main(String[] args) {
        SpringApplication.run(Webservice.class, args);
    
        }
    
}
