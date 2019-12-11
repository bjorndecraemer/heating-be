package com.bjornspetprojects.heatingbe.core.services;

import com.bjornspetprojects.heatingbe.sensors.TempAndHumidityReading;

public interface HeatingService {
    void activateHeating();
    void disactivateHeating();
    void activatePump();
    void disactivatePump();
    void disactivateAll();
    void activateAll();
    Boolean getPumpStatus();
    Boolean getBurnerStatus();
    void newReadings(TempAndHumidityReading tempAndHumidityReading);

    Long getTempReading();

    Long getHumidityReading();
}
