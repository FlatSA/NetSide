<%@ page import="src.by.fpmibsu.netside.entity.Route" %>
<%@ page import="java.util.List" %>
<%@ page import="src.by.fpmibsu.netside.entity.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Questions</title>
    <style>
        /* Styles for the elements */
        .questions-container {
            width: 800px;
            margin: 0 auto;
        }

        .question {
            background-color: #f6f6f6;
            margin-bottom: 20px;
            padding: 20px;
            border-radius: 4px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .question h2 {
            margin-top: 0;
            margin-bottom: 10px;
        }

        .question p {
            margin-bottom: 5px;
        }

        .question .votes {
            color: #999;
            font-size: 14px;
        }

        .question .tags {
            margin-top: 10px;
        }

        /* Minimalistic button style */
        .question button {
            background-color: #f6f6f6;
            color: #333;
            border: none;
            padding: 5px 10px;
            border-radius: 4px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            cursor: pointer;
        }

        .question button:hover {
            background-color: #ddd;
        }

        .question button:focus {
            outline: none;
        }
    </style>
</head>
<body>

<div class="questions-container">
    <% List<Question> questions = (List<Question>) request.getAttribute("questions");
        for (Question question : questions) { %>
    <div class="question">
        <h2><%= question.getMessage() %></h2>
        <p>Username: <%= question.getUser().getLogin() %></p>
        <p class="votes">Votes: <%= question.getVotes() %></p>
        <form method="post" action="question">
            <button type="submit" name="button" value="<%= question.getId() %>">Answer</button>
        </form>
    </div>
    <% } %>
</div>
</body>
</html>