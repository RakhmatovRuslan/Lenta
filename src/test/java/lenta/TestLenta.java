package lenta;

import lenta.entity.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Ruslan on 2/7/2017.
 */
public class TestLenta {

    List<Event> eventsWithLocationWeights;
    List<Event> eventsWithSocialWeights;
    List<Event> eventsWithLocationAndSocialWeights;

    Lenta lenta;


    public static List<Event> getEvents() {
        return Arrays.asList(
                new Event(1L,100.0,6)
                ,new Event(20L,55.0,2)
                ,new Event(6L,35.0,2)
                ,new Event(36L,1000.0,2)
                ,new Event(4L,60.5,10)
        );
    }

    @Before
    public void initData() {
        // Location Decorator test
        lenta = new LocationDecorator(new SimpleLenta(getEvents()));
        eventsWithLocationWeights = lenta.getEventsWithWeights();

        // Social Decorator test
        lenta = new SocialDecorator(new SimpleLenta(getEvents()), 100);
        eventsWithSocialWeights = lenta.getEventsWithWeights();

        // Location and Social Decorator test
        lenta = new LocationDecorator(new SocialDecorator(new SimpleLenta(getEvents()), 100));
        eventsWithLocationAndSocialWeights = lenta.getEventsWithWeights();
    }

    @Test
    public void testLocationDecorator(){

        Assert.assertEquals(6L,eventsWithLocationWeights.get(0).getID().longValue());
        System.out.println(eventsWithLocationWeights);

        Assert.assertEquals(4L,eventsWithSocialWeights.get(0).getID().longValue());
        System.out.println(eventsWithSocialWeights);

        Assert.assertEquals(4L, eventsWithLocationAndSocialWeights.get(0).getID().longValue());
        System.out.println(eventsWithLocationAndSocialWeights);
    }

}
