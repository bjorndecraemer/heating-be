package com.bjornspetprojects.heatingbe.sensors;

import com.bjornspetprojects.heatingbe.core.services.HeatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/sensors/")
public class SensorsController {

    private final HeatingService heatingService;

    public SensorsController(HeatingService heatingService) {
        this.heatingService = heatingService;
    }

    @PutMapping("newreadings")
    public ResponseEntity newReadings(@RequestBody TempAndHumidityReading tempAndHumidityReading){
        heatingService.newReadings(tempAndHumidityReading);
        return ResponseEntity.ok().build();
    }

}
