package src.by.fpmibsu.netside.entity;

public class Rating extends Entity {
    private Integer value;
    private Route route;

    public Rating() {
        super();
    }

    public Rating(Integer value, Route route, Integer id) {
        super(id);
        this.value = value;
        this.route = route;
    }

    public Integer getValue() {
        return value;
    }

    public Route getRoute() {
        return route;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
