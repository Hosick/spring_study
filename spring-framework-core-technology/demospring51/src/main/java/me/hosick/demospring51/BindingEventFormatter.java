package me.hosick.demospring51;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class BindingEventFormatter implements Formatter<BindingEvent> {

    @Override
    public BindingEvent parse(String text, Locale locale) throws ParseException {
        return new BindingEvent(Integer.parseInt(text));
    }

    @Override
    public String print(BindingEvent object, Locale locale) {
        return object.getId().toString();
    }
}
