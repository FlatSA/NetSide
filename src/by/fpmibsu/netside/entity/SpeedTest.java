package src.by.fpmibsu.netside.entity;

public class SpeedTest {
    private final User user;
    private final Double uploadSpeed;
    private final Double downloadSpeed;
    private final Double ping;
    private final Integer speedTestId;

    public SpeedTest(User user, Double uploadSpeed, Double downloadSpeed, Double ping, Integer speedTestId) {
        this.user = user;
        this.uploadSpeed = uploadSpeed;
        this.downloadSpeed = downloadSpeed;
        this.ping = ping;
        this.speedTestId = speedTestId;
    }

    public User getUser() {
        return user;
    }

    public Double getUploadSpeed() {
        return uploadSpeed;
    }

    public Double getDownlodSpeed() {
        return downloadSpeed;
    }

    public Double getPing() {
        return ping;
    }

    public Integer getSpeedTestId() {
        return speedTestId;
    }
}