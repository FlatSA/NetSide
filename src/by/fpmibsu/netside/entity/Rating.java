package src.by.fpmibsu.netside.entity;

public class Rating {
    private final Integer value;
    private final Route route;
    private final Integer routeId;
    private final Integer id;

    public Rating(Integer value, Route route, Integer routeId, Integer id) {
        this.value = value;
        this.route = route;
        this.routeId = routeId;
        this.id = id;
    }

    public Integer getValue() {
        return value;
    }

    public Route getRoute() {
        return route;
    }

    public Integer getRouteId() {
        return routeId;
    }

    public Integer getId() {
        return id;
    }
}
