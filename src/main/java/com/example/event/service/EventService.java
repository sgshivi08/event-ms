package com.example.event.service;

import com.example.event.requestdto.EventDto;

import java.util.Date;
import java.util.List;

public interface EventService {

    EventDto getEventDetailsById(int id);
    List<EventDto> getEventDetailsByLocation(String eventLocation);

    List<EventDto> getEventDetailsByName(String eventName);

    List<EventDto> getEventDetailsByDate(Date eventDate);

    List<EventDto> getEventDetailsAll();

    void createEvent(EventDto event);

    List<EventDto> searchEvents(EventDto eventDto);

    void manageEvent(Integer id , EventDto event);

    void deleteEvent(int id);

    void deleteAllEvents();
}
