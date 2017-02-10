package lenta;

import lenta.entity.Event;
import lenta.entity.WeightEnum;

import java.util.Collections;
import java.util.List;

/**
 * Created by Ruslan on 2/7/2017.
 */
public class LocationDecorator extends LentaDecorator {


    public LocationDecorator(Lenta lenta) {
        super(lenta);
        List<Event> events = super.getEventsWithWeights();
        for (Event event : events) {
            event.getWeights().put(WeightEnum.LOCATION, 1 - event.getDistance() / FURTHEST_DISTANCE);
        }
        Collections.sort(events, Collections.<Event>reverseOrder());
    }


    /**
     * This method returns the
     *
     * @return
     */
    @Override
    public List<Event> getEventsWithWeights() {
        return super.getEventsWithWeights();
    }

    // Furthest distance on the earth. You can consider the furthest only in local regions (like only in South Korea)
    private static final Double FURTHEST_DISTANCE = 20036.0;
}
