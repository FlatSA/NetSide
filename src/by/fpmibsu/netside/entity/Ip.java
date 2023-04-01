package src.by.fpmibsu.netside.entity;

import java.net.InetAddress;

public class Ip extends Entity{
    private InetAddress ipAddress;

    public Ip(Integer id, InetAddress ipAddress) {
        super(id);
        this.ipAddress = ipAddress;
    }

    public InetAddress getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(InetAddress ipAddress) {
        this.ipAddress = ipAddress;
    }
}
