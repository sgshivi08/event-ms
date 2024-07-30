package com.example.event.service.Impl;

import com.example.event.entity.Event;
import com.example.event.repo.Eventrepository;
import com.example.event.requestdto.EventDto;
import com.example.event.service.EventService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private Eventrepository eventrepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EventDto getEventDetailsById(int id) {
        return modelMapper.map(eventrepository.findById(id), EventDto.class);
    }

    @Override
    public List<EventDto> getEventDetailsByName(String eventName) {
        List<Event> eventList = eventrepository.findByEventName(eventName);

        return eventList.stream().map(e -> {
            return modelMapper.map(e, EventDto.class);
        }).toList();

    }

    @Override
    public List<EventDto> getEventDetailsByLocation(String eventLocation) {
        List<Event> eventList = eventrepository.findByEventLocation(eventLocation);

        return eventList.stream().map(e -> {
            return modelMapper.map(e, EventDto.class);
        }).toList();
    }

    @Override
    public List<EventDto> getEventDetailsByDate(Date eventDate) {
        List<Event> eventList = eventrepository.findByEventDate(eventDate);

        return eventList.stream().map(e -> {
            return modelMapper.map(e, EventDto.class);
        }).toList();
    }

    @Override
    public List<EventDto> getEventDetailsAll() {
        List<Event> eventList = eventrepository.findAll();

        return eventList.stream().map(e -> {
            return modelMapper.map(e, EventDto.class);
        }).toList();
    }


    @Override
    public void createEvent(EventDto eventDto) {
        eventrepository.save(modelMapper.map(eventDto, Event.class));
    }

    @Override
    public List<EventDto> searchEvents(EventDto eventDto) {
        List<Event> eventList =  eventrepository.searchEvents(eventDto.getEventName(),eventDto.getEventdate(),eventDto.getEventTime(), eventDto.getEventLocation());
         return eventList.stream().map(e -> {
            return modelMapper.map(e, EventDto.class);
        }).toList();
    }

    @Override
    public void manageEvent(EventDto eventDto) {
        eventrepository.save(modelMapper.map(eventDto, Event.class));
    }

    @Override
    public void deleteEvent(int id) {
        eventrepository.deleteById(id);
    }

    @Override
    public void deleteAllEvents() {
        eventrepository.deleteAll();
    }

}
