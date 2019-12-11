package com.bjornspetprojects.heatingbe.core.services;

import com.bjornspetprojects.heatingbe.sensors.TempAndHumidityReading;

public interface HeatingService {
    void activateHeating();
    void disactivateHeating();
    void activatePump();
    void disactivatePump();
    void disactivateAll();
    void activateAll();
    void activateManual();
    void deactivateManual();
    Boolean getPumpStatus();
    Boolean getBurnerStatus();
    Boolean getManualStatus();
    void newReadings(TempAndHumidityReading tempAndHumidityReading);

    Long getTempReading();

    Long getHumidityReading();
}
