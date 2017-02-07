package lenta;

import lenta.entity.Event;

import java.util.List;

/**
 * Created by Ruslan on 2/7/2017.
 */
public class SimpleLenta implements Lenta {

    private List<Event> events;

    public SimpleLenta(List<Event> events) {
        this.events = events;
    }

    public List<Event> getEventsWithWeights() {
        return events;
    }
}
