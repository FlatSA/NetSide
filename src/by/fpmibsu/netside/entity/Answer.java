package src.by.fpmibsu.netside.entity;

public class Answer {
    private final Integer answerId;
    private Integer votes;
    private final User author;
    private final Question question;

    public Answer(Integer answerId, Integer votes, User author, Question question) {
        this.answerId = answerId;
        this.votes = votes;
        this.author = author;
        this.question = question;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public Integer getVotes() {
        return votes;
    }

    public User getAuthor() {
        return author;
    }

    public Question getQuestion() {
        return question;
    }

    public void increaseVotes() {
        votes++;
    }
}
