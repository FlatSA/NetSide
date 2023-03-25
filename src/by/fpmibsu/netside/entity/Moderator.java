package src.by.fpmibsu.netside.entity;

public class Moderator extends User {
    private final Integer id;
    public Moderator(Integer id, Integer userId, String login, String password, String email) {
        super(userId, login, password, email);
        this.id = id;
    }

    //TODO
    public void deleteAnswer(Answer answer) {

    }

    //TODO
    public void deleteQuestion(Question question) {

    }
}