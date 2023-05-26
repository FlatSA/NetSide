<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Sign up - Brand</title>
    <link rel="stylesheet" href="style/assetsSignUp/bootstrap/css/bootstrap.min.css">
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
            <div class="col-md-5 col-xl-4 text-center text-md-start">
                <h2 class="display-6 fw-bold mb-5"><span class="underline pb-1"><strong>Sign up</strong></span></h2>
                <form action="signup" method="post">
                    <div class="mb-3">
                        <input class="shadow-sm form-control" type="email" name="email" placeholder="Email">
                    </div>
                    <input class="shadow-sm form-control" type="text" name="username" placeholder="Username">
                    <div class="mb-3"></div>
                    <input class="shadow-sm form-control" type="password" name="password" placeholder="Password">
                    <div class="mb-3"></div>
                    <div class="mb-5">
                        <input class="btn btn-primary shadow" type="submit" value="Create account">
                    </div>
                    <p class="text-muted">Have an account? <a href="login.jsp">Log in&nbsp;<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" fill="none" stroke-linecap="round" stroke-linejoin="round" class="icon icon-tabler icon-tabler-arrow-narrow-right">
                        <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
                        <line x1="5" y1="12" x2="19" y2="12"></line>
                        <line x1="15" y1="16" x2="19" y2="12"></line>
                        <line x1="15" y1="8" x2="19" y2="12"></line>
                    </svg></a>&nbsp;</p>
                </form>
            </div>
        </div>
    </div>
</section>

<footer></footer>

<script src="style/assetsSignUp/bootstrap/js/bootstrap.min.js"></script>
<script src="style/assetsSighUp/js/script.min.js"></script>
</body>
</html>