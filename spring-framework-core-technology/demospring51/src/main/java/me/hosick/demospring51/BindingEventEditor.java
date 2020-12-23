package me.hosick.demospring51;

import java.beans.PropertyEditorSupport;

public class BindingEventEditor extends PropertyEditorSupport {

    @Override
    public String getAsText() {
        BindingEvent event = (BindingEvent) getValue();
        return event.getId().toString();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(new BindingEvent(Integer.parseInt(text)));
    }
}
