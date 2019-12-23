package com.bjornspetprojects.heatingbe.fecontrols.web.in;

import com.bjornspetprojects.heatingbe.core.services.HeatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/fecontrol/")
@CrossOrigin
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
            heatingService.activatePump();
        }
        else{
            heatingService.disactivatePump();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("manual")
    public ResponseEntity setManual(@RequestParam Boolean setting){
        if(setting){
            heatingService.activateManual();
        }
        else{
            heatingService.deactivateManual();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("requestedtemp")
    public ResponseEntity setRequestedTemp(@RequestParam Integer value){
        heatingService.setRequestedTemp(value);
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

    @GetMapping("manual")
    public ResponseEntity<Boolean> getManualSetting(){
        return ResponseEntity.ok(heatingService.getManualStatus());
    }


    @GetMapping("temp")
    public ResponseEntity<String> getTemperature(){
        String tempString = null;
        if(heatingService.getTempReading() != null){
            tempString = ""+heatingService.getTempReading();
        }
        return ResponseEntity.ok(tempString);
    }


    @GetMapping("humidity")
    public ResponseEntity<String> getHumidity(){
        String humidityString = null;
        if(heatingService.getHumidityReading() != null) {
            humidityString = ""+heatingService.getHumidityReading();
        }
        return ResponseEntity.ok(humidityString);
    }

    @GetMapping("requestedtemp")
    public ResponseEntity<Integer> getRequestedTemp(){
        if(heatingService.getRequestedTemp() != null) {
            return ResponseEntity.ok(heatingService.getRequestedTemp());
        }
        return ResponseEntity.ok(0);
    }
}
