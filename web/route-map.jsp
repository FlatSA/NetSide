<%@ page import="src.by.fpmibsu.netside.entity.Route" %>
<%@ page import="src.by.fpmibsu.netside.entity.Ip" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>IP Addresses Map</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/leaflet@1.7.1/dist/leaflet.css" />
    <style>
        #map { height: 400px; }
    </style>
</head>
<body>
<h1>IP Addresses Map</h1>
<div id="map"></div>

<script src="https://cdn.jsdelivr.net/npm/leaflet@1.7.1/dist/leaflet.js"></script>
<script>
    <%  List<Ip> ipList = (List<Ip>) request.getAttribute("ipList"); %>

    var map = L.map('map').setView([0, 0], 2);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
        attribution: 'Map data &copy; <a href="https://www.openstreetmap.org/">OpenStreetMap</a> contributors',
        maxZoom: 18
    }).addTo(map);

    var markersGroup = L.featureGroup().addTo(map);

    <% for (Ip ipAddress : ipList) { %>
        var url = "https://ipinfo.io/" + "<%= ipAddress %>" + "?token=6745615ab91d28";
        fetch(url)
            .then(function(response) {
                return response.json();
            })
            .then(function(data) {
                var loc = data.loc.split(",");
                var latitude = loc[0]; // Latitude
                var longitude = loc[1]; // Longitude

                L.marker([latitude, longitude]).addTo(markersGroup);
            });
        <% } %>

    map.fitBounds(markersGroup.getBounds());
</script>
</body>
</html>