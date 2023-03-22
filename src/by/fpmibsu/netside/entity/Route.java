package by.fpmibsu.netside.entity;

import java.util.ArrayList;

public class Route {
    private final User user;
    private final Integer routeId;
    private final ArrayList<String> ipList;
    private final Integer length;

    public Route(User user, Integer routeId, Integer length, ArrayList<String> ipList) {
        this.user = user;
        this.routeId = routeId;
        this.length = length;
        this.ipList = new ArrayList<>(ipList);
    }

    public User getUser() {
        return user;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public ArrayList<String> getIpList() {
        return new ArrayList<String>(ipList);
    }

    public Integer getLength() {
        return length;
    }
}