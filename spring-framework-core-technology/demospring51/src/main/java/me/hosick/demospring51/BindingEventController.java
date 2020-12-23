package me.hosick.demospring51;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BindingEventController {

    /*@InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.registerCustomEditor(BindingEvent.class, new BindingEventEditor());
    }*/

    @GetMapping("/event/{event}")
    public String getEvent(@PathVariable BindingEvent event) {
        System.out.println(event);
        return event.getId().toString();
    }
}