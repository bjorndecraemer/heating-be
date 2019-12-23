package com.bjornspetprojects.heatingbe.core.persistence.jpa.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HeatingCalendar {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "heating_calendar_type")
    private HeatingCalendarType type;

    @Column(name = "custom_single_date")
    private int numberValue;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "custom_date_def")
    private int dateDef;

    @Column(name = "temp")
    private int temp;

    @Column(name = "trigger_timestamp")
    private LocalTime triggerTimeStamp;

}
