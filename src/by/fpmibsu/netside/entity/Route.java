package src.by.fpmibsu.netside.entity;

import java.net.NoRouteToHostException;
import java.sql.Time;
import java.util.List;
import java.net.InetAddress;

public class Route extends Entity {
    private User user;
    private List<Ip> ipList;
    private Integer length;
    private String time;

    public Route() {
        super();
    }

    public Route(User user, Integer id, Integer length, List<Ip> ipList, String time) {
        super(id);
        this.user = user;
        this.length = length;
        this.ipList = ipList;
        this.time = time;
    }

    public Route(User user, Integer length, List<Ip> ipList, String time) {
        this.user = user;
        this.length = length;
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

    public List<Ip> getIpList() {
        return ipList;
    }

    public Integer getLength() {
        return length;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setIpList(List<Ip> ipList) {
        this.ipList = ipList;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}