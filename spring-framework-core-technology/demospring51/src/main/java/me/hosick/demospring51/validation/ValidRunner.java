package me.hosick.demospring51.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;

@Component
public class ValidRunner implements ApplicationRunner {

    @Autowired
    Validator validator;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out. println("\n### validation ###");

        System.out.println(validator.getClass());

        Event event = new Event();
        event.setLimit(-1);
        event.setEmail("abcd");
        Errors errors = new BeanPropertyBindingResult(event, "event");

        validator.validate(event, errors);

        System.out.println("    hasErrors? " + errors.hasErrors());

        errors.getAllErrors().forEach(e -> {
            System.out.println("    ===== error code =====");
            Arrays.stream(e.getCodes()).map(ee -> "    " + ee).forEach(System.out::println);
            System.out.println("    " + e.getDefaultMessage());
        });
    }
}
