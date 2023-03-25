package src.by.fpmibsu.netside.entity;

import java.sql.Time;
import java.util.ArrayList;

public class Route {
    private final User user;
    private final Integer id;
    private final Integer length;
    private final Integer userId;
    private final Time createdAt;

    public Route(User user, Integer id, Integer length, Integer userId, Time createdAt) {
        this.user = user;
        this.id = id;
        this.length = length;
        this.userId = userId;
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLength() {
        return length;
    }

    public Integer getUserId() {
        return userId;
    }

    public Time getCreatedAt() {
        return createdAt;
    }
}