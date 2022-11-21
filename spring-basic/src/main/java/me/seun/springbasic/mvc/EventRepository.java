package me.seun.springbasic.mvc;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class EventRepository {
    private Long sequence = 0L;
    private Map<Long, Event> events = new HashMap<>() {{
        put(++sequence, new Event("스터디", "스프링 공부"));
    }};

    public Long save(Event event) {
        events.put(++sequence, event);
        return sequence;
    }

    public Event findById(Long id) {
        return events.get(id);
    }

}
