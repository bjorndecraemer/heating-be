package com.bjornspetprojects.heatingbe.core.persistence.jpa.entities;

import javax.persistence.Entity;

@Entity
public enum HeatingCalendarType {

    EVERY_DAY_OF_WEEK(1),
    All_WEEKDAYS(2),
    ALL_WEEKEND_DAYS(3),
    SINGLE_DAY(4),
    CUSTOM(5);

    private final int value;


    private HeatingCalendarType(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
