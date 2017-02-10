package lenta;

import lenta.entity.Event;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by User on 2/10/2017.
 */
@RunWith(value = Parameterized.class)
public class TestLentaParametrized {
    Integer objectNumber;
    List<Event> events;
    List<Event> eventsWithLocationWeights;
    List<Event> eventsWithSocialWeights;
    List<Event> eventsWithLocationAndSocialWeights;
    // Lenta lenta;

    public TestLentaParametrized(Integer objectNumber) {
        //this.lenta = lenta;
        this.objectNumber = objectNumber;
    }

    @Parameterized.Parameters
    public static Collection lentaObjects() {

        Object[][] objects = new Object[][]{{0}, {1}, {2}};

        return Arrays.asList(objects);
    }


    @Before
    public void initData() {
        events = Arrays.asList(
                new Event(1L, 100.0, 6)
                , new Event(20L, 55.0, 2)
                , new Event(6L, 35.0, 2)
                , new Event(36L, 1000.0, 2)
                , new Event(4L, 60.5, 10)
        );

        switch (objectNumber) {
            case 0:
                eventsWithLocationWeights = new LocationDecorator(new SimpleLenta(events)).getEventsWithWeights();
                break;
            case 1:
                eventsWithSocialWeights = new SocialDecorator(new SimpleLenta(events), 100).getEventsWithWeights();
                break;
            case 2:
                eventsWithLocationAndSocialWeights = new LocationDecorator(new SocialDecorator(new SimpleLenta(events), 100)).getEventsWithWeights();
        }
    }

    @Test
    public void testAllDecorators() {
        System.out.println(events);
        switch (objectNumber) {
            case 0:
                Assert.assertEquals(6L, eventsWithLocationWeights.get(0).getID().longValue());
                break;
            case 1:
                Assert.assertEquals(4L, eventsWithSocialWeights.get(0).getID().longValue());
                break;
            case 2:
                Assert.assertEquals(4L, eventsWithLocationAndSocialWeights.get(0).getID().longValue());
        }
    }
}
