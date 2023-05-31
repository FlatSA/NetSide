<%@ page import="src.by.fpmibsu.netside.entity.Route" %>
<%@ page import="java.util.List" %>
<%@ page import="src.by.fpmibsu.netside.entity.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
    <style>
        /* Styles for the elements */
        .ask-button {
            display: inline-block;
            margin-top: 20px;
            margin-right: 20px;
            padding: 10px 20px;
            background-color: #f2f2f2;
            color: #333;
            font-weight: bold;
            text-decoration: none;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        .search-bar {
            margin-top: 20px;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: separate;
            border-spacing: 0;
            font-family: Arial, sans-serif;
        }

        th {
            background-color: #f6f6f6;
            padding: 10px;
            border-bottom: 1px solid #ddd;
            text-align: left;
        }

        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        .question-row:hover {
            background-color: #f9f9f9;
        }

        .question-row:last-child td {
            border-bottom: none;
        }
    </style>
</head>
<body>
<h1>Routes</h1>
<a href="/ask" class="ask-button">Ask Question</a>

<div class="search-bar">
    <!-- Add the search form -->
    <form action="/search" method="get">
        <input type="text" name="query" placeholder="Search questions..." required>
        <button type="submit">Search</button>
    </form>
</div>

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
    <tr class="question-row">
        <td><%= question.getUser().getLogin() %></td>
        <td><%= question.getMessage() %></td>
        <td><%= question.getVotes() %></td>
    </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>