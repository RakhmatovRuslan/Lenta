package lenta;

import lenta.entity.Event;
import lenta.entity.WeightEnum;

import java.util.Collections;
import java.util.List;


/**
 * Created by Ruslan on 2/7/2017.
 */
public class SocialDecorator extends LentaDecorator{
    public SocialDecorator(Lenta lenta, int totalNumberOfFriends) {
        super(lenta);
        this.totalNumberOfFriends = totalNumberOfFriends;
        List<Event> events = super.getEventsWithWeights();
        for (Event event : events) {
            event.getWeights().put(WeightEnum.FACEBOOK, ((double) (event.getFriendsCount())) / totalNumberOfFriends);
        }
        Collections.sort(events, Collections.<Event>reverseOrder());
    }

    @Override
    public List<Event> getEventsWithWeights() {
        return super.getEventsWithWeights();
    }

    private int totalNumberOfFriends;
}
