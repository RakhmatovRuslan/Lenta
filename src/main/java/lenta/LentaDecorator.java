package lenta;

import lenta.entity.Event;

import java.util.List;

/**
 * Created by Ruslan on 2/7/2017.
 */
public class LentaDecorator implements Lenta {

    Lenta lenta;

    public LentaDecorator(Lenta lenta) {
        this.lenta = lenta;
    }

    public List<Event> getEventsWithWeights() {
        return lenta.getEventsWithWeights();
    }
}
