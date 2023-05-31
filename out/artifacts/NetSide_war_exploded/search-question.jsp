<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Page</title>
    <style>
        /* Styles for the elements */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .search-container {
            text-align: center;
        }

        .search-input {
            width: 400px;
            height: 40px;
            padding: 10px;
            font-size: 16px;
        }

        .search-button {
            margin-top: 10px;
            padding: 10px 20px;
            font-size: 16px;
            background-color: #ccc;
            color: #333;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
    </style>
</head>
<body>

<div class="search-container">
    <form method="post" action="question">
        <input type="text" class="search-input" name="queryQuestion" placeholder="Enter your search question" required>
        <br>
        <form method="post" action="question">
            <button type="submit" class="search-button" name="button" value="searchQuestion">Search</button>
        </form>
    </form>
</div>

</body>
</html>
