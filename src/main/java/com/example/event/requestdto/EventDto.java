package com.example.event.requestdto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDto {

    @JsonProperty("event_id")
    private Integer id;

    @JsonProperty("event_name")
    private String eventName;

    @JsonProperty("event_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate eventdate;

    @Column(name = "event_time")
    private LocalTime eventTime;

    @JsonProperty("event_location")
    private String eventLocation;


}
