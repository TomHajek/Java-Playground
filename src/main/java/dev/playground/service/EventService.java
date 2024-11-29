package dev.playground.service;

import dev.playground.persistence.dto.EventDto;
import java.util.List;

public interface EventService {

    void createEvent(Long groupId, EventDto eventDto);
    List<EventDto> findAllEvents();
    EventDto findByEventId(Long eventId);
    void updateEvent(EventDto eventDto);
    void deleteEvent(long eventId);

}
