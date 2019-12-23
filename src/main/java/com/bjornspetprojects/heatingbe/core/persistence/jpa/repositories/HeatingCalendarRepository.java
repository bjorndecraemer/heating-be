package com.bjornspetprojects.heatingbe.core.persistence.jpa.repositories;

import com.bjornspetprojects.heatingbe.core.persistence.jpa.entities.HeatingCalendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeatingCalendarRepository extends JpaRepository<HeatingCalendar, Long> {
}
