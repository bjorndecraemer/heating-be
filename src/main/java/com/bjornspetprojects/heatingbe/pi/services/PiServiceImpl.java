package com.bjornspetprojects.heatingbe.pi.services;

import com.bjornspetprojects.heatingbe.sensors.TempAndHumidityReading;
import com.pi4j.io.gpio.*;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Profile("pi")
public class PiServiceImpl implements PiService {

    private final GpioController gpio = GpioFactory.getInstance();
    private GpioPinDigitalOutput myPump;
    private GpioPinDigitalOutput myBurner;

    private Long temp;
    private Long humidity;

    @Override
    @PostConstruct
    public void initializePiConfig() {
        myPump = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01,   // PIN NUMBER
                "Pump",           // PIN FRIENDLY NAME (optional)
                PinState.LOW);
        myBurner = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04,   // PIN NUMBER
                "Burner",           // PIN FRIENDLY NAME (optional)
                PinState.LOW);
    }

    @Override
    public void activateBurner() {
        myBurner.high();
    }

    @Override
    public void activatePump() {
        myPump.high();
    }

    @Override
    public void deactivateBurner() {
        myBurner.low();
    }

    @Override
    public void deactivatePump() {
        myPump.low();
    }

    @Override
    public Boolean getBurnerStatus() {
        return myBurner.isHigh();
    }

    @Override
    public Boolean getPumpStatus() {
        return myPump.isHigh();
    }

}
