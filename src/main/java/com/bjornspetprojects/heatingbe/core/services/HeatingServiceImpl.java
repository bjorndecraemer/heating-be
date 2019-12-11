package com.bjornspetprojects.heatingbe.core.services;

import com.bjornspetprojects.heatingbe.pi.services.PiService;
import com.bjornspetprojects.heatingbe.sensors.TempAndHumidityReading;
import org.springframework.stereotype.Service;

@Service
public class HeatingServiceImpl implements HeatingService {

    private final PiService piService;
    private Long temp;
    private Long humidity;

    public HeatingServiceImpl(PiService piService) {
        this.piService = piService;
    }

    @Override
    public void activateHeating() {
        piService.activateBurner();
    }

    @Override
    public void disactivateHeating() {
        piService.deactivateBurner();
    }

    @Override
    public void activatePump() {
        piService.activatePump();
    }

    @Override
    public void disactivatePump() {
        piService.deactivatePump();
    }

    @Override
    public void disactivateAll() {
        disactivateHeating();
        disactivatePump();
    }

    @Override
    public void activateAll() {
        activateHeating();
        activatePump();
    }

    @Override
    public Boolean getPumpStatus() {
        return piService.getPumpStatus();
    }

    @Override
    public Boolean getBurnerStatus() {
        return piService.getBurnerStatus();
    }

    @Override
    public void newReadings(TempAndHumidityReading tempAndHumidityReading) {
        if(tempAndHumidityReading != null){
            Long newTemp = tempAndHumidityReading.getTemperature();
            Long newHumidity = tempAndHumidityReading.getHumidity();
            if(newTemp != null){
                this.temp = newTemp;
            }
            if(newHumidity != null){
                this.humidity = newHumidity;
            }
        }
    }

    @Override
    public Long getTempReading() {
        return this.temp;
    }

    @Override
    public Long getHumidityReading() {
        return this.humidity;
    }
}
