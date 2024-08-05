package com.example.event.service;

import com.example.event.repo.EventRepository;
import static org.mockito.Mockito.*;

import com.example.event.entity.Event;
import com.example.event.requestdto.EventDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EventServiceTest {

    @Mock
    private EventRepository eventRepository;

    @InjectMocks
    private EventService eventService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEventById_success() {
        Event event = new Event();
        event.setId(1);
        when(eventRepository.findById(1)).thenReturn(Optional.of(event));

        EventDto result = eventService.getEventDetailsById(1);
        assertEquals(1, result.getId());
    }

    @Test
    void getEventById_notFound() {
        when(eventRepository.findById(10)).thenReturn(Optional.empty());

        EventDto result = eventService.getEventDetailsById(1);
        assertNull(result);
    }
}
