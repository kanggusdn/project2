
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vo.Member, vo.Goods"%>
<%@ page import="java.util.HashMap,java.util.ArrayList"%>
<%@page import="vo.PageInfo"%>
<%@page import="vo.BoardBean"%>
<%@page import="vo.RecommandBean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	ArrayList<RecommandBean> articleList = (ArrayList<RecommandBean>) request.getAttribute("articleList");
PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
int listCount = pageInfo.getListCount();
int nowPage = pageInfo.getPage();
int maxPage = pageInfo.getMaxPage();
int startPage = pageInfo.getStartPage();
int endPage = pageInfo.getEndPage();
%>
<%
	Member loginMember = (Member) session.getAttribute("loginMember");
ArrayList<Goods> todayImageList = (ArrayList<Goods>) request.getAttribute("todayImageList");
%>
<!DOCTYPE html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<!-- title image -->

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
<body>
	<!-- 2020-12-02 haesu -->
<nav
		class="navbar navbar-expand-lg bg-light fixed-top navbar-light justify-content-between"
		id="header">
		<div class= "text-left">
			<button class="navbar-toggler" id = "navMainBtn" type="button" data-toggle="collapse"
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
		<!-- 2020 12 23 haesu -->
		<div>
			<button class="navbar-toggler" id = "navSideBtn"type="button" data-toggle="collapse"
				data-target="#infoDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="true" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="infoDropdown">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="goodsCartList.do"><i class="fas fa-cart-arrow-down"></i></a></li>

					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"><i
							class="fas fa-business-time"></i></a>
						<div class="dropdown-menu dropdown-menu-right today__Range"
							aria-labelledby="navbarDropdownMenuLink">
							<h2>최근 본 상품</h2>
							<div class="today__Range-margin">
								<div class="today__Range-width">
									<div class="todayImagethumb">
										<img src="img/gift.svg" alt="..." class="todayImageSize">
									</div>
									<div class="todayImagethumb">
										<img src="img/gift.svg" alt="..." class="todayImageSize">
									</div>

									<div class="todayImagethumb">
										<img src="img/gift.svg" alt="..." class="todayImageSize">
									</div>

									<div class="todayImagethumb">
										<img src="img/gift.svg" alt="..." class="todayImageSize">
									</div>
									<div class="todayImagethumb">
										<img src="img/gift.svg" alt="..." class="todayImageSize">
									</div>

									<div class="todayImagethumb">
										<img src="img/gift.svg" alt="..." class="todayImageSize">
									</div>
									<div class="todayImagethumb">
										<img src="img/gift.svg" alt="..." class="todayImageSize">
									</div>
									<div class="todayImagethumb">
										<img src="img/gift.svg" alt="..." class="todayImageSize">
									</div>
								</div>
							</div>
						</div>	
					</li>

					<li class="nav-item dropdown"><a class="nav-link" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"><i
							class="fas fa-user-alt"></i></a>
						<div class="dropdown-menu  dropdown-menu-right"
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
								if (loginMember.getId().equals("admin")) {
							%>
							<button type="button"
								class="dropdown-item btn btn-primary btn-sm btn-block"
								onclick="location.href='admin.do'">관리자 전용 페이지</button>

							<%
								}
							%>
							<%
								}
							%>

						</div></li>
				</ul>
			</div>
		</div>
	</nav>

	<div id="main" class="bbs__margin-top">
		<div class="container pt-4">
			<div class="card text-center p-4">
				<h1 class="mt-4">컴퓨터 추천 커뮤니티</h1>
				<table class="table table-hover">

					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
							<td>날짜</td>
							<td>조회수</td>
						</tr>
						<%
							for (int i = 0; i < articleList.size(); i++) {
						%>
						<tr>
							<td><%=articleList.get(i).getRecommand_num()%></td>

							<td>
								<%
									if (articleList.get(i).getRecommand_re_lev() != 0) {
								%> <%
 	for (int a = 0; a <= articleList.get(i).getRecommand_re_lev() * 2; a++) {
 %> &nbsp; <%
 	}
 %> ▶ <%
 	} else {
 %> <%
 	}
 %> <a
								href="recommandDetail.do?recommand_num=<%=articleList.get(i).getRecommand_num()%>&page=<%=nowPage%>">
									<%=articleList.get(i).getRecommand_subject()%>
							</a>
							</td>

							<td><%=articleList.get(i).getRecommand_name()%></td>
							<td><%=articleList.get(i).getRecommand_date()%></td>
							<td><%=articleList.get(i).getRecommand_readcount()%></td>
						</tr>
						<%
							}
						%>
					
				</table>
				<a href="recommandWriteForm.do" class="btn btn-primary">글쓰기</a>
			</div>

			<section id="pageList">
				<%
					if (nowPage <= 1) {
				%>
				<div class = "btn btn-primary">
				이전
				</div>
				<%
					} else {
				%>
				<a href="recommandList.do?page=<%=nowPage - 1%>" class = "btn btn-primary">이전</a>&nbsp;
				<%
					}
				%>
				<%
					for (int a = startPage; a <= endPage; a++) {
					if (a == nowPage) {
				%>
				<div class = "btn btn-primary active">
				<%=a%>
				</div>
				<%
					} else {
				%>

				<a href="recommandList.do?page=<%=a%>" class = "btn btn-primary"><%=a%>
				</a>&nbsp;
				<%
					}
				%>
				<%
					}
				%>
				<%
					if (nowPage >= maxPage) {
				%>
				<div class = "btn btn-primary">
				다음
				</div>
				<%
					} else {
				%>
				<a href="recommandList.do?page=<%=nowPage + 1%>" class = "btn btn-primary">다음</a>
				<%
					}
				%>
			</section>
		</div>
	</div>

	<!-- 2020-12-02 haesu -->
	

	<footer class="text-center text-white footer__color">
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
	<!-- end -->

	<!-- Login Modal  2020-12-03 haesu-->

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
						<button type="submit" class="btn btn-primary form-control">가입</button>
					</form>
				</div>
			</div>
		</div>
	</div>






	<div class="modal fade" id="profileModal" data-backdrop="static"
		data-keyboard="false" tabindex="-1"
		aria-labelledby="staticBackdropLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="staticBackdropLabel">프로필 수정 페이지</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="joinPro.do" method="post">
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
							<input type="text" id="sample4_postcode2" placeholder="우편번호"
								class="form-control" name="addr1" required="required"
								autocomplete="off"> <input type="button"
								onclick="sample4_execDaumPostcode()" value="우편번호 찾기"
								class="form-control"><input type="text"
								id="sample4_roadAddress2" placeholder="도로명주소"
								class="form-control" name="addr2" required="required"
								autocomplete="off"> <input class="form-control"
								type="text" id="sample4_jibunAddress2" placeholder="상세주소"
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
						<button type="submit" class="btn btn-primary form-control">변경</button>
					</form>
				</div>

			</div>
		</div>
	</div>


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
	<script src="https://kit.fontawesome.com/6478f529f2.js"></script>
</body>
</html>