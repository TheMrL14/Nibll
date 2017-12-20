/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.wc7_1.webservice;

import com.mycompany.wc7_1.dao.PlanetenDao;
import com.mycompany.wc7_1.model.Planeet;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lionel
 */
@RestController
@RequestMapping("Planeet")
public class PlaneetController {
    @RequestMapping("/getAll")
    public ArrayList<Planeet> getall(){
    ArrayList<Planeet> planeten = PlanetenDao.getPlaneet();
    return planeten;
    }
}
