package com.bjornspetprojects.heatingbe.websocket;

import com.bjornspetprojects.heatingbe.core.services.HeatingService;
import org.springframework.stereotype.Service;

@Service
public class StompMessageHandler {

    private final HeatingService heatingService;

    public StompMessageHandler(HeatingService heatingService) {
        this.heatingService = heatingService;
    }

    void handleFeStateMessage(FeState feState){
        if(feState != null){
            switch (feState.getFeStateType()){
                case MANUAL_PUMP_ON: heatingService.activatePump();break;
                case MANUAL_PUMP_OFF: heatingService.disactivatePump();break;
                case MANUAL_BURNER_ON: heatingService.activateHeating();break;
                case MANUAL_BURNER_OFF: heatingService.disactivateHeating();break;
                case AUTO_TEMP_ON: System.out.println("AUTO_TEMP_ON - To be implemented");break;
                case AUTO_TEMP_OFF: System.out.println("AUTO_TEMP_OFF - To be implemented");break;
                case THERMO_TEMP: System.out.println("THERMO_TEMP_OFF - To be implemented");break;
                case KILLSWITCH_ON: System.out.println("KILLSWITCH_ON - To be implemented");break;
                case KILLSWITCH_OFF: System.out.println("KILLSWITCH_OFF - To be implemented");break;
            }
        }
    }
}
