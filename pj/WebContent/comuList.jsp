<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap,java.util.ArrayList"%>
<%@ page import="vo.Member, vo.Goods"%>
<%
	Member loginMember = (Member) session.getAttribute("loginMember");
ArrayList<Goods> comuList = (ArrayList<Goods>) request.getAttribute("comuList");
ArrayList<Goods> todayImageList = (ArrayList<Goods>) request.getAttribute("todayImageList");
int cnt = 0;
%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- title image -->
<link href="img/EzIcon.jpg" rel="icon" type="image/x-icon">
<!-- reset -->
<link rel="stylesheet"
	href="https://meyerweb.com/eric/tools/css/reset/reset.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" />
<!-- text -->
<link
	href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
<!-- css origin -->
<link rel="stylesheet" href="css/style.css" />
<title>컴퓨터 홈 쇼핑 사이트</title>
</head>
<body oncontextmenu="return false" ondragstart="return false"
	onselectstart="return false">
	<!-- 2020-12-07 haesu -->
	<nav
		class="navbar navbar-expand-lg bg-light fixed-top navbar-light justify-content-between"
		id="header">
		<div>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="true" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse mr-4" id="navbarNavDropdown">
				<div class="navbar__icon d-lg-block d-none">
					<a href="index.do"><img class="navbar__icon-image" alt="-"
						src="img/EzIcon.jpg"></a>
				</div>
				<ul class="navbar-nav">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false">컴퓨터부품</a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">

							<a class="dropdown-item" href="goodsList.do?kind=cpu">CPU</a> <a
								class="dropdown-item" href="goodsList.do?kind=cooler">쿨러/튜닝</a>
							<a class="dropdown-item" href="goodsList.do?kind=mainboard">메인보드</a>
							<a class="dropdown-item" href="goodsList.do?kind=memory">메모리</a>
							<a class="dropdown-item" href="goodsList.do?kind=graphic">그래픽카드</a>
							<a class="dropdown-item" href="goodsList.do?kind=SSD">SSd</a> <a
								class="dropdown-item" href="goodsList.do?kind=harddisk">하드디스크</a>
							<a class="dropdown-item" href="goodsList.do?kind=sidedisk">외장HDD/SSD</a>
							<a class="dropdown-item" href="goodsList.do?kind=case">케이스</a> <a
								class="dropdown-item" href="goodsList.do?kind=power">파워</a> <a
								class="dropdown-item" href="goodsList.do?kind=keyboard">키보드</a>
							<a class="dropdown-item" href="goodsList.do?kind=mouse">마우스</a> <a
								class="dropdown-item" href="goodsList.do?kind=odd">ODD</a> <a
								class="dropdown-item" href="goodsList.do?kind=moniter">모니터</a> <a
								class="dropdown-item" href="goodsList.do?kind=software">소프트웨어</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> 조립PC </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="comuList.do?kind=user">유저 추천
								조립PC</a> <a class="dropdown-item" href="comuList.do?kind=owner">사장
								추천 조립PC</a> <a class="dropdown-item" href="comuList.do?kind=CEO">컴퓨터
								부품 회사 추천 조립PC</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> 브랜드PC </a>
						<div class="dropdown-menu "
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="pcList.do?kind=SAMSUNG">삼성전자</a> <a
								class="dropdown-item" href="pcList.do?kind=HP">HP</a> <a
								class="dropdown-item" href="pcList.do?kind=LG">LG전자</a> <a
								class="dropdown-item" href="pcList.do?kind=LENOVO">레노버</a> <a
								class="dropdown-item" href="pcList.do?kind=DELL">DELL</a> <a
								class="dropdown-item" href="pcList.do?kind=ASUS">ASUS</a>
						</div></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> 커뮤니티 </a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<a class="dropdown-item" href="boardList.do">컴퓨터 리뷰 커뮤니티</a> <a
								class="dropdown-item" href="recommandList.do">컴퓨터 추천 커뮤니티</a>
						</div></li>
				</ul>
			</div>
		</div>
		<div>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#infoDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="true" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse dropdown-menu-end"
				id="infoDropdown">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="goodsCartList.do"><i class="fas fa-cart-arrow-down"></i></a></li>

					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"><i
							class="fas fa-business-time"></i></a>
						<div class="dropdown-menu dropdown-menu-end"
							aria-labelledby="navbarDropdownMenuLink">
							<h6>최근 본 상품</h6>
							<div class="container">
								<%
									if (todayImageList != null && todayImageList.size() > 0) {
									for (int i = 0; i < todayImageList.size(); i++) {
										if (i % 3 == 0) {
								%>
								<div class="card-deck">
									<%
										}
									%>

									<div class="card goods__card-size">
										<img src="./img/<%=todayImageList.get(i).getImage()%>"
											class="card-img-top card-img__size" alt="...">
										<div class="card-body">
											<p class="card-text">
												상품명:
												<%=todayImageList.get(i).getKind()%><br /> 가격:
												<%=todayImageList.get(i).getPrice()%><br />
											</p>
										</div>

									</div>
									<%
										if (i % 3 == 2) {
									%>
								</div>
								<%
									}
								%>
								<%
									if (i % todayImageList.size() == todayImageList.size() - 1) {
								%>

								<%
									break;
								}
								}
								}
								%>
							</div>
						</div></li>

					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"><i
							class="fas fa-user-alt"></i></a>
						<div class="dropdown-menu"
							aria-labelledby="navbarDropdownMenuLink">
							<%
								if (loginMember == null) {
							%>
							<button type="button"
								class="dropdown-item btn btn-primary btn-sm btn-block"
								data-toggle="modal" data-target="#loginModal">로그인</button>
							<button type="button"
								class="dropdown-item btn btn-primary btn-sm btn-block"
								data-toggle="modal" data-target="#joinModal">회원가입</button>
							<%
								} else {
							%>
							<button type="button"
								class="dropdown-item btn btn-primary btn-sm btn-block"
								onclick="location.href='logout.do'">로그아웃</button>
							<button type="button"
								class="dropdown-item btn btn-primary btn-sm btn-block"
								data-toggle="modal" data-target="#profileModal">프로필 수정</button>
							<%
								}
							%>

						</div></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<section class="container__size" id="home">
			<div class=" w-100 ">
				<div id="carouselExampleControls"
					class="carousel slide w-100 container__center "
					data-ride="carousel">
					<div class="carousel-inner w-100 ">
						<div class="carousel-item active w-100">
							<img src="img/come.png" class="d-block w-100" alt="..."
								style="height: 400px">
						</div>
						<div class="carousel-item w-100">
							<img src="img/norefund.png" class="d-block w-100" alt="..."
								style="height: 400px">
						</div>
						<div class="carousel-item w-100">
							<img src="img/attack.jpg" class="d-block w-100" alt="..."
								style="height: 400px">
						</div>
					</div>
					<a class="carousel-control-prev" href="#carouselExampleControls"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#carouselExampleControls"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>
		</section>

		<div class="startLine text-center">
			<p class="startLine__text"><%=comuList.get(1).getKind()%></p>
		</div>
		<br>
		<%
			for (int i = 0; i < comuList.size(); i++) {
			if (i % 3 == 0) {
		%>
		<div class="card-deck">
			<%
				}
			%>

			<div class="card goods__card-size">
				<a data-toggle="modal"
					data-target="#<%=comuList.get(i).getModalip()%>"> <img
					src="./img/<%=comuList.get(i).getImage()%>"
					class="card-img-top card-img__size" alt="..." id="todayImage1">
					<div class="card-body">
						<p class="card-text">
							상품명:
							<%=comuList.get(i).getName()%><br /> 가격:
							<%=comuList.get(i).getPrice()%><br />
						</p>
					</div>
				</a>
			</div>
			<%
				if (i % 3 == 2) {
			%>
		</div>
		<%
			}
		%>
		<%
			if (i % 9 == 8) {
		%>

		<%
			break;
		}
		}
		%>

	</div>
	<footer class="text-center footer__color text-white">
		<div class="footer-above">
			<div class="container pt-4">
				<div class="row">
					<div class="footer-col col-md-4">
						<h3 style="color: white;">위치</h3>
						<p>
							영남기술교육원<br />대구광역시 달서구
						</p>
					</div>
					<div class="footer-col col-md-4">
						<h3 style="color: white;">소셜 미디어</h3>
						<a href="#" class="btn btn-light m-2"><img
							src="img/facebook.svg"></a> <a href="#"
							class="btn btn-light m-2"><img src="img/youtube.svg"></a> <a
							href="#" class="btn btn-light m-2"><img src="img/twitter.svg"></a>
						<a href="#" class="btn btn-light m-2"><img
							src="img/twitch.svg"></a> <a href="#" class="btn btn-light m-2"><img
							src="img/instagram.svg"></a>
					</div>
					<div class="footer-col col-md-4">
						<h3 style="color: white;">개발자 한마디</h3>
						<p>언제든지 연락주세요!!</p>
					</div>
				</div>
			</div>
		</div>
		<div class="footer-below pb-4">
			<div class="container text-center">
				<div>Copyright &copy; JP 2020. All Right Reserved.</div>
			</div>
		</div>
	</footer>


	<div class="modal fade" id="loginModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">회원가입</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="loginPro.do" method="post">
						<div class="form-group">
							<label for="id">ID</label> <input type="text"
								class="form-control" id="id" aria-describedby="emailHelp"
								name="id">
						</div>
						<div class="form-group">
							<label for="passwd">Password</label> <input type="password"
								class="form-control" id="passwd" name="passwd">
						</div>
						<button type="submit" class="btn btn-primary">로그인</button>
						<button type="button" class="btn btn-primary"
							id="loginModalJoinBtn">회원가입</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">취소</button>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- Join Modal -->
	<div class="modal fade" id="joinModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">회원가입</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="joinPro.do" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="id"
								placeholder="아이디" maxlength="20" required="required"
								autocomplete="off" />
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="passwd"
								placeholder="비밀번호" maxlength="20" required="required"
								autocomplete="off" />
						</div>
						<div class="form-group">
							<input type="text" class="form-control" name="name"
								placeholder="이름" maxlength="20" required="required"
								autocomplete="off" />
						</div>
						<div class="form-group">
							<input type="text" id="sample4_postcode" placeholder="우편번호"
								class="form-control" name="addr1" required="required"
								autocomplete="off"> <input type="button"
								onclick="sample4_execDaumPostcode()" value="우편번호 찾기"
								class="form-control"><input type="text"
								id="sample4_roadAddress" placeholder="도로명주소"
								class="form-control" name="addr2" required="required"
								autocomplete="off"> <input class="form-control"
								type="text" id="sample4_detailAddress" placeholder="상세주소"
								name="addr3" required="required" autocomplete="off">
						</div>
						<div class="form-group">
							<input type="number" class="form-control" name="age"
								placeholder="나이" maxlength="20" required="required"
								autocomplete="off" />
						</div>
						<div class="form-group">
							<div class="btn-group" data-toggle="buttons">
								<label class="btn btn-primary active"> <input
									type="radio" class="d-none" name="gender" autocomplete="off"
									value='M' checked="checked" />남자
								</label> <label class="btn btn-primary"> <input type="radio"
									class="d-none" name="gender" autocomplete="off" value='F' />여자
								</label>
							</div>
						</div>
						<div class="form-group">
							<input type="email" class="form-control" name="email"
								placeholder="이메일" maxlength="20" required="required"
								autocomplete="no" />
						</div>


						<!-- input타입 button은 value 값을 줘야함 -->
						<button type="submit" class="btn btn-primary form-control">가입</button>
					</form>
				</div>

			</div>
		</div>
	</div>
	<!-- end -->
	<%
		for (int i = 0; i < comuList.size(); i++) {
	%>
	<div class="modal fade" id="<%=comuList.get(i).getModalip()%>"
		tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog__size">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">제품 소개</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div>
						<img class="modal-image__size" alt="-"
							src="<%=comuList.get(i).getModalimage()%>">
					</div>
				</div>
			</div>
		</div>
		<div>
			<a class="btn btn-primary button__lo"
				href="goodsCartAdd.do?id=<%=comuList.get(i).getId()%>">장바구니에 담기</a>
		</div>
	</div>
	<%
		}
	%>







	<!-- Optional JavaScript -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
	<script src="js/header.js"></script>
	<script src="js/main.js"></script>
	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="js/addr.js"></script>
	<script src="js/Today.js"></script>
	<script src="https://kit.fontawesome.com/6478f529f2.js"
		crossorigin="anonymous"></script>
</body>
</html>




