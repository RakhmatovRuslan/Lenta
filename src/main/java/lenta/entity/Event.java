package lenta.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ruslan on 2/7/2017.
 */
public class Event implements Comparable<Event>{

    private Long ID;
    private Double distance;
    private Integer friendsCount;
    private Double totalWeight;
    private HashMap<WeightEnum,Double> weights;

    public Event(Long ID, Double distance, Integer friendsCount) {
        this.ID = ID;
        this.distance = distance;
        this.friendsCount = friendsCount;
        totalWeight = 0.0;
        weights = new HashMap<WeightEnum, Double>();
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getFriendsCount() {
        return friendsCount;
    }

    public void setFriendsCount(Integer friendsCount) {
        this.friendsCount = friendsCount;
    }

    public HashMap<WeightEnum, Double> getWeights() {
        return weights;
    }

    public Double getTotalWeight() {
        if(this.totalWeight == 0.0)
        for(Map.Entry<WeightEnum, Double> entry : weights.entrySet()){
            totalWeight += entry.getValue();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Event{" +
                "ID=" + ID +
                ", distance=" + distance +
                ", friendsCount=" + friendsCount +
                ", totalWeight=" + totalWeight +
                '}';
    }

     public int compareTo(Event other) {
        return Double.compare(this.getTotalWeight(),other.getTotalWeight());
    }
}
