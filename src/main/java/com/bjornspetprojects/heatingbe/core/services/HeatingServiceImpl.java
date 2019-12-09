package com.bjornspetprojects.heatingbe.core.services;

import com.bjornspetprojects.heatingbe.pi.services.PiService;
import org.springframework.stereotype.Service;

import java.util.Timer;

@Service
public class HeatingServiceImpl implements HeatingService {

    private final PiService piService;
    private final  PumpTimerTask pumpTimerTask;
    private final Timer timer = new Timer(true);

    public HeatingServiceImpl(PiService piService, PumpTimerTask pumpTimerTask) {
        this.piService = piService;
        this.pumpTimerTask = pumpTimerTask;
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
    public void activatePumpPermanently() {
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
        activatePumpPermanently();
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
    public void activatePumpWithInterval(Integer intervalValue) {
        if(intervalValue == 100){
            activatePumpPermanently();
        }
        if(intervalValue == 0){
            disactivatePump();
        }
        else{
            initiatePumpInterval(intervalValue);
        }
    }

    private void initiatePumpInterval(Integer intervalValue) {
        timer.cancel();
        timer.purge();
        timer.scheduleAtFixedRate(pumpTimerTask,0, 10000);
    }

    private long calculateIntervalMiliseconds(Integer intervalValue){
        long value = intervalValue*1000
    }
}
