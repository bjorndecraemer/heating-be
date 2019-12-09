package com.bjornspetprojects.heatingbe.pi.services;

import com.bjornspetprojects.heatingbe.sensors.TempAndHumidityReading;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profile("default")
@Slf4j
public class PiServiceDevImpl implements PiService {

    private Boolean pumpStatus;
    private Boolean burnerStatus;

    @Override
    @PostConstruct
    public void initializePiConfig() {
        pumpStatus = false;
        burnerStatus = false;
        log.debug("Pi configured");
    }

    @Override
    public void activateBurner() {
        burnerStatus = true;
        log.debug("Burner activated");
    }

    @Override
    public void activatePump() {
        pumpStatus = true;
        log.debug("Pump activated");
    }

    @Override
    public void deactivateBurner() {
        burnerStatus = false;
        log.debug("Burner deactivated");
    }

    @Override
    public void deactivatePump() {
        pumpStatus = false;
        log.debug("Pump deactivated");
    }

    @Override
    public Boolean getBurnerStatus() {
        log.debug("Burner status called");
        return burnerStatus;
    }

    @Override
    public Boolean getPumpStatus() {
        log.debug("Pump status called");
        return pumpStatus;
    }
}
