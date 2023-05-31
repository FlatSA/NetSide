<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <title>Home</title>
  <link rel="stylesheet" href="style/assetsLoggedUser/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
  <style>
    .btn-primary:focus,
    .btn-primary:active,
    .form-control:focus {
      box-shadow: none;
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
        <li class="nav-item"><a class="nav-link" href="features.html">Speed test</a></li>
        <form method="post" action="question">
          <button type="submit" class="nav-link" name="button" value="questionSearchButton" style="background: none; border: none; cursor: pointer;">Search Question</button>
        </form>
        <li class="nav-item">
          <form method="post" action="question">
            <button type="submit" class="nav-link" name="button" value="questionButton" style="background: none; border: none; cursor: pointer;">Questions</button>
          </form>
        </li>
        <li class="nav-item">
          <form method="post" action="route">
            <button type="submit" class="nav-link" name="button" value="routeButton" style="background: none; border: none; cursor: pointer;">Routes</button>
          </form>
        </li>
      </ul>
    </div>
  </div>
</nav>
<%
  String ip = request.getHeader("X-Forwarded-For");
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    ip = request.getHeader("Proxy-Client-IP");
  }
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    ip = request.getHeader("WL-Proxy-Client-IP");
  }
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    ip = request.getHeader("HTTP_CLIENT_IP");
  }
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    ip = request.getHeader("HTTP_X_FORWARDED_FOR");
  }
  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
    ip = request.getRemoteAddr();
  }
%>
<header class="pt-5">
  <div class="container pt-4 pt-xl-5">
    <div class="row pt-5">
      <div class="col-md-8 text-center text-md-start mx-auto">
        <div class="text-center">
          <h1 class="display-4 fw-bold mb-5"><br><br></h1>
          <form class="d-flex justify-content-center flex-wrap" method="post" action="route">
            <div class="shadow-lg mb-3"></div>
            <div class="shadow-lg mb-3">
              <input type="hidden" name="userId" value="<%= request.getParameter("userId") %>">
              <input type="hidden" name="userIp" value="<%= ip %>">
              <div class="input-group">
                <input type="text" class="form-control" name="destinationIp" placeholder="Enter destination ip">
                <button class="btn btn-primary" name="button" value="getRouteButton" type="submit" style="padding: 15px 40px; font-size: 20px;" data-bs-toggle="tooltip" data-bs-placement="centre" title="Click to display the route between the server and input ip">Go</button>
              </div>
            </div>
          </form>
        </div>
      </div>
      <div class="col-12 col-lg-10 mx-auto">
        <div class="text-center position-relative"></div>
      </div>
    </div>
  </div>
</header>
<section></section>
<footer></footer>
<script src="style/assetsLoggedUser/bootstrap/js/bootstrap.min.js"></script>
<script src="style/assetsLoggedUser/js/script.min.js"></script>
</body>
</html>
