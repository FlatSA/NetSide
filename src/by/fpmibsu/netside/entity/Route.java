package src.by.fpmibsu.netside.entity;

import java.sql.Time;
import java.util.List;
import java.net.InetAddress;

public class Route extends Entity {
    private User user;
    private List<String> ipList;
    private Integer length;
    private Time time;

    public Route() {
        super();
    }

    public Route(User user, Integer id, Integer length, List<String> ipList, Time time) {
        super(id);
        this.user = user;
        this.length = length;
        this.ipList = ipList;
        this.time = time;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public User getUser() {
        return user;
    }

    public List<String> getIpList() {
        return ipList;
    }

    public Integer getLength() {
        return length;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}