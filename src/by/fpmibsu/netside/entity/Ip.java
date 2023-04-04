package src.by.fpmibsu.netside.entity;

import java.net.InetAddress;

public class Ip extends Entity{
    private String ipAddress;

    public Ip() {
        super();
    }

    @Override
    public String toString() {
        return "Ip{" +
                "ipAddress='" + ipAddress + '\'' +
                '}';
    }

    public Ip(Integer id, String ipAddress) {
        super(id);
        this.ipAddress = ipAddress;
    }
    public Ip(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
