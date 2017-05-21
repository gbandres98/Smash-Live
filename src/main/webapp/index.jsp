<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<p>AISS 2016/17 - Guillermo Bandrés y Pablo Romero.</p>
					</div>
				</div>

			</div>
			<div class="container-fluid">
				<div class="row">
					<div class="col-md-8" style="background-color:;">
						<br> <br> <img src="img/placeholder600x300.png"
							height=300px; width=600px;>
					</div>
					<div class="col-md-4 text-left" style="background-color:;">
						<br> <br>
						<form method="get" action="./GoApp">
							<br>
							<h2>Summoner name:</h2>
							<input type="text" style="color: black" name="summ" size="40"
								required><br> <br>
							<h2>Region:</h2>
							<select class="form-control" name="reg" id="sel1">
								<option value="EUW1">EUW</option>
								<option value="EUN1">EUNE</option>
								<option value="BR1">BR</option>
								<option value="JP1">JP</option>
								<option value="KR">KR</option>
								<option value="LA1">LAN</option>
								<option value="LA2">LAS</option>
								<option value="NA1">NA</option>
								<option value="0C1">OCE</option>
								<option value="TR1">TR</option>
								<option value="RU">RU</option>
							</select> <input type="submit" id="submit-form" class="hidden" />
						</form>
						<br>
						<p>
							<tag:notloggedin>
								<a href="TwitterLogIn"><img
									src="./img/Sign-in-with-Twitter-darker.png" /></a>
							</tag:notloggedin>
							<tag:loggedin>


								<h1>
									<img src='<c:catch>${twitterImg}</c:catch>' height=80px;
										width=80px; style="margin-right: 15px;">Twitter:
									@${twitter.screenName}
								</h1>
								<a style="font-size: 22px;" href="./TwitterLogOut">Log Out</a>

							</tag:loggedin>
						</p>
						<p>
							<tag:twnotloggedin>
								<a href="/TwitchLogIn"><img
									src="http://ttv-api.s3.amazonaws.com/assets/connect_dark.png"
									class="twitch-connect" /></a>
							</tag:twnotloggedin>
							<tag:twloggedin>


								<h1>
									<img src='<c:catch>${twitch.canal.logo}</c:catch>' height=80px;
										width=80px; style="margin-right: 15px;">Twitch:
									${twitch.canal.displayName}
								</h1>
								<a style="font-size: 22px;" href="./TwitchLogOut">Log Out</a>
							</tag:twloggedin>
					</div>
				</div>
				<br> <br>
				<div class="row">
					<div class="col-md-5" style="background-color:;">
						<br>
					</div>
					<div class="col-md-2">
						<p>
							<tag:2logged>							
								<label for="submit-form"><a style="margin-top:-150px;"
									class="btn btn-lg btn-default">Go Live!</a></label>
									<tag:summerror>
							<p>Oops, we couldn't find that summoner. Check that name and region are correct</p>
							</tag:summerror>
							</tag:2logged>
						<tag:2notlogged>
								<a class="btn btn-lg btn-default disabled">Log in to Twitter
									and Twitch first</a>
							</tag:2notlogged>
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
