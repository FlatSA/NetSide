package by.fpmibsu.netside.entity;

import java.util.ArrayList;

public class Question {
    private final Integer questionId;
    private final User author;
    private Integer votes;
    private String message;
    final private String title;
    private final ArrayList<Answer> answers;
    static final Integer defaultVotes = 0;

    public Question(Integer questionId, User author, String message, String title) {
        this.questionId = questionId;
        this.author = author;
        this.votes = defaultVotes;
        this.message = message;
        this.title = title;
        answers = new ArrayList<>();
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public User getAuthor() {
        return author;
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