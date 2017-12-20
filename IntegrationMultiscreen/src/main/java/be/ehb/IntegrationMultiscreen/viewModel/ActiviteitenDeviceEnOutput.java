/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.ehb.IntegrationMultiscreen.viewModel;

/**
 *
 * @author lione
 */
public class ActiviteitenDeviceEnOutput {
    private int idActiviteitenDeviceEnOutput;
     private int activiteitId;
      private int deviceId;
       private int outputWaarde;

    public int getIdActiviteitenDeviceEnOutput() {
        return idActiviteitenDeviceEnOutput;
    }

    public void setIdActiviteitenDeviceEnOutput(int idActiviteitenDeviceEnOutput) {
        this.idActiviteitenDeviceEnOutput = idActiviteitenDeviceEnOutput;
    }

    public int getActiviteitId() {
        return activiteitId;
    }

    public void setActiviteitId(int activiteitId) {
        this.activiteitId = activiteitId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getOutputWaarde() {
        return outputWaarde;
    }

    public void setOutputWaarde(int outputWaarde) {
        this.outputWaarde = outputWaarde;
    }

    public ActiviteitenDeviceEnOutput(int idActiviteitenDeviceEnOutput, int activiteitId, int deviceId, int outputWaarde) {
        this.idActiviteitenDeviceEnOutput = idActiviteitenDeviceEnOutput;
        this.activiteitId = activiteitId;
        this.deviceId = deviceId;
        this.outputWaarde = outputWaarde;
    }
        public ActiviteitenDeviceEnOutput() {
        }
}
      

