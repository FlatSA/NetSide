<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.net.HttpURLConnection" %>
<%@ page import="java.net.URL" %>
<%@ page import="src.by.fpmibsu.netside.Dot" %>
<%@ page import="src.by.fpmibsu.netside.entity.Ip" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
  <title>Map</title>
  <link rel="stylesheet" href="https://unpkg.com/leaflet@1.7.1/dist/leaflet.css" />
  <style>
    #map {
      height: 400px;
      width: 100%;
    }
  </style>
  <script src="https://unpkg.com/leaflet@1.7.1/dist/leaflet.js"></script>
  <script>
    function initMap() {
      var map = L.map('map').setView([0, 0], 2);

      L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors',
        maxZoom: 18
      }).addTo(map);

      <%
          List<Ip> ipList = (List<Ip>) request.getAttribute("ipList");
          List<Dot> dots = new ArrayList<>();

          for (Ip ip : ipList) {
              String apiUrl = "https://ipinfo.io/" + ip.toString() + "?token=6745615ab91d28";
              URL url = new URL(apiUrl);
              HttpURLConnection conn = (HttpURLConnection) url.openConnection();
              conn.setRequestMethod("GET");

              BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

              String answer = "";
              String output;
              while ((output = br.readLine()) != null) {
                  answer += output;
              }
              br.close();
              conn.disconnect();

              int locIndex = answer.indexOf("\"loc\":");
              int commaIndex = answer.indexOf(",", locIndex);
              String latitude = answer.substring(locIndex + 7, commaIndex);
              String longitude = answer.substring(commaIndex + 1, answer.indexOf("\"", commaIndex + 1));

              dots.add(new Dot(latitude, longitude));
          }

          for (Dot dot : dots) {
      %>
      L.marker([<%= dot.getLatitude() %>, <%= dot.getLongitude() %>]).addTo(map);
      <%
          }
      %>
    }
  </script>
</head>
<body>
<div id="map"></div>
<script>initMap();</script>
</body>
</html>
