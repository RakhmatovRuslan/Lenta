package lenta;

import lenta.entity.Event;
import lenta.entity.WeightEnum;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Ruslan on 2/7/2017.
 */
public class LocationDecorator extends LentaDecorator {

    public LocationDecorator(Lenta lenta) {
        super(lenta);
    }

    @Override
    public List<Event> getEventsWithWeights(){
        //TODO remove after implementation
        Random random = new Random();
        List<Event> events = super.getEventsWithWeights();
        for (Event event : events) {
            event.getWeights().put(WeightEnum.LOCATION,random.nextDouble());
        }
        Collections.sort(events);
        return events;
    }
}
