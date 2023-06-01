<%@ page import="src.by.fpmibsu.netside.entity.SpeedTest" %>
<%@ page import="java.util.List" %>
<%@ page import="src.service.SpeedTestService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Speed Test</title>
    <link rel="stylesheet" href="style/assetsLoggedUser/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
    <style>
        .speed-container {
            display: flex;
            flex-direction: row;
            justify-content: center;
            width: 100%;
            margin-top: 250px;
        }

        .speed-test-value {
            font-size: 50px;
        }

        .speed-test-field {
            dislpay: flex;
            flex-direction: row;
        }

        .table-container {
            margin-top: 40px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            width: 100%;
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
<div class="speed-container">
    <div class="speed-test-field">
        <h1 class="speed-test-value"><%=request.getAttribute("downloadSpeed")%> Mbps</h1>
    </div>
</div>
<div class="table-container">
    <!-- copy content from question-home.jsp after we get user -->
</div>
</body>
</html>