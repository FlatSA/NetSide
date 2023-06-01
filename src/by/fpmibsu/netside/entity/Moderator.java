package src.by.fpmibsu.netside.entity;

public class Moderator extends User {

    public Moderator() {
        super();
    }

    public Moderator(String login, String password, String email) {
        super(login, password, email);
    }

    public Moderator(User user) {
        super(user.getId(), user.getLogin(), user.getPassword(), user.getEmail());
    }

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