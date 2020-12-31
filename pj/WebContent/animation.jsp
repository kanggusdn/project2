<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- title image -->
<link href="img/EzIcon.jpg" rel="icon" type="image/x-icon">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="css/style.css" />
<style>
* {
	margin: 0;
	padding: 0;
	text-decoration: none;
}

body {
	width: 100%;
	height: 100%;
	color: #fff;
}

.animation__start {
	position: absolute;
	width: 100%;
	height: 100%;
	top: 0;
	left: 0;
	overflow: hidden;
}

.animation__image {
	width: 100%;
	height: 100%
}

.animation__start div {
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
}

.text__center {
	position: absolute;
	top: 10%;
	left: 45%;
	font-size: 50px;
}

::-webkit-scrollbar {
	display: none;
}

.navbar__fixed-top {
	z-index: 1000;
}

.mousewheel {
	display: block;
	position: absolute;
	bottom: 100px;
	left: 50%;
	z-index: 1000;
}

.mousewheel__animate {
	-webkit-animation: sdb .5s infinite;
	animation: sdb .5s infinite;
}

@-webkit-keyframes sdb {
	0% {
		opacity: 0;
	}
	40%	{
		opacity:1;
	}
	80%	{
		opacity:0;
	}
	100%	{
		opacity:0;
	}
}
@keyframes sdb {
	0% {
		opacity: 0;
	}
	40%	{
		opacity:1;
	}
	80%	{
		opacity:0;
	}
	100%	{
		opacity:0;
	}
}
</style>
<title>Ezcom Animation</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<div class="container-fluid">
			<button class="navbar-toggler togglerBtn" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03"
				aria-controls="navbarTogglerDemo03" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item navbar__icon"><a href="index.do"><img class="navbar__icon-image" alt="-"
					src="img/EzIcon.jpg"></a> </li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="index.do">Home</a></li>
					<li class="nav-item"><a class="nav-link" target="_blank" href="http://www.naver.com">Naver</a></li>
					<li class="nav-item"><a class="nav-link" target="_blank" href="http://www.daum.net">Daum</a></li>
					<li class="nav-item"><a class="nav-link" target="_blank" href="http://www.google.com">Google</a></li>
				</ul>
			</div>
		</div>
	</nav>



	<section class="animation__start">
		<div>
			<span class="text__center">C&nbsp;P&nbsp;U</span> <img
				class="animation__image" src="img/animationIMG/CPUryzen.jpg">
		</div>
		<div>
			<span class="text__center">S&nbsp;S&nbsp;D</span> <img
				class="animation__image" src="img/animationIMG/SamSSD.jpg">
		</div>
		<div>
			<span class="text__center">P&nbsp;O&nbsp;W&nbsp;E&nbsp;R</span> <img
				class="animation__image" src="img/animationIMG/MiPower.jpg">
		</div>
		<div>
			<span class="text__center">R&nbsp;A&nbsp;M</span> <img
				class="animation__image" src="img/animationIMG/Gskill.jpg">
		</div>
		<div>
			<span class="text__center">C&nbsp;A&nbsp;S&nbsp;E</span> <img
				class="animation__image" src="img/animationIMG/ABKO.png">
		</div>
		<div>
			<span class="text__center">G&nbsp;R&nbsp;A&nbsp;P&nbsp;H&nbsp;I&nbsp;C</span>
			<img class="animation__image" src="img/animationIMG/main3060.jpg">
		</div>
		<div>
			<span class="text__center">C&nbsp;O&nbsp;O&nbsp;L&nbsp;E&nbsp;R</span>
			<img class="animation__image" src="img/animationIMG/Cooler.jpg">
		</div>
		<div>
			<span class="text__center">H&nbsp;D&nbsp;D</span>
			<img class="animation__image" src="img/animationIMG/Seagate.jpg">
		</div>
		<div>
			<span class="text__center">M&nbsp;O&nbsp;U&nbsp;S&nbsp;E</span>
			<img class="animation__image" src="img/animationIMG/Mouse.jpg">
		</div>
		<div>
			<span class="text__center">K&nbsp;E&nbsp;Y&nbsp;B&nbsp;O&nbsp;A&nbsp;R&nbsp;D</span>
			<img class="animation__image" src="img/animationIMG/Keyboard.jpg">
		</div>
	</section>

	<div class="mousewheel">
		<div>
			<i class="fas fa-angle-double-up fa-2x mousewheel__animate"></i>
		</div>
		<div>
			<i class="fas fa-mouse fa-2x mousewheel__animate"></i>
		</div>
		<div>
			<i class="fas fa-angle-double-down fa-2x mousewheel__animate"></i>
		</div>
	</div>




	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script src="https://kit.fontawesome.com/6478f529f2.js"></script>
	<script src="js/jquery.snowfall.js"></script>
	<script>
		$(function() {
			var cnt = 0;
			var $gal = $(".animation__start > div");
			var $nav = $("nav")
			var $togglerH = $(".navbar-collapse");
			$gal.hide();
			$gal.eq(cnt).show();
			$(".open").hide();
			$(window).on(
					"wheel mousewheel DOMMouseScroll",
					function(e) {
						if ($gal.queue().length > 0)
							return;
						if (e.originalEvent.wheelDelta == 150
								|| e.originalEvent.detail == -3) {
							if (cnt > 0) { //올리기
								$gal.eq(cnt).clone().attr("id", "clone")
										.prependTo("section").css({
											"position" : "absolute",
											"z-index" : "100",
											"width" : "100%",
											"height" : "100vh"
										}).animate({
											"width" : "200%",
											"top" : "-50%",
											"height" : "200%",
											"left" : "-50%",
											"opacity" : "0"
										}, 1000, function() {
											$("#clone").remove();
										});
								$gal.hide();
								$gal.eq(--cnt).fadeIn(2500);
							}
						} else if (e.originalEvent.wheelDelta == -150
								|| e.originalEvent.detail == 3) {
							if (cnt < $gal.length - 1) { //내리기
								$gal.eq(cnt).clone().attr("id", "clone")
										.prependTo("section").css({
											"position" : "absolute",
											"z-index" : "100",
											"width" : "100%",
											"height" : "100vh"
										}).animate({
											"width" : "200%",
											"top" : "-50%",
											"height" : "200%",
											"left" : "-50%",
											"opacity" : "0"
										}, 1000, function() {
											$("#clone").remove();
										});
								$gal.hide();
								$gal.eq(++cnt).fadeIn(2500);
							}
						}
					});

		});
	</script>
</body>
</html>