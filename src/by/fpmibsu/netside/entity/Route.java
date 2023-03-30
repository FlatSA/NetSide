package src.by.fpmibsu.netside.entity;

import java.util.ArrayList;

public class Route extends Entity {
    private User user;
    private ArrayList<String> ipList;
    private Integer length;
    private Rating rating;

    public Route() {
        super();
    }

    public Route(User user, Integer id, Integer length, Rating rating, ArrayList<String> ipList) {
        super(id);
        this.user = user;
        this.length = length;
        this.rating  = rating;
        this.ipList = new ArrayList<>(ipList);
    }

    public User getUser() {
        return user;
    }

    public Rating getRating() {
        return rating;
    }

    public ArrayList<String> getIpList() {
        return new ArrayList<String>(ipList);
    }

    public Integer getLength() {
        return length;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIpList(ArrayList<String> ipList) {
        this.ipList = ipList;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}