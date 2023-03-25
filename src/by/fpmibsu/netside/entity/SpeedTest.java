package src.by.fpmibsu.netside.entity;

public class SpeedTest {
    private final User user;
    private final Integer userId;
    private final Double uploadSpeed;
    private final Double downloadSpeed;
    private final Double ping;
    private final Integer id;

    public SpeedTest(User user, Integer userId, Double uploadSpeed, Double downloadSpeed, Double ping, Integer id) {
        this.user = user;
        this.userId = userId;
        this.uploadSpeed = uploadSpeed;
        this.downloadSpeed = downloadSpeed;
        this.ping = ping;
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public Double getUploadSpeed() {
        return uploadSpeed;
    }

    public Double getDownloadSpeed() {
        return downloadSpeed;
    }

    public Double getPing() {
        return ping;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getId() {
        return id;
    }
}