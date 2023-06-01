<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
    <link rel="stylesheet" href="style/assetsIndex/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&amp;display=swap">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md fixed-top navbar-shrink py-3" id="mainNav">
    <div class="container"><a class="navbar-brand d-flex align-items-center" href="index.jsp"><span>NetSide</span></a><button data-bs-toggle="collapse" class="navbar-toggler" data-bs-target="#navcol-1"><span class="visually-hidden">Toggle navigation</span><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="navbar-nav mx-auto">
                <li class="nav-item"></li>
            </ul><a class="btn btn-primary shadow" role="button" href="signup.jsp">Sign up</a>
        </div>
    </div>
</nav>
<header class="pt-5">
    <div class="container pt-4 pt-xl-5">
        <div class="row pt-5">
            <div class="col-md-8 text-center text-md-start mx-auto">
                <div class="text-center">
                    <h1 class="display-4 fw-bold mb-5">Welcome to NetSide</h1>
                    <form class="d-flex justify-content-center flex-wrap" method="post" action="login.jsp">
                        <div class="shadow-lg mb-3"></div>
                        <div class="shadow-lg mb-3"><button class="btn btn-primary" type="submit">Log In</button></div>
                    </form>
                </div>
            </div>
            <div class="col-12 col-lg-10 mx-auto">
                <div class="text-center position-relative"></div>
            </div>
        </div>
    </div>
</header>
<script src="style/assetsIndex/bootstrap/js/bootstrap.min.js"></script>
<script src="style/assetsIndex/js/script.min.js"></script>
</body>
</html>