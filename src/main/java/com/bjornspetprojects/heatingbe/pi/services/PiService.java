package com.bjornspetprojects.heatingbe.pi.services;

import com.bjornspetprojects.heatingbe.sensors.TempAndHumidityReading;

public interface PiService {
    void initializePiConfig();
    void activateBurner();
    void activatePump();
    void deactivateBurner();
    void deactivatePump();
    Boolean getBurnerStatus();
    Boolean getPumpStatus();
}
