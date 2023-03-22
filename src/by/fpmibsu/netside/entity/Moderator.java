package src.by.fpmibsu.netside.entity;

public class Moderator extends User {
    public Moderator(Integer userId, String login, String password, String email) {
        super(userId, login, password, email);
    }

    //TODO
    public void deleteAnswer(Answer answer) {

    }

    //TODO
    public void deleteQuestion(Question question) {

    }
}