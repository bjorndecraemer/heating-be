package com.bjornspetprojects.heatingbe.fecontrols.web.in;

import com.bjornspetprojects.heatingbe.core.services.HeatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/fecontrol/")
public class HeatingFrontendController {

    private final HeatingService heatingService;

    public HeatingFrontendController(HeatingService heatingService) {
        this.heatingService = heatingService;
    }

    @PutMapping("heating")
    public ResponseEntity setHeating(@RequestParam Boolean setting){
        if(setting){
            heatingService.activateAll();
        }
        else{
            heatingService.disactivateAll();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("burner")
    public ResponseEntity setBurner(@RequestParam Boolean setting){
        if(setting){
            heatingService.activateHeating();
        }
        else{
            heatingService.disactivateHeating();
        }
        return ResponseEntity.ok().build();
    }
    @PutMapping("pump")
    public ResponseEntity setPump(@RequestParam Boolean setting){
        if(setting){
            heatingService.activatePumpPermanently();
        }
        else{
            heatingService.disactivatePump();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("pumpinterval")
    public ResponseEntity setPumpInterval(@RequestParam Integer intervalValue){
        if(intervalValue > 0){
            heatingService.activatePumpWithInterval(intervalValue);
        }
        else{
            heatingService.disactivatePump();
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("burner")
    public ResponseEntity<Boolean> getBurnerSetting(){
        return ResponseEntity.ok(heatingService.getBurnerStatus());
    }

    @GetMapping("pump")
    public ResponseEntity<Boolean> getPumpSetting(){
        return ResponseEntity.ok(heatingService.getPumpStatus());
    }
}
