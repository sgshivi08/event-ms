package com.example.event.service;

import com.example.event.entity.Event;
import com.example.event.requestdto.EventDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface EventService {

    EventDto getEventDetailsById(int id);
    List<EventDto> getEventDetailsByLocation(String eventLocation);

    List<EventDto> getEventDetailsByName(String eventName);

    List<EventDto> getEventDetailsByDate(Date eventDate);

    List<EventDto> getEventDetailsAll();

    void createEvent(EventDto event);

    List<EventDto> searchEvents(EventDto eventDto);

    void manageEvent(EventDto event);

    void deleteEvent(int id);

    void deleteAllEvents();
}
