package com.bjornspetprojects.heatingbe.pi.services;

public interface PiService {
    void initializePiConfig();
    void activateBurner();
    void activatePump();
    void deactivateBurner();
    void deactivatePump();
    Boolean getBurnerStatus();
    Boolean getPumpStatus();

}
