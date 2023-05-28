package src.by.fpmibsu.netside;

import src.by.fpmibsu.netside.entity.Ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class TraceRoute {
    Ip destinationIp;

    public TraceRoute(Ip destinationIp) {
        this.destinationIp = destinationIp;
    }

    public List<Ip> getListIpFromServerToUser() {
        List<Ip> ipList = new ArrayList<>();

        try {
            ProcessBuilder processBuilder = new ProcessBuilder("traceroute", destinationIp.getIpAddress());
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                String ipAddress = extractIpAddress(line);
                if (ipAddress != null) {
                    ipList.add(new Ip(ipAddress));
                }
            }

            int exitCode = process.waitFor();
            System.err.println("Traceroute completed with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            System.err.println("Traceroute failed");
            e.printStackTrace();
        }

        return ipList;
    }

    private static String extractIpAddress(String line) {
        // Extracts the first IP address in the line using a simple regex
        String regex = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";
        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

}
