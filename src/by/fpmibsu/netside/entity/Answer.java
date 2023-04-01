package src.by.fpmibsu.netside.entity;

public class Answer extends Entity {

    private String message;
    private User user;
    private Question question;

    public Answer() {
        super();
    }

    public Answer(String message, User user, Question question) {
        this.message = message;
        this.user = user;
        this.question = question;
    }

    public Answer(Integer id, String message, User user, Question question) {
        super(id);
        this.message = message;
        this.user = user;
        this.question = question;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getUser() {
        return user;
    }

    public Question getQuestion() {
        return question;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "message='" + message + '\'' +
                ", user=" + user +
                ", question=" + question +
                ", id=" + id +
                '}';
    }
}
