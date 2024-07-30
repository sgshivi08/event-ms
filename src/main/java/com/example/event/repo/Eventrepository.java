package com.example.event.repo;

import com.example.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface Eventrepository extends JpaRepository<Event, Integer> {

    // Find event by ID (already provided by JpaRepository with findById method)

    // Find event by name
    List<Event> findByEventName(String eventName);

    // Find event by location
    List<Event> findByEventLocation(String eventLocation);

    // Find event by date
    List<Event> findByEventDate(Date eventDate);

    @Query("SELECT e FROM Event e WHERE "
            + "(:eventName IS NULL OR e.eventName = :eventName) AND "
            + "(:eventDate IS NULL OR e.eventDate = :eventDate) AND "
            + "(:eventTime IS NULL OR e.eventTime = :eventTime) AND "
            + "(:eventLocation IS NULL OR e.eventLocation = :eventLocation)")
    List<Event> searchEvents(
            @Param("eventName") String eventName,
            @Param("eventDate") LocalDate eventDate,
            @Param("eventTime") LocalTime eventTime,
            @Param("eventLocation") String eventLocation);

}
