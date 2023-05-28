<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>World Map</title>
    <link rel="stylesheet" href="https://openlayers.org/en/v4.6.5/css/ol.css" type="text/css">
    <style>
        /* Beautify the map container */
        #map {
            width: 100%;
            height: 100vh;
            position: absolute;
        }

        .dot {
            background-color: red;
            border: 1px solid black;
            border-radius: 50%;
            width: 4px;
            height: 4px;
        }

        .line {
            stroke: #888;
            stroke-width: 1px;
        }
    </style>
</head>
<body>
<h1>World Map</h1>
<div id="map"></div>

<script src="https://openlayers.org/en/v4.6.5/build/ol.js"></script>
<script>
    <%-- Import necessary Java classes --%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
    <%@ page import="src.by.fpmibsu.netside.entity.Ip"%>

    <%-- Create a list to hold the dots --%>
    <% List<double[]> dotList = (List<double[]>) request.getAttribute("dotList"); %>

    // Create an array to hold the point features
    var pointFeatures = [];

    // Loop through the dot list and create features for each dot
    <% for (double[] dot : dotList) { %>
    // Create a point feature
    var point = new ol.Feature({
        geometry: new ol.geom.Point(ol.proj.fromLonLat([<%= dot[1] %>, <%= dot[0] %>]))
    });

    // Add the point feature to the array
    pointFeatures.push(point);
    <% } %>

    // Create a vector source to hold the point features
    var vectorSource = new ol.source.Vector({
        features: pointFeatures
    });

    // Create a vector layer with the point source
    var vectorLayer = new ol.layer.Vector({
        source: vectorSource,
        style: new ol.style.Style({
            image: new ol.style.Circle({
                radius: 3,
                fill: new ol.style.Fill({ color: 'red' }),
                stroke: new ol.style.Stroke({ color: 'black', width: 1 })
            })
        })
    });

    // Create a line feature to connect the dots
    var lineFeature = new ol.Feature({
        geometry: new ol.geom.LineString(
            pointFeatures.map(function(point) {
                return point.getGeometry().getCoordinates();
            })
        )
    });

    // Create a vector source with the line feature
    var lineSource = new ol.source.Vector({
        features: [lineFeature]
    });

    // Create a vector layer with the line source
    var lineLayer = new ol.layer.Vector({
        source: lineSource,
        style: new ol.style.Style({
            stroke: new ol.style.Stroke({ color: '#888', width: 1 })
        })
    });

    // Create a new map instance
    var map = new ol.Map({
        target: 'map', // The ID of the map container
        layers: [
            // Add a base layer with the world map
            new ol.layer.Tile({
                source: new ol.source.OSM()
            }),
            vectorLayer, // Add the point layer
            lineLayer // Add the line layer
        ],
        view: new ol.View({
            center: ol.proj.fromLonLat([0, 0]), // Center the map at the given coordinates
            zoom: 2.5 // Initial zoom level
        })
    });
</script>
</body>
</html>
