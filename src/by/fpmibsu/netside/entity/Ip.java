package src.by.fpmibsu.netside.entity;

import java.net.InetAddress;

public class Ip {
    private final Integer id;
    private final Route route;
    private final Integer routeId;
    private final InetAddress ipAddress;

    public Ip(Integer id, Route route, Integer routeId, InetAddress ipAddress) {
        this.id = id;
        this.route = route;
        this.routeId = routeId;
        this.ipAddress = ipAddress;
    }

    public Integer getId() {
        return id;
    }

    public Route getRoute() {
        return route;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }
}
