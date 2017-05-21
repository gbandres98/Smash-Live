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
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
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
<script>
	window.setInterval(function() {
		$.get("gameUpdate", function(status) {
			if (status == "newgame" || status == "samegame") {
				document.getElementById('summInfo').style.display = "none";
				document.getElementById('gameInfo').style.display = "inline";
			} else if (status == "endgame" || status == "nogame") {
				document.getElementById('gameInfo').style.display = "none";
				document.getElementById('summInfo').style.display = "inline";
				 document.getElementById("tweetResult").innerHTML ="";
				 document.getElementById("twitchResult").innerHTML ="";
			}
			if (status == "newgame"){
				if(document.getElementById('checkTweet').checked){
					postTweet();
				}if(document.getElementById('checkTwitch').checked){
					postTwitch();
				}
			}
		})

	}, 5000);
</script>
<script>
function postTweet() {
	var t = document.getElementById("twitterPost").innerHTML;
	  if (window.XMLHttpRequest) {
	   xmlhttp = new XMLHttpRequest();
	  } else {
	   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  var url = "/Tweet";
	  xmlhttp.open("POST", url, true);
	  xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	  xmlhttp.send("tweet="+t);
	  var respo= xmlhttp.responseText;
	  document.getElementById("tweetResult").innerHTML = "Tweeted!";
	 }
	 
function postTwitch() {
	var t = document.getElementById("twitchPost").innerHTML;
	  if (window.XMLHttpRequest) {
	   xmlhttp = new XMLHttpRequest();
	  } else {
	   xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	  }
	  var url = "/TwitchPost";
	  xmlhttp.open("POST", url, true);
	  xmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	  xmlhttp.send("title="+t);
	  var respo= xmlhttp.responseText;
	  document.getElementById("twitchResult").innerHTML = "Title changed!";
	 }
</script>
	
</head>

<body style="margin-left: 20px;background-color:Thistle;">

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
					<li><a href="index.jsp">Home</a></li>
					<li><a href="faq.jsp" target="faq">FAQ</a></li>
					<li><a href="/LogOut">Log out</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container-fluid">

		<div class="row row-eq-height">
			<div id="summInfo" class="col-md-4"
				>
				<h1>
					Summoner: <img style="vertical-align: bottom; margin-left: 20px;"
						height=80px; width=80px;
						src=<c:out value="http://ddragon.leagueoflegends.com/cdn/7.10.1/img/profileicon/${summoner.profileIconId}.png"/>>
					${summoner.name}
				</h1>
				<h3>Not in a game...</h3>



			</div>
			<div id="gameInfo" class="col-md-4"
				style="display: none;">
				<h1>
					Summoner: <img style="vertical-align: bottom; margin-left: 20px;"
						height=80px; width=80px;
						src=<c:out value="http://ddragon.leagueoflegends.com/cdn/7.10.1/img/profileicon/${summoner.profileIconId}.png"/>>
					${summoner.name}
				</h1>
				<h3>
					Now playing:
					<c:choose>
						<c:when test="${game.gameQueueConfigId == 420}">Ranked Solo, 5v5</c:when>
						<c:when test="${game.gameQueueConfigId == 0}">Custom</c:when>
						<c:when test="${game.gameQueueConfigId == 420}">Ranked Solo</c:when>
						<c:when test="${game.gameQueueConfigId == 420}">Ranked Solo</c:when>
						<c:when test="${game.gameQueueConfigId == 420}">Ranked Solo</c:when>
						<c:otherwise>Ranked Solo</c:otherwise>
					</c:choose>
					<script>
						var timerVar = setInterval(countTimer, 1000);
						var totalSeconds = ${game.gameLength};
						function countTimer() {
							++totalSeconds;
							var hour = Math.floor(totalSeconds / 3600);
							var minute = Math
									.floor((totalSeconds - hour * 3600) / 60);
							var seconds = totalSeconds
									- (hour * 3600 + minute * 60);

							document.getElementById("timer").innerHTML = "<strong>"
									+ minute + ":" + seconds + "</strong>";
						}
					</script>
					<a style="margin-left: 20px;" id="timer"></a>
				</h3>
				<h3>
					<img style="vertical-align: bottom; margin-right: 20px;"
						height=80px; width=80px;
						src=<c:out value="http://ddragon.leagueoflegends.com/cdn/7.10.1/img/champion/${champ.image.full}"/>><strong>${champ.name}</strong>,
					${champ.title}
				</h3>
			</div>
			<div class="col-md-4">
				<br>
				<h2>Tweet:</h2>
				<div id="twitterDiv">
				<form name="twitterForm">
					<textarea class="form-control" id="twitterPost"
						style="font-size: 32px;" rows="3" readonly>Playing ${champ.name} in a <c:choose><c:when test="${game.gameQueueConfigId == 420}">5v5 Solo Ranked</c:when><c:when test="${game.gameQueueConfigId == 0}">Custom game</c:when><c:when test="${game.gameQueueConfigId == 420}">Ranked Solo</c:when><c:when test="${game.gameQueueConfigId == 420}">Ranked Solo</c:when><c:when test="${game.gameQueueConfigId == 420}">Ranked Solo</c:when><c:otherwise>Ranked Solo</c:otherwise></c:choose> right now! Watch me at ${twitch.canal.url}</textarea>
										</form><button style="margin-top:15px;vertical-align:bottom;margin-right:15px;" class="btn btn-primary" onclick="postTweet()">Tweet</button><label class="custom-control custom-checkbox">
  <input name="checkTweet" id="checkTweet" type="checkbox" onclick="alertaChecked()" class="custom-control-input">
  <span class="custom-control-indicator"></span>
  <span class="custom-control-description">Tweet at game start</span>
</label><a style="margin-left:15px;" id="tweetResult"></a></div>
				<br>
			</div>
			<div class="col-md-4" >
				<br>
				<h2>Twitch.tv stream name:</h2>
				<textarea class="form-control" id="twitchPost"
					style="font-size: 32px;" rows="3" readonly>${summoner.name} | Playing ${champ.name} in <c:choose><c:when test="${game.gameQueueConfigId == 420}">5v5 Solo Ranked</c:when><c:when test="${game.gameQueueConfigId == 0}">Custom game</c:when><c:when test="${game.gameQueueConfigId == 420}">Ranked Solo</c:when><c:when test="${game.gameQueueConfigId == 420}">Ranked Solo</c:when><c:when test="${game.gameQueueConfigId == 420}">Ranked Solo</c:when><c:otherwise>Ranked Solo</c:otherwise></c:choose></textarea>
				<button style="margin-top:15px;vertical-align:bottom;margin-right:15px;" class="btn btn-primary" onclick="postTwitch()">Change Stream Title</button><label class="custom-control custom-checkbox">
  <input name="checkTwitch" id="checkTwitch" type="checkbox" onclick="alertaChecked()" class="custom-control-input">
  <span class="custom-control-indicator"></span>
  <span class="custom-control-description">Change title at game start</span>
</label><a style="margin-left:15px;" id="twitchResult"></a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4">
				<img style="vertical-align: bottom;width:500px;" 
					src=<c:out value="http://ddragon.leagueoflegends.com/cdn/img/champion/splash/${champ.name}_0.jpg"/>>
			</div>
			<div class="col-md-4">
			<a class="twitter-timeline" data-width="500" data-height="400" href="https://twitter.com/${twitter.screenName}">Tweets by ${twitter.screenName}</a> <script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>
				</div>
			<div class="col-md-4">
				<br>
				<iframe src="http://player.twitch.tv/?channel=${twitch.canal.name}"
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