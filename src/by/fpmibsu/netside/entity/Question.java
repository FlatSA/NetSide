package src.by.fpmibsu.netside.entity;

import java.util.ArrayList;
import java.util.List;

public class Question extends Entity {
    private User user;
    private Integer votes;
    private String message;
    private List<Answer> answers = new ArrayList<>();

    public Question() {
        super();
    }

    public Question(User user, String message, Integer votes) {
        this.user = user;
        this.message = message;
        this.votes = votes;
    }

    public Question(Integer id, User user, String message, Integer votes) {
        super(id);
        this.user = user;
        this.votes = votes;
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public Integer getVotes() {
        return votes;
    }

    public void increaseVotes() {
        votes++;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "user_id=" + user.getId() +
                ", votes=" + votes +
                ", message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}