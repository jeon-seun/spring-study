package me.seun.springbasic.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 이벤트 생성, 이벤트 조회
 */
@Controller
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path = {"/events/{eventId}", "/events"})
    public String showEvents(@PathVariable(required = false) Long eventId, Model model) {
        if (eventId == null) {
            eventId = 1L;
        }

        Event event = eventService.findById(eventId);
        model.addAttribute("event", event);
        model.addAttribute("eventId", eventId);
        return "event";
    }

    @PostMapping("/events/{eventId}")
    public String processEventUpdate(@PathVariable Long eventId,
                                     @ModelAttribute Event event) {
        eventService.update(eventId, event);
        return "redirect:/events/{eventId}";
    }

    @GetMapping("/events/add")
    public String showEventCreateForm() {
        return "eventCreateForm";
    }

    @PostMapping("/events/add")
    public String processEventCreate(@ModelAttribute Event event) {
        Long eventId = eventService.save(event);
        return "redirect:/events/" + eventId;
    }
}
