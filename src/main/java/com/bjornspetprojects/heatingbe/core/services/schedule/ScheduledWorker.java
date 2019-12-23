package com.bjornspetprojects.heatingbe.core.services.schedule;

import com.bjornspetprojects.heatingbe.core.services.HeatingService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledWorker {

    private final HeatingService heatingService;

    public ScheduledWorker(HeatingService heatingService) {
        this.heatingService = heatingService;
    }

    @Scheduled(fixedRate = 5000)
    public void checkForChanges(){
        if(!heatingService.getManualStatus()){
            boolean currentBurnerStatus = heatingService.getBurnerStatus();
            boolean currentPumpStatus = heatingService.getPumpStatus();
            long currentTemp = heatingService.getTempReading();
            int requestedTemp = heatingService.getRequestedTemp();

            if(shouldBurnerBeActive(currentTemp,requestedTemp,currentBurnerStatus)){
                heatingService.activateHeating();
            }
            else{
                heatingService.disactivateHeating();
            }

            if(shouldPumpBeActive(currentTemp,requestedTemp,currentPumpStatus)){
                heatingService.activatePump();
            }
            else{
                heatingService.disactivatePump();
            }
        }
    }

    private boolean shouldBurnerBeActive(long currentTemp, Integer requestedTemp, boolean burnerStatus){
        if(requestedTemp == null || requestedTemp == 0){
            return false;
        }
        if(burnerStatus){
            return currentTemp <= requestedTemp;
        }
        else{
            return currentTemp < requestedTemp;
        }
    }

    private boolean shouldPumpBeActive(long currentTemp, Integer requestedTemp, boolean pumpStatus){
        if(requestedTemp == null || requestedTemp <= 0){
            return false;
        }
        if(pumpStatus){
            return currentTemp <= requestedTemp;
        }
        else{
            return currentTemp < requestedTemp;
        }
    }
}
