package com.bjornspetprojects.heatingbe.core.persistence;

import com.bjornspetprojects.heatingbe.core.persistence.jpa.entities.HeatingCalendar;

import java.util.List;
import java.util.Optional;

public interface HeatingCalendarService {
    Optional<List<HeatingCalendar>> findAll();
    Optional<HeatingCalendar> findById(Long id);
    Optional<HeatingCalendar> createOrUpdate(HeatingCalendar heatingCalendar);
}
