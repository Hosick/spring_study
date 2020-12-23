package me.hosick.demospring51;

public class BindingEvent {

    private Integer id;

    private String title;

    public BindingEvent(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BindingEvent{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
