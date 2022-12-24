package study.spring.springweb.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class EventController {

    @GetMapping("/events/add")
    public String showEventCreateForm(Model model) {

        model.addAttribute("event", new EventCreate());
        // pre, ongoing, finish
        // List 넘기기, Map 넘기기
        model.addAttribute("statuses", Map.of("pre", "시작전", "ongoing", "진행중", "finish", "마감"));
        return "events/create-form";
    }

    @PostMapping("/events/add")
    public String processCreateEvent(@ModelAttribute EventCreate create) {
        System.out.println(create);
        return "redirect:/";
    }
}
