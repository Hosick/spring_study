package me.hosick.demospring51;

import org.springframework.core.convert.converter.Converter;

public class BindingEventConverter {

    public static class StringToEventConverter implements Converter<String, BindingEvent> {
        @Override
        public BindingEvent convert(String source) {
            return new BindingEvent(Integer.parseInt(source));
        }
    }

    public static class EventToStringCoverter implements Converter<BindingEvent, String> {
        @Override
        public String convert(BindingEvent source) {
            return source.getId().toString();
        }
    }
}