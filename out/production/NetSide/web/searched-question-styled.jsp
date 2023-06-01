<%@ page import="java.net.InetAddress" %>
<%@ page import="java.net.Inet6Address" %>
<%@ page import="java.net.Inet4Address" %>
<%@ page import="java.net.UnknownHostException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Map</title>
    <link rel="stylesheet" href="style/assetsLoggedUser/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
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
<header class="pt-5">
    <div class="container pt-4 pt-xl-5">
        <div class="row pt-5">
            <section>
                <jsp:include page="searched-question.jsp" />
            </section>
        </div>
    </div>
</header>
<footer></footer>
<script src="style/assetsLoggedUser/bootstrap/js/bootstrap.min.js"></script>
<script src="style/assetsLoggedUser/js/script.min.js"></script>
</body>

</html>