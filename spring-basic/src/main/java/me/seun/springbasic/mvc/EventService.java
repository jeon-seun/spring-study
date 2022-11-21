package me.seun.springbasic.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event findById(Long id) {
        return eventRepository.findById(id);
    }

    public Long save(Event event) {
        return eventRepository.save(event);
    }

    public void update(Long id, Event event) {
        Event targetEvent = eventRepository.findById(id);
        // 찾아온 이벤트의 값을 변경해주기
        targetEvent.setName(event.getName());
        targetEvent.setDescription(event.getDescription());
    }
}
