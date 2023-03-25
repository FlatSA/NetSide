package src.by.fpmibsu.netside.entity;

public class Answer {
    private final Integer id;
    private Integer votes;
    private final User user;
    private final Question question;

    private final Integer userId;
    private final Integer questionId;

    public Answer(Integer id, Integer votes, User user, Question question, Integer userId, Integer questionId) {
        this.id = id;
        this.votes = votes;
        this.user = user;
        this.question = question;
        this.userId = userId;
        this.questionId = questionId;
    }

    public Integer getId() {
        return id;
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

    public Integer getUserId() {
        return userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void increaseVotes() {
        votes++;
    }
}
