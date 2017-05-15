<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Smash Live</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/cover.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="cover-container">

				<div class="masthead clearfix">
					<div class="inner">
						<h3 class="masthead-brand">Smash Live</h3>
						<nav>
							<ul class="nav masthead-nav">
								<li class="active"><a href="#">Home</a></li>
								<li><a href="faq.jsp">FAQ</a></li>
							</ul>
						</nav>
					</div>
				</div>
				<br> <br>



				<div class="mastfoot">
					<div class="inner">
						<p>AISS 2016/17 - Guillermo BandrÃ©s y Pablo Romero.</p>
					</div>
				</div>

			</div>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-8" style="background-color:;">
						<img src="img/placeholder600x300.png" height=500px; width=1000px;><br>
						<br> <br>
					</div>
					<div class="col-md-4 text-left" style="background-color:;">
						<br> <br>
						<form>
							Smash.gg tournament URL:<br> <input type="text"
								style="color: black" name="smashggURL" size="60" required><br>
							<br> Challonge API Key:<br> <input type="text"
								style="color: black" name="challongeKey" size="40" required>
						</form>
						<br>
						<p>
							<tag:notloggedin>
								<a href="TwitterLogIn"><img
									src="./img/Sign-in-with-Twitter-darker.png" /></a>
							</tag:notloggedin>
							<tag:loggedin>
								<h1>Welcome ${twitter.screenName} (${twitter.id})</h1>
								<a href="./logout">logout</a>
							</tag:loggedin>
						</p>
						<p>
							<a  href="#"><img
								src="http://ttv-api.s3.amazonaws.com/assets/connect_dark.png"
								class="twitch-connect"/></a>

					</div>
				</div>
				<br> <br>
				<div class="row">
					<div class="col-md-5" style="background-color:;">
						<br>
					</div>
					<div class="col-md-2">
						<p>
							<a href="app.jsp" class="btn btn-lg btn-default">Go Live!</a>
						</p>
					</div>
					<div class="col-md-5" style="background-color:;">
						<br>
					</div>
				</div>
			</div>
		</div>


	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
