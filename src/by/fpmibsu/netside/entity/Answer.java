package src.by.fpmibsu.netside.entity;

public class Answer extends Entity {

    private String message;
    private Integer votes;
    private User user;
    private Question question;

    public Answer() {
        super();
    }

    public Answer(Integer id, String message, Integer votes, User user, Question question) {
        super(id);
        this.message = message;
        this.votes = votes;
        this.user = user;
        this.question = question;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getVotes() {
        return votes;
    }

    public User getUser() {
        return user;
    }

    public Question getQuestion() {
        return question;
    }

    public void increaseVotes() {
        votes++;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }
}
