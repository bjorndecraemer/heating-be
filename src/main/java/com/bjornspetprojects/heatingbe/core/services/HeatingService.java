package com.bjornspetprojects.heatingbe.core.services;

public interface HeatingService {
    void activateHeating();
    void disactivateHeating();
    void activatePumpPermanently();
    void disactivatePump();
    void disactivateAll();
    void activateAll();
    Boolean getPumpStatus();
    Boolean getBurnerStatus();

    void activatePumpWithInterval(Integer intervalValue);
}
