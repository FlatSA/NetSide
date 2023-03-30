package src.by.fpmibsu.netside.entity;

import java.util.ArrayList;
import java.util.List;

public class Question extends Entity {
    private User user;
    private Integer votes;
    private String message;
    private String title;
    private List<Answer> answers;
    static Integer defaultVotes = 0;

    public Question() {
        super();
    }

    public Question(Integer id, User user, String message, String title) {
        super(id);
        this.user = user;
        this.votes = defaultVotes;
        this.message = message;
        this.title = title;
        answers = new ArrayList<>();
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

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
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