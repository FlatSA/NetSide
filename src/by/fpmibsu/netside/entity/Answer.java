package src.by.fpmibsu.netside.entity;

public class Answer extends Entity {
    private Integer votes;
    private User user;
    private Question question;

    public Answer(Integer id, Integer votes, User user, Question question) {
        super(id);
        this.votes = votes;
        this.user = user;
        this.question = question;
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
