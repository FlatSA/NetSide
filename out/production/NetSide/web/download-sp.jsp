<%--
  Created by IntelliJ IDEA.
  User: flat
  Date: 5/31/23
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Speed Test</title>
    <link rel="stylesheet" href="style/assetsLoggedUser/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
    <style>
        .test-container {
            display: flex;
            flex-direction: row;
            justify-content: center;
            width: 100%;
            margin-top: 200px;
        }

        .speed-test-button {
            cursor: pointer;
            outline: 0;
            display: inline-block;
            width: 220px;
            font-weight: 400;
            line-height: 1.5;
            text-align: center;
            background-color: transparent;
            border: 1px solid transparent;
            padding: 6px 12px;
            font-size: 1rem;
            border-radius: .25rem;
            transition: color .15s ease-in-out, background-color .15s ease-in-out, border-color .15s ease-in-out, box-shadow .15s ease-in-out;
            color: #0d6efd;
            border-color: #0d6efd;
            margin-top: 15px;
        }

        .speed-test-button:hover {
            color: #fff;
            background-color: #0d6efd;
            border-color: #0d6efd;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-light navbar-expand-md fixed-top navbar-shrink py-3" id="mainNav">
    <div class="container">
        <a class="navbar-brand d-flex align-items-center" href="logged-user.jsp"><span>NetSide</span></a>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item"></li>
                <li class="nav-item">
                    <form method="get" action="download-sp.jsp">
                        <button type="submit" class="nav-link" name="button" value="speedTestButton" style="background: none; border: none; cursor: pointer;">Speed Test</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form method="get" action="main">
                        <button type="submit" class="nav-link" name="button" value="questionSearchButton" style="background: none; border: none; cursor: pointer;">Search Question</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form method="get" action="main">
                        <button type="submit" class="nav-link" name="button" value="questionButton" style="background: none; border: none; cursor: pointer;">Questions</button>
                    </form>
                </li>
                <li class="nav-item">
                    <form method="get" action="main">
                        <button type="submit" class="nav-link" name="button" value="routeButton" style="background: none; border: none; cursor: pointer;">Routes</button>
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="test-container">
    <div class="speedtest-input">
        <form method="post" action="main">
            <fieldset>
                <legend>Select Server:</legend>
                <div>
                    <input type="radio" id="first" name="drone" value="first"
                           checked>
                    <label for="first">https://unsplash.com</label>
                </div>

                <div>
                    <input type="radio" id="second" name="drone" value="second">
                    <label for="second">https://pixaby.com</label>
                </div>

                <div>
                    <input type="radio" id="third" name="drone" value="third">
                    <label for="third">https://freepik.com</label>
                </div>
            </fieldset>
            <button type="submit" name="button" class="speed-test-button" value="speedTestButton">speed test</button>
        </form>
    </div>
</div>
</body>
</html>