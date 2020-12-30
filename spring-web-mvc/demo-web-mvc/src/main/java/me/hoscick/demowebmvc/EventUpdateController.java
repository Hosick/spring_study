package me.hoscick.demowebmvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class EventUpdateController {

    @PostMapping(value = "/events", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String createEvent() {
        return "events";
    }

    @PutMapping(value = "events/{id}", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public String updateAnEvent(@PathVariable int id) {
        return "events";
    }
}
