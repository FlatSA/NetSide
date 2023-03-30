package src.by.fpmibsu.netside.entity;

import java.util.List;
import java.net.InetAddress;

public class Route extends Entity {
    private User user;
    private List<InetAddress> ipList;
    private Integer length;
    private Rating rating;

    private String time;

    public Route() {
        super();
    }

    public Route(User user, Integer id, Integer length, Rating rating, List<InetAddress> ipList, String time) {
        super(id);
        this.user = user;
        this.length = length;
        this.rating  = rating;
        this.ipList = ipList;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public Rating getRating() {
        return rating;
    }

    public List<InetAddress> getIpList() {
        return ipList;
    }

    public Integer getLength() {
        return length;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIpList(List<InetAddress> ipList) {
        this.ipList = ipList;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}