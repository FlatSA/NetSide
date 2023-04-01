package src.by.fpmibsu.netside.entity;

public class SpeedTest extends Entity {
    private User user;
    private Double uploadSpeed;
    private Double downloadSpeed;
    private Integer ping;

    public SpeedTest() {
        super();
    }

    public SpeedTest(User user, Double uploadSpeed, Double downloadSpeed, Integer ping) {
        this.user = user;
        this.uploadSpeed = uploadSpeed;
        this.downloadSpeed = downloadSpeed;
        this.ping = ping;
    }

    public SpeedTest(Integer id, User user, Double uploadSpeed, Double downloadSpeed, Integer ping) {
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

    public Integer getPing() {
        return ping;
    }
    public void setUploadSpeed(Double uploadSpeed) {
        this.uploadSpeed = uploadSpeed;
    }

    public void setDownloadSpeed(Double downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
    }

    public void setPing(Integer ping) {
        this.ping = ping;
    }
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SpeedTest{" +
                "user=" + user +
                ", uploadSpeed=" + uploadSpeed +
                ", downloadSpeed=" + downloadSpeed +
                ", ping=" + ping +
                ", id=" + id +
                '}';
    }
}