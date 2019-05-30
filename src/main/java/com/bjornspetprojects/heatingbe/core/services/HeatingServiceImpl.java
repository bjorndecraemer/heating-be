package com.bjornspetprojects.heatingbe.core.services;

import com.bjornspetprojects.heatingbe.pi.services.PiService;
import org.springframework.stereotype.Service;

@Service
public class HeatingServiceImpl implements HeatingService {

    private final PiService piService;

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
}
