package com.bjornspetprojects.heatingbe.sensors;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class TempAndHumidityReading {
    private String temperature;
    private String humidity;
}

