<%@ page import="src.by.fpmibsu.netside.entity.Route" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Top Routes</title>
    <style>
        .route-container {
            display: flex;
            flex-wrap: wrap;
            gap: 20px;
            justify-content: center;
            align-items: center;
        }

        .route-box {
            width: 400px;
            padding: 20px;
            border-radius: 4px;
            background-color: #f6f6f6;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            cursor: pointer;
            margin-bottom: 20px;
        }

        .route-box:hover {
            background-color: #ddd;
        }

        .route-box a {
            color: #333;
            text-decoration: none;
        }

        .route-box h3 {
            margin-top: 0;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>
<h1>Routes</h1>
<div class="route-container">
    <% List<Route> routes = (List<Route>) request.getAttribute("routes");
        for (int i = 0; i < routes.size(); i++) {
            Route route = routes.get(i);
    %>
    <div class="route-box" onclick="document.getElementById('routeForm<%= route.getId() %>').submit();">
        <form id="routeForm<%= route.getId() %>" method="get" action="main">
            <input type="hidden" name="routeId" value="<%= route.getId() %>">
            <input type="hidden" name="source" value="route-box">
            <p><strong>Username:</strong> <%= route.getUser().getLogin() %></p>
            <p><strong>Length (Hops):</strong> <%= route.getLength() %></p>
            <p><strong>Email:</strong> <%= route.getUser().getEmail() %></p>
        </form>
    </div>
    <% } %>
</div>
</body>
</html>