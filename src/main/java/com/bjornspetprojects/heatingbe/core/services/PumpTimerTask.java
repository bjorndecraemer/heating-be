package com.bjornspetprojects.heatingbe.core.services;

import com.bjornspetprojects.heatingbe.pi.services.PiService;
import org.springframework.stereotype.Service;

import java.util.TimerTask;

@Service
public class PumpTimerTask extends TimerTask {

    private final PiService piService;

    public PumpTimerTask(PiService piService) {
        this.piService = piService;
    }

    @Override
    public void run() {
        switchPumpValue();
    }

    private void switchPumpValue(){
        if(piService.getPumpStatus()){
            piService.deactivatePump();
        }
        else{
            piService.activatePump();
        }
    }
}
