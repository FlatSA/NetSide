<%@ page import="src.by.fpmibsu.netside.entity.Route" %>
<%@ page import="java.util.List" %>
<%@ page import="src.by.fpmibsu.netside.entity.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
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
        <th>Username</th>
        <th>Message</th>
        <th>Votes</th>
    </tr>
    </thead>
    <tbody>
    <% List<Question> questions = (List<Question>) request.getAttribute("questions");
        for (Question question : questions) { %>
    <tr>
        <td><%= question.getUser().getLogin() %></td>
        <td><%= question.getMessage() %></td>
        <td><%= question.getVotes() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
