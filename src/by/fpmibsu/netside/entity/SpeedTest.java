package src.by.fpmibsu.netside.entity;

public class SpeedTest extends Entity {
    private User user;
    private Double uploadSpeed;
    private Double downloadSpeed;
    private Double ping;

    public SpeedTest() {
        super();
    }

    public SpeedTest(User user, Double uploadSpeed, Double downloadSpeed, Double ping, Integer id) {
        super(id);
        this.user = user;
        this.uploadSpeed = uploadSpeed;
        this.downloadSpeed = downloadSpeed;
        this.ping = ping;
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
    public void setUploadSpeed(Double uploadSpeed) {
        this.uploadSpeed = uploadSpeed;
    }

    public void setDownloadSpeed(Double downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
    }

    public void setPing(Double ping) {
        this.ping = ping;
    }
    public void setUser(User user) {
        this.user = user;
    }

}