/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.webservice;

import be.ehb.IntegrationMultiscreen.DAO.DeviceDAO;
import be.ehb.IntegrationMultiscreen.model.Device;
import java.util.ArrayList;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ilhan
 */
public class GPIOController {

    public void logDevices() {
    }

    public GPIOController() {
        initializeGPIOController();
    }

    private void initializeGPIOController() {
        int timerMillis = 1000;
        
        Timer gpioSetTimer = new Timer();
        gpioSetTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateGPIODevices();
            }
        }, 0, timerMillis);
    }

    ArrayList<Device> allDevicesOldState;
    private void updateGPIODevices() {
        ArrayList<Device> allDevices = DeviceDAO.getDevice();
        int amountofDevices = allDevices.size();
        for (int i = 0; i < amountofDevices; i++) {
            boolean newStatusSelectedDevice = allDevices.get(i).getStatus();
            boolean oldStatusSelectedDevice;
            try {
                oldStatusSelectedDevice = allDevicesOldState.get(i).getStatus();
            } catch (NullPointerException ex) {
                oldStatusSelectedDevice = !newStatusSelectedDevice;
            }
            if (newStatusSelectedDevice != oldStatusSelectedDevice) {

                String link433 = "http://nibll.local:5001/send?protocol=kaku_switch&id=27672578&unit=" + Integer.toString(i);
                if (newStatusSelectedDevice) {
                    link433 += "&on=1";
                } else {
                    link433 += "&off=1";
                }

                try {
                    sendGET(link433);
                    sendGET("http://nibll.local:5000/play/plop.mp3"); //Plop sound after change
                } catch (IOException ex) {
                    Logger.getLogger(GPIOController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        allDevicesOldState = allDevices;
    }

    private void sendGET(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            con.getInputStream();
        }
    }

}
