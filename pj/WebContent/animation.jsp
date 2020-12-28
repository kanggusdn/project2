<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet">
<style>
* {
	margin: 0;
	padding: 0;
	text-decoration: none;
}

body {
	width: 100%;
	height: 100%;
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
	top: 40%;
	left: 48%;
	font-size: 50px;
}

::-webkit-scrollbar {
	display: none;
}

.navbar__fixed-top {
	z-index: 1000;
}

/*side bar css*/

/* The sidebar menu */
.sidenav {
	margin-top: 50px;
	width: 160px; /* Set the width of the sidebar */
	position: fixed; /* Fixed Sidebar (stay in place on scroll) */
	top: 0; /* Stay at the top */
	right: 0;
	background-color: #111; /* Black */
	padding-top: 20px;
	height: 100%;
}

/* The navigation menu links */
.sidenav__menu a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
}

/* When you mouse over the navigation links, change their color */
.sidenav a:hover {
	color: #f1f1f1;
}

.sidebtn {
	position: absolute;
	left: -30px;
	top: 449px;
	width: 30px;
	height: 72px;
	background-color: #111;
	display: block;
}
.sidebtn a {
	
	font-size:23px;
	text-decoration: none;
	color: #818181;
	display: block;
}

/* On smaller screens, where height is less than 450px, change the style of the sidebar (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav__menu a {
		font-size: 18px;
	}
}
</style>
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
		<div class="container-fluid">
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03"
				aria-controls="navbarTogglerDemo03" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<a class="navbar-brand" href="#">홈페이지 로고</a>
			<div class="collapse navbar-collapse" id="navbarTogglerDemo03">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<section class="animation__start">
		<div>
			<span class="text__center">C&nbsp;P&nbsp;U</span> <img
				class="animation__image" src="img/animationIMG/cat1.jpg">
		</div>
		<div>
			<span class="text__center">S&nbsp;S&nbsp;D</span> <img
				class="animation__image" src="img/animationIMG/cat2.jpg">
		</div>
		<div>
			<span class="text__center">P&nbsp;O&nbsp;W&nbsp;E&nbsp;R</span> <img
				class="animation__image" src="img/animationIMG/cat3.jpg">
		</div>
		<div>
			<span class="text__center">R&nbsp;A&nbsp;M</span> <img
				class="animation__image" src="img/animationIMG/cat4.jpg">
		</div>
		<div>
			<span class="text__center">C&nbsp;A&nbsp;S&nbsp;E</span> <img
				class="animation__image" src="img/animationIMG/cat5.jpg">
		</div>
		<div>
			<span class="text__center">G&nbsp;R&nbsp;A&nbsp;P&nbsp;H&nbsp;I&nbsp;C</span>
			<img class="animation__image" src="img/animationIMG/cat6.jpg">
		</div>
	</section>

	<div class="sidenav">
		<div class= "sidenav__menu">
			<a href="#">로그인</a> <a href="#">회원가입</a> <a href="#">장바구니</a> <a
				href="#">최근본상품</a>
		</div>
		<div class="sidebtn">
			<a class= "mx-auto"href= "#">닫기</a>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$(function() {
			var cnt = 0;
			var $gal = $(".animation__start > div");
			var $nav = $("nav")
			$gal.hide();
			$gal.eq(cnt).show();

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