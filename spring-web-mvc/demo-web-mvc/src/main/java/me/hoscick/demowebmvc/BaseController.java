package me.hoscick.demowebmvc;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice(assignableTypes = {EventController.class, EventApi.class })
public class BaseController {
    @ExceptionHandler({EventException.class, RuntimeException.class})
    public String eventErrorHandler(RuntimeException ex, Model model) {
        model.addAttribute("message", "runtime error");
        return "error";
    }

    @InitBinder("event")
    public void InitEventBinder(WebDataBinder webDataBinder) {
        webDataBinder.setDisallowedFields("id");    //  받지 않음(바인딩 X)
        webDataBinder.addValidators(new EventValidator());
    }

    @ModelAttribute
    public void categories(Model model) {
        model.addAttribute("categories", List.of("study", "seminar", " hobby", "social"));
    }

/*    @ModelAttribute("categories")
    public List<String> categories(Model model) {
        return List.of("study", "seminar", " hobby", "social");
    }*/
}
