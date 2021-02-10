<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="vo.Member, vo.Goods"%>
<%@ page import="java.util.HashMap,java.util.ArrayList"%>
<%@page import="vo.PageInfo"%>
<%@page import="vo.BoardBean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
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
<title>컴퓨터 상품 등록 페이지</title>
</head>
<body>
<!-- 2020-12-02 haesu -->
	<nav
		class="navbar navbar-expand-lg bg-light fixed-top navbar-light justify-content-between"
		id="header">
		<div class = "text-left">
			<button class="navbar-toggler" type="button" data-toggle="collapse" id = "navMainBtn"
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
		<div class = "text-right">
			<button class="navbar-toggler" type="button" data-toggle="collapse" id = "navSideBtn"
				data-target="#infoDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="true" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse dropdown-menu-end" 
				id="infoDropdown">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="goodsCartList.do"><i class="fas fa-cart-arrow-down"></i></a></li>

					<li class="nav-item dropdown" id="today__Range-close"><a class="nav-link" href="#"
						id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"><i
							class="fas fa-business-time"></i></a>
							
							<!-- 2021 01 06 gang -->
							
						<div class="dropdown-menu dropdown-menu-right today__Range"
							aria-labelledby="navbarDropdownMenuLink">
							<h2>최근 본 상품</h2>
							<div class="today__Range-margin">
								<div class="today__Range-width">
								<div class = "today__Range-div">
									<%for(int i = 0; i <8 ; i++) {%>
									<div class="todayImagethumb">
										<img src="img/todayIMG/gift.svg" alt="..." class="todayImageSize">
									</div>
									<%} %>
									</div>
									<div class = "today__LSDelete">
										<button class = "btn btn-danger today__LSDelete-Btn" onclick="LSDelete()">전부 삭제</button>
								</div>
								</div>
							</div>
						</div></li>
						<!-- end -->
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
		
	<!-- 2021/1/20 컴퓨터 상품 등록 시작 -->
	<section id="listAddForm" class = "listadd__margin-top">
		<div class="card container pt-4" style="width: 40%">
			<div class="text-center m-3 ">
				<h2>컴퓨터 상품 등록</h2>
			</div>
			<form action="ListAddPro.do" name="listAddform"
				enctype="multipart/form-data" method="post">
				<div class="form-col">
					<div class="form-group">
						<label for="PCselect">상품 종류</label> 
							<select id="PCselect" name="kind">
								<option value="select">선택</option>
								<option value="goods">컴퓨터 부품</option>
								<option value="comu">조립PC</option>
								<option value="pc">브랜드PC</option>
							</select> 
							<select id="goods">
								<option value="cpu">CPU</option>
								<option value="cooler">쿨러/튜닝</option>
								<option value="mainboard">메인보드</option>
								<option value="memory">메모리</option>
								<option value="graphic">그래픽카드</option>
								<option value="ssd">SSd</option>
								<option value="harddisk">하드디스크</option>
								<option value="sidedisk">외장HDD/SSD</option>
								<option value="case">케이스</option>
								<option value="power">파워</option>
								<option value="keyboard">키보드</option>
								<option value="mouse">마우스</option>
								<option value="odd">ODD</option>
								<option value="monitor">모니터</option>
								<option value="software">소프트웨어</option>
							</select> 
							<select id="comu">
								<option value="user">유저 추천 조립PC</option>
								<option value="owner">사장 추천 조립PC</option>
								<option value="CEO">컴퓨터 부품 회사 추천 조립PC</option>
							</select> 
							<select id="pc">
								<option value="SAMSUNG">SAMSUNG</option>
								<option value="HP">HP</option>
								<option value="LG">LG</option>
								<option value="LENOVO">LENOVO</option>
								<option value="DELL">DELL</option>
								<option value="ASUS">ASUS</option>
							</select>
					</div>
					<div class="form-group">
						<label for="name">상품명</label> 
							<input type="text" id="goodsName" name="name" class="form-control" required="required">
					</div>
					<div class="form-group">
						<label for="price">가격</label> 
						<input type="number" id="goodsPrice" name="price" class="form-control" required="required">
					</div>
					<div class="form-group">
						<label for="goodsImage">상품 이미지</label> 
						<input type="file" id="goodsImage" name="goodsImage" class="form-control" required="required">
					</div>
					<div class="form-group">
						<label for="goodsModalImage">상품 상세 이미지</label> 
						<input type="file" id="goodsModalImage" name="goodsModalImage" class="form-control" required="required">
					</div>
					<button type="submit" class="btn btn-primary">등록</button>
					<button type="reset" class="btn btn-info">취소</button>
				</div>
			</form>
		</div>
	</section>
	<!-- 상품 등록 끝 -->
	
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
	<!-- end -->

	<!-- Login Modal  2020-12-03 haesu-->

	<div class="modal fade" id="loginModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">로그인</h5>
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
							<input type="text" class="form-control" name="id" id="joinId"
								placeholder="아이디" maxlength="20" required="required"
								autocomplete="off" />
						</div>
						<div class="form-group" id="LoginCheck">
							<span class="form-control">중복 확인을 해주세요</span>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="passwd"
								id="pass" placeholder="비밀번호" maxlength="20" required="required"
								autocomplete="off" />
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="passwd"
								id="password" placeholder="비밀번호 확인" maxlength="20"
								required="required" autocomplete="off" />
						</div>
						<div class="form-group">
							<div class="form-control" id="alert-success"
								style="color: white; background: #738ED1;">비밀번호가 일치합니다.</div>
							<div class="form-control" id="alert-danger"
								style="color: white; background: #FC707D;">비밀번호가 일치하지
								않습니다.</div>
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
						<button type="submit" class="btn btn-primary form-control"
							id="joinbutton">가입</button>
					</form>
				</div>
			</div>
		</div>
	</div>

	<!-- 2020/12/04 강현우 프로필 수정 -->
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
	<!-- 프로필 수정 end -->

	<!-- 2020-12-08 haesu -->
	<div class="modal fade" id="Snote" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog__size">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">세부정보</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div>
						<img style="width: 100%;"
							src="http://ai.esmplus.com/gded/i/s/20201105/14/16045528895220704521.jpg">
					</div>
					<div>
						<img style="width: 100%;"
							src="http://ai.esmplus.com/gded/i/s/20201109/14/1604900967901eb863b2.jpg">
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="modal fade" id="LGDesk" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog__size">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">세부정보</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div>
						<img style="width: 100%;"
							src="http://cms.ygoon.com/editorStore/file/202011/26/14c55f83e3154dbd8063f48934bbe884.jpg">
					</div>
				</div>

			</div>
		</div>
	</div>

	<div class="modal fade" id="LEM70t" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog__size">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">세부정보</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div>
						<img style="width: 100%;"
							src="http://gi.esmplus.com/hpinvent/PC/LENOVO/M70T/11EVS00B00/11EVS00B00.png">
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="BHP190ML" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog__size">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">세부정보</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div>
						<img style="width: 100%;"
							src="http://www.pc4all.co.kr/imgdata3/iteminfoimage/2019/12/17/rewq4321_5.jpg">
					</div>
				</div>

			</div>
		</div>
	</div>


	<div class="modal fade" id="ADPC4-21300" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog__size">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">세부정보</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div>
						<img style="width: 100%;"
							src="https://shopping-phinf.pstatic.net/20200609_15_27/f9668473-82e6-431e-b712-f2c29a7cedb4/%EC%88%98%EC%A0%95%EB%90%A8_DDR4_detail_890_final.jpg">
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="modal fade" id="CG6" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-dialog__size">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">세부정보</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div>
						<img style="width: 100%;"
							src="https://ssl.pstatic.net/imgshopping/spec/157/30/27/15730273792_0_20181018115519.jpg">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end -->
	
	<!-- Optional JavaScript -->
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="js/header.js"></script>
	<script src="js/main.js"></script>
	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="js/addr.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
	<!-- notice modal용 부트스트랩 -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"></script>
	<script src="https://kit.fontawesome.com/6478f529f2.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#goods").hide();
			$("#comu").hide();
			$("#pc").hide();
			$("#PCselect").change(function() {
				if ($(this).val() == "goods") {
					$("#goods").show();
					$("#goods").attr("name","kind");
					$("#comu").hide();
					$("#comu").removeAttr("name","kind");
					$("#pc").hide();
					$("#pc").removeAttr("name","kind");
				} else if ($(this).val() == "comu") {
					$("#comu").show();
					$("#comu").attr("name","kind");
					$("#goods").hide();
					$("#goods").removeAttr("name","kind");
					$("#pc").hide();
					$("#pc").removeAttr("name","kind");
				} else if ($(this).val() == "pc") {
					$("#pc").show();
					$("#pc").attr("name","kind");
					$("#goods").hide();
					$("#goods").removeAttr("name","kind");
					$("#comu").hide();
					$("#comu").removeAttr("name","kind");
				} else if ($(this).val() == "select") {
					$("#goods").hide();
					$("#goods").removeAttr("name","kind");
					$("#comu").hide();
					$("#comu").removeAttr("name","kind");
					$("#pc").hide();
					$("#pc").removeAttr("name","kind");
				}
			});
		});
		var localIMG = new Array();
		var cnt = 0;
		cnt = $.cookie("cnt");
		var closeCnt = 0;
		var temp = $.cookie("cnt");
		$(function() {
			//로컬스토리지 불러오기
			for (var i = 0; i < localStorage.length; i++) {
				localStorage.getItem(localStorage.key($.cookie("cnt")));
				// 여기까지
				console.log(localStorage.getItem(localStorage.key(i)));
				
					$(".todayImagethumb").eq(i).empty();
					$(".todayImagethumb").eq(i).append("<img class='todayImageSize' src='./img/" + localStorage.getItem(localStorage.key(i)) + "'/>");
					$(".todayImagethumb").eq(i).append("<button type='button' class='close today__close closeBtn'><span>&times;</span></button>");
					$(".closeBtn").unbind();
					$(".closeBtn").click(function(){
						$(".today__Range-div").append("<div class='todayImagethumb'><img class='todayImageSize' src='./img/todayIMG/gift.svg'/></div>");
						$(".today__Range-div").find("div").eq($(this).parent().index()).remove();
						$.cookie("cnt", $.cookie("cnt")-1);
					});
				}
			$('#today__Range-close').on('hide.bs.dropdown', function (e) {
			    if (e.clickEvent) {
			      e.preventDefault();
			    }
			});
		});
		function LSDelete() {
			localStorage.clear();
			$(".today__Range-div").empty();
			for(var i=0; i<8; i++)
			$(".today__Range-div").append("<div class='todayImagethumb'><img class='todayImageSize' src='./img/todayIMG/gift.svg'/></div>");
		}
	</script>
</body>
</html>