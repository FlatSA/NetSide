<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Log in</title>
    <link rel="stylesheet" href="style/assetsLogin/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
</head>
<body>
<nav class="navbar navbar-light navbar-expand-md fixed-top navbar-shrink py-3" id="mainNav">
    <div class="container">
        <a class="navbar-brand d-flex align-items-center" href="index.jsp"><span>NetSide</span></a>
        <button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1">
            <span class="visually-hidden">Toggle navigation</span>
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="navbar-nav mx-auto"></ul>
        </div>
    </div>
</nav>

<section class="py-4 py-md-5 my-5">
    <div class="container py-md-5">
        <div class="row">
            <div class="col-md-5 col-lg-3 col-xl-3 text-center text-md-start">
                <h2 class="display-6 fw-bold mb-5">
                    <span class="underline pb-1">Login</span>
                </h2>
                <form action="main" method="get">
                    <div class="mb-3">
                        <input class="shadow form-control" type="text" name="username" placeholder="Your username exists">
                    </div>
                    <div class="mb-3">
                        <input class="shadow form-control" type="password" name="password" placeholder="Password">
                    </div>
                    <div class="mb-5">
                        <input class="btn btn-primary shadow" type="submit" value="LogIn">
                    </div>
                    <p class="text-muted"><a href="forgotten-password.html"></a></p>
                </form>
            </div>
        </div>
    </div>
</section>

<footer></footer>

<script src="style/assetsLogin/bootstrap/js/bootstrap.min.js"></script>
<script src="style/assetsLogin/js/script.min.js"></script>
</body>
</html>
