<%@ page import="src.by.fpmibsu.netside.entity.Route" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Top Routes</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
            text-align: center;
            font-family: Arial, sans-serif;
        }

        th {
            background-color: #f2f2f2;
            padding: 10px;
        }

        td {
            padding: 10px;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f5f5f5;
        }
    </style>
</head>
<body>
<h1>Routes</h1>
<table>
    <thead>
    <tr>
        <th>Login</th>
        <th>Length</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <% List<Route> routes = (List<Route>) request.getAttribute("routes");
        for (Route route : routes) { %>
    <tr>
        <td><%= route.getUser().getLogin() %></td>
        <td><%= route.getLength() %></td>
        <td><%= route.getUser().getEmail() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
