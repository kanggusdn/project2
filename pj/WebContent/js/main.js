$(function() {
	$(".nav-tabs > li").click(function(e) {
		e.preventDefault();
		$(".nav-tabs > li >a").removeClass("active");
		$(this).find("a").addClass("active");
		$(".tab-info").addClass("d-none");
		let num = $(this).index();
		$(".tab-info").eq(num).removeClass("d-none");
	});

	$("#joinId").change(function() {
		$.get("ajaxJoinId.jsp", { "joinId": $(this).val() }, function(data) {
			var obj = jQuery.parseJSON(data);
			console.log(obj[0]);
			if (obj[0] == true) {
				$("#LoginCheck").html("<span class='form-control'>중복된 아이디입니다.</span>");
				$("#joinbutton").addClass("d-none");
			} else {
				$("#LoginCheck").html("<span class='form-control'>중복확인이 완료되었습니다.</span>");
				$("#joinbutton").removeClass("d-none");
			}
		});
	});
	
	/*
		2020/12/15 공지사항 글쓰기, 수정 모달 시작
	 */
	$(".noticeViewLink").click(function() {
		console.log($(this).attr("data-num"));
		$("#notice_num").val($(this).attr("data-num"));
		$.get("ajaxNotice.jsp", { "selectArticle": $(this).attr("data-num") }, function(data) {
			var view = $.parseJSON(data);
			console.log(view);
			$("#noticeName").text(view[0]);
			$("#noticeSubject").text(view[1]);
			$("#noticeContent").text(view[2]);
			$("#notice_subject2").val(view[1]);
			$("#notice_content2").val(view[2]);
		});
	});
	/* 모달 끝 */
	
	/*
		2020/12/22 공지사항 글삭제 모달 시작
	*/
	$(".noticeViewLink").click(function() {
		console.log($(this).attr("data-num"));
		$("#notice_num2").val($(this).attr("data-num"));
		$.get("ajaxNotice.jsp", { "selectArticle": $(this).attr("data-num") }, function(data) {
			var del = $.parseJSON(data);
			console.log(del);
			$("#notice_pass2").val(del[0]);
		});
	});
	/* 모달 끝 */
});