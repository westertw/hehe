package EventApp;

import java.util.List;

public class Event {

    private int id;
    private String title;
    private String text;
    private String date;


    public Event(int id, String title, String text, String date) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public void addEvent(Event event) {
    }

    public List<Event> getAllEvents() {
        return null;
    }
}
