package src.by.fpmibsu.netside.entity;

import java.util.ArrayList;

public class Question {
    private final Integer id;
    private final User user;
    private final Integer userID;
    private Integer votes;
    private String message;
    final private String title;
    private final ArrayList<Answer> answers;

    public Question(Integer id, User user, Integer userID, String message, String title) {
        this.id = id;
        this.user = user;
        this.userID = userID;
        this.votes = 0;
        this.message = message;
        this.title = title;
        this.answers = new ArrayList<>();
    }

    public Integer getId() {
        return id;
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

    public String getTitle() {
        return title;
    }

    public ArrayList<Answer> getAnswers() {
        return new ArrayList<Answer>(answers);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void removeAns(Answer answer) {
        int size = answers.size();
        for(int i = 0; i < size; i++) {
            if(answer == answers.get(i)) {
                answers.remove(i);
                break;
            }
        }
    }
}