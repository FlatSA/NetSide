package src.by.fpmibsu.netside.entity;

public class Rating {
    private final Integer value;
    private final Route route;
    private final Integer ratingId;

    public Rating(Integer value, Route route, Integer ratingId) {
        this.value = value;
        this.route = route;
        this.ratingId = ratingId;
    }

    public Integer getValue() {
        return value;
    }

    public Route getRoute() {
        return route;
    }
}
