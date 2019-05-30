package com.bjornspetprojects.heatingbe.core.services;

public interface HeatingService {
    void activateHeating();
    void disactivateHeating();
    void activatePump();
    void disactivatePump();
    void disactivateAll();
    void activateAll();
    Boolean getPumpStatus();
    Boolean getBurnerStatus();
}
