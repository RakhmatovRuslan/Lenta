package lenta;

import lenta.entity.EventType;

import java.util.Map;

/**
 * Created by Ruslan on 2/10/2017.
 */
public class InterestDecorator extends LentaDecorator {
    public InterestDecorator(Lenta lenta, Map<EventType,Integer> userStaticData) {
        super(lenta);
    }
    private Map<EventType, Integer> userStaticData;
}
