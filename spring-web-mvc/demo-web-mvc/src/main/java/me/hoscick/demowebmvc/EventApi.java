package me.hoscick.demowebmvc;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/api/events")
public class EventApi {

    @ExceptionHandler
    public ResponseEntity errorHandle() {
        return ResponseEntity.badRequest().body("can't create event as ...");
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody @Valid Event event, BindingResult bindingResult) {
        // save event
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<Event>(event, HttpStatus.CREATED);
    }
}