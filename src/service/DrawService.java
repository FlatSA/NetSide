package src.service;

import src.by.fpmibsu.netside.entity.Ip;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DrawService {
    public static List<double[]> getListOfDots(List<Ip> ips) {
        List<double[]> dotList = new ArrayList<>();

        for (Ip ip : ips) {
            String apiUrl = "https://ipinfo.io/" + ip.getIpAddress() + "?token=6745615ab91d28";

            try {
                URL url = new URL(apiUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder response = new StringBuilder();
                    String line;

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }

                    String responseData = response.toString();
                    reader.close();
                    connection.disconnect();

                    double[] latLng = getLatLngFromJson(responseData);
                    if(latLng != null) {
                        dotList.add(latLng);
                    }
                }
            } catch (Exception e) {
                System.err.println("Failed in converting ip to dot in RouteController");
                e.printStackTrace();
            }
        }

        return dotList;
    }

    private static double[] getLatLngFromJson(String jsonString) {
        Pattern pattern = Pattern.compile("-?\\d+\\.\\d+,-?\\d+\\.\\d+");
        Matcher matcher = pattern.matcher(jsonString);
        if (matcher.find()) {
            String loc = matcher.group();
            List<String> latLng= List.of(loc.split(","));
            return new double[]{Double.parseDouble(latLng.get(0)), Double.parseDouble(latLng.get(1))};
        }
        return null;
    }
}
