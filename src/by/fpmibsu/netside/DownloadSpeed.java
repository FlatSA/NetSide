package src.by.fpmibsu.netside;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class DownloadSpeed {
    private final static String firstLink = "https://images.unsplash.com/photo-1685297965194-5eb9b8d51a05?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1469&q=80";
    private final static String secondLink = "https://cdn.pixabay.com/photo/2018/01/25/14/12/nature-3106213_1280.jpg";
    private final static String thirdLink = "https://img.freepik.com/free-photo/lone-tree_181624-46361.jpg?w=1380&t=st=1685482876~exp=1685483476~hmac=ccafb84eb7c60842904917e4e2b87f0f2941da17ecf5b0522fad1fbce1496cec";
    private final static int firstSize = 162;
    private final static int secondSize = 261;
    private final static int thirdSize = 170;

    static public double mbSpeedPerTick(String server) throws IOException {
       double speed = 0;
       double start;
       double end;
       double delta;
        BufferedImage image = null;
        String link = null;
        int size = 0;

        if(server.equals("first")) {
           link = String.valueOf(firstLink);
           size = firstSize;
        } else if(server.equals("second")) {
            link = String.valueOf(secondLink);
            size = secondSize;
        } else if(server.equals("third")) {
            link = String.valueOf(thirdLink);
            size = thirdSize;
        }

        URL url = new URL(link);
        start = System.currentTimeMillis();
        image = ImageIO.read(url);
        end = System.currentTimeMillis();
        delta = end - start;
        speed = size / delta;

        return speed;
    }
}
