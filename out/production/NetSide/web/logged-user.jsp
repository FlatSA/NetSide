<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
  <title>Home - Brand</title>
  <link rel="stylesheet" href="style/assetsLoggedUser/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md fixed-top navbar-shrink py-3" id="mainNav">
  <div class="container"><a class="navbar-brand d-flex align-items-center" href="logged-user.jsp"><span>NetSide</span></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
    <div class="collapse navbar-collapse" id="navcol-1">
      <ul class="navbar-nav mx-auto">
        <li class="nav-item"></li>
        <li class="nav-item"><a class="nav-link" href="features.html">Speed test</a></li>
        <li class="nav-item"><a class="nav-link" href="integrations.html">Search Question</a></li>
        <li class="nav-item"><a class="nav-link" href="pricing.html">Top Questions</a></li>
        <li class="nav-item">
          <form method="post" action="route">
            <button type="submit" class="nav-link" style="background: none; border: none; cursor: pointer;">Routes</button>
          </form>
        </li>
      </ul>
    </div>
  </div>
</nav>
<header class="pt-5">
  <div class="container pt-4 pt-xl-5">
    <div class="row pt-5">
      <div class="col-md-8 text-center text-md-start mx-auto">
        <div class="text-center">
          <h1 class="display-4 fw-bold mb-5"><br><br></h1>
          <form class="d-flex justify-content-center flex-wrap" method="post">
            <div class="shadow-lg mb-3"></div>
            <div class="shadow-lg mb-3"><button class="btn btn-primary" type="submit">Get Route</button></div>
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