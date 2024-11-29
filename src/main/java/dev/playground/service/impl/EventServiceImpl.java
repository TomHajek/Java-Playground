package dev.playground.service.impl;

import dev.playground.mapper.EventMapper;
import dev.playground.persistence.entity.Event;
import dev.playground.persistence.entity.Group;
import dev.playground.persistence.repository.EventRepository;
import dev.playground.persistence.repository.GroupRepository;
import dev.playground.service.EventService;
import dev.playground.persistence.dto.EventDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static dev.playground.mapper.EventMapper.mapToEvent;
import static dev.playground.mapper.EventMapper.mapToEventDto;

@Service
@Transactional
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final GroupRepository groupRepository;


    @Override
    public void createEvent(Long groupId, EventDto eventDto) {
        Group group = groupRepository.findById(groupId).get();
        Event event = mapToEvent(eventDto);
        event.setGroup(group);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events
                .stream()
                .map(EventMapper::mapToEventDto)
                .collect(Collectors.toList());
    }

    @Override
    public EventDto findByEventId(Long eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto) {
        Event event = mapToEvent(eventDto);
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(long eventId) {
        eventRepository.deleteById(eventId);
    }

}
