package com.example.event.controller;

import com.example.event.requestdto.EventDto;
import com.example.event.service.EventService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/event", produces = {MediaType.APPLICATION_JSON_VALUE})
public class EventController {

    @Autowired
    private EventService eventService;


    @GetMapping("/getById/{event-id}")
    public ResponseEntity<Object> getEventDetailsBId(@PathVariable(value = "event-id") int id) {
        return new ResponseEntity<>(eventService.getEventDetailsById(id), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getEventDetailsAll() {
         return new ResponseEntity<>(eventService.getEventDetailsAll(), HttpStatus.OK);
    }

    @GetMapping("/searchEvents")
    public ResponseEntity<Object> searchEvents(@RequestBody EventDto event) {
        return new ResponseEntity<>(eventService.searchEvents(event), HttpStatus.OK);
    }

    @PostMapping("/create")
    public void createEvent(@RequestBody EventDto event) {
        eventService.createEvent(event);

    }
    @PutMapping("/manage")
    public void manageEvent(@RequestBody EventDto event) {
        eventService.createEvent(event);
    }

    @DeleteMapping("/delete/{event-id}")
    public void deleteEvent(@PathVariable(value = "event-id") int id) {
        eventService.deleteEvent(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllEvents() {
        eventService.deleteAllEvents();
    }
}
