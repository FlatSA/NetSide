package src.by.fpmibsu.netside.entity;

import java.util.ArrayList;
import java.util.List;

public class User extends Entity {
    private String login;
    private String password;
    private String email;

    private List<Question> questions = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();
    private List<SpeedTest> speedTests = new ArrayList<>();
    private List<Route> routes = new ArrayList<>();

    public User() {
        super();
    };

    public User(String login, String password, String email) {
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public User(Integer id, String login, String password, String email) {
        super(id);
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void setSpeedTests(List<SpeedTest> speedTests) {
        this.speedTests = speedTests;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<SpeedTest> getSpeedTests() {
        return speedTests;
    }

    public List<Route> getRoutes() {
        return routes;
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

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(id)
                .append(" ")
                .append(login)
                .append(" ")
                .append(email)
                .append(" ")
                .append(password);
        return output.toString();
    }
}