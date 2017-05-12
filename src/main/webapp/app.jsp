<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Smash Live - App</title>

<!-- Bootstrap core CSS -->
<link href="/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body style="margin-left: 20px;">

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Smash Live</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="index.html">Home</a></li>
					<li><a href="faq.html">FAQ</a></li>
					<li><a href="index.html">Log out</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container-fluid">

		<div class="row row-eq-height">
			<div class="col-md-4" style="background-color: lavender">
				<br>
				<h2>Tournament Bracket:</h2>
				<form>
					<div class="form-group">
						<select class="form-control" id="bracket">
							<option>Example Tournament - Top 32</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div>
				</form>
				<div class="row">
					<div class="col-md-12" style="background-color: IndianRed">
						<h2>Challonge URL:</h2>
						<form>
							<input class="form-control" type="url" id="challongeURL"
								value="challonge.com/yourTournament"></input>
						</form>
						<br> <br> <br>
					</div>
				</div>
			</div>
			<div class="col-md-4" style="background-color: lavenderblush">
				<br>
				<h2>Tweet format:</h2>
				<form>
					<textarea class="form-control" id="tweetFormat"
						style="font-size: 32px;" rows="3">$tournament$ $round$ is LIVE right now! Watch $players$ on twitch.tv/etsiimelee</textarea>
				</form>
				<br>
			</div>
			<div class="col-md-4" style="background-color: lavender">
				<br>
				<h2>Twitch.tv stream name:</h2>
				<textarea class="form-control" id="tweetFormat"
					style="font-size: 32px;" rows="3">$tournament$ - $round$ - $playersScore$</textarea>
				<br>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4" style="background-color: LightGreen">
				<h2>Log:</h2>
				<textarea class="form-control" id="log" rows="13">18:00:34 Stream Set ID 007814 Started.
																18:00:42 Stream name updated.
																18:00:44 Tweeted.
																18:02:31 Set ID 007815 Reported.
																18:02:34 Challonge Updated.
																18:16:11 Stream Set ID 007814 Ended.
																18:16:13 Challonge Updated.</textarea>
				<br>
			</div>
			<div class="col-md-4" style="background-color: LightPink">
				<br>
				<div class="row">
					<div class="col-md-6" style="background-color: LightBlue">
						<p style="font-size: 24px">
							<strong>Tweet every:</strong>
						</p>
					</div>
					<div class="col-md-6"
						style="background-color: LightRed; margin-left: -50px">
						<fieldset class="form-group" style="font-size: 24px">
							<div class="form-check">
								<label class="form-check-label"> <input type="radio"
									class="form-check-input" name="optionsRadios"
									id="optionsRadios1" value="option1" checked>Match
								</label>
							</div>
							<div class="form-check">
								<label class="form-check-label"> <input type="radio"
									class="form-check-input" name="optionsRadios"
									id="optionsRadios2" value="option2">Set
								</label>
							</div>
							<form class="form-inline">
								<div class="form-check inline disabled">
									<label class="form-check-label"> <input type="radio"
										class="form-check-input" name="optionsRadios"
										id="optionsRadios3" value="option3" disabled>Minutes:
									</label>
								</div>
								<div class="form-check inline">
									<input class="form-control" type="number" value="5"
										id="example-number-input">
								</div>
							</form>
						</fieldset>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4" style="background-color: lavender"></div>
					<div class="col-md-4" style="background-color: lavenderBlush">
					<br><br><br><br>
						<h2>Live?</h2>
						<div class="TriSea-technologies-Switch pull-left">
                            <input id="TriSeaPrimary" name="TriSea1" type="checkbox"/>
                            <label for="TriSeaPrimary" class="label-primary"></label>
                        </div>
					</div>
					<div class="col-md-4" style="background-color: lavender"></div>
				</div>
			</div>
			<div class="col-md-4" style="background-color: LightGreen">
				<br>
				<iframe src="http://player.twitch.tv/?channel=yahooesports"
					height="290" width="508" frameborder="0" scrolling="no"
					allowfullscreen="true"> </iframe>
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
</body>
</html>