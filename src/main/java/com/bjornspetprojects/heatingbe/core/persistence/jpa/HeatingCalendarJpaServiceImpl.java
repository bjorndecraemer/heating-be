package com.bjornspetprojects.heatingbe.core.persistence.jpa;

import com.bjornspetprojects.heatingbe.core.persistence.HeatingCalendarService;
import com.bjornspetprojects.heatingbe.core.persistence.jpa.entities.HeatingCalendar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HeatingCalendarJpaServiceImpl implements HeatingCalendarService {

    @Override
    public Optional<List<HeatingCalendar>> findAll() {
        return Optional.empty();
    }

    @Override
    public Optional<HeatingCalendar> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<HeatingCalendar> createOrUpdate(HeatingCalendar heatingCalendar) {
        return Optional.empty();
    }
}
