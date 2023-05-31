<%@ page import="src.by.fpmibsu.netside.entity.Route" %>
<%@ page import="java.util.List" %>
<%@ page import="src.by.fpmibsu.netside.entity.Question" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Answer Question</title>
  <style>
    /* Styles for the elements */
    .question-container {
      width: 800px;
      margin: 0 auto;
    }

    .question-message {
      background-color: #f6f6f6;
      margin-bottom: 20px;
      padding: 10px;
      border-radius: 4px;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    .question-message h2 {
      margin-top: 0;
      margin-bottom: 10px;
    }

    .answer-form {
      margin-bottom: 20px;
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction: column;
    }

    .answer-form input[type="text"],
    .answer-form button {
      height: 40px;
      padding: 5px;
      border-radius: 4px;
      border: none;
      box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      font-size: 14px;
    }

    .answer-form input[type="text"] {
      width: 800px;
      margin-bottom: 10px;
      text-align: left;
    }

    .answer-form button {
      background-color: #f6f6f6;
      color: #333;
      cursor: pointer;
    }

    .answer-form button:hover {
      background-color: #ddd;
    }

    .answer-form button:focus {
      outline: none;
    }
  </style>
</head>
<body>

<div class="question-container">
  <div class="question-message">
    <% Question question = (Question) request.getAttribute("questionObject"); %>
    <h2><%= question.getMessage() %></h2>
  </div>

  <div class="answer-form">
    <form method="post" action="main">
      <input type="hidden" name="questionId" value="<%= question.getId() %>">
      <input type="text" class="form-control" name="textAnswerOnTheQuestion" placeholder="Enter your answer" required>
      <form method="post" action="main">
        <button type="submit" name="button" value="answerOnTheQuestion">Answer</button>
      </form>
    </form>
  </div>
</div>

</body>
</html>