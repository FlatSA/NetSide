package by.fpmibsu.netside.entity;

import java.util.ArrayList;

public class User {
    private final Integer userId;
    private String login;
    private String password;
    private String email;

    private final ArrayList<Question> questions;
    private final ArrayList<Answer> answers;
    private final ArrayList<SpeedTest> speedTests;
    private final ArrayList<Route> routes;

    public User(Integer userId, String login, String password, String email) {
        this.userId = userId;
        this.login = login;
        this.password = password;
        this.email = email;
        questions = new ArrayList<>();
        speedTests = new ArrayList<>();
        answers = new ArrayList<>();
        routes = new ArrayList<>();
    }

    public ArrayList<Question> getQuestions() {
        return new ArrayList<Question>(questions);
    }

    public ArrayList<Answer> getAnswers() {
        return new ArrayList<Answer>(answers);
    }

    public ArrayList<SpeedTest> getSpeedTests() {
        return new ArrayList<SpeedTest>(speedTests);
    }

    public ArrayList<Route> getRoutes() {
        return new ArrayList<Route>(routes);
    }

    public Integer getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void addRoute(Route route) {
        routes.add(route);
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void addSpeedTest(SpeedTest speedTest) {
        speedTests.add(speedTest);
    }

    public void removeAnswer(Answer answer) {
        int size = answers.size();
        for(int i = 0; i < size; i++) {
            if(answer == answers.get(i)) {
                answers.remove(i);
                break;
            }
        }
    }

    public void removeQuestion(Question question) {
        int size = questions.size();
        for(int i = 0; i < size; i++) {
            if(question == questions.get(i)) {
                questions.remove(i);
                break;
            }
        }
    }

    public void removeRoute(Route route) {
        int size = routes.size();
        for(int i = 0; i < size; i++) {
            if(route == routes.get(i)) {
                routes.remove(i);
                break;
            }
        }
    }

    public void removeSpeedTest(SpeedTest speedTest) {
        int size = speedTests.size();
        for(int i = 0; i < size; i++) {
            if(speedTest == speedTests.get(i)) {
                speedTests.remove(i);
                break;
            }
        }
    }
}