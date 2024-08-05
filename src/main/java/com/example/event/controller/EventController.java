package com.example.event.controller;

import com.example.event.requestdto.EventDto;
import com.example.event.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> createEvent(@RequestBody EventDto event) {
        try {
            eventService.createEvent(event);
            return ResponseEntity.ok("Event created successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error creating event: " + e.getMessage());
        }

    }

    @PutMapping("/manage")
    public ResponseEntity<String> manageEvent(@RequestBody EventDto event) {
        try {
            eventService.createEvent(event);
            return ResponseEntity.ok("Event managed successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error managing event: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete/{event-id}")
    public ResponseEntity<String> deleteEvent(@PathVariable(value = "event-id") int id) {
        try {
            eventService.deleteEvent(id);
            return ResponseEntity.ok("Event deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting event: " + e.getMessage());
        }
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAllEvents() {
        try {
            eventService.deleteAllEvents();
            return ResponseEntity.ok("All events deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error deleting all events: " + e.getMessage());
        }
    }
}
