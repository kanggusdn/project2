$(function() {
	/*
		search 안보이게 하는 기능
	 */
	var CheckSideBtn = false;
	var CheckMainBtn = false;
	$("#navMainBtn").click(function(e) {
		e.preventDefault();
		if (CheckSideBtn == false) {
			$("#navSideBtn").hide();
			CheckSideBtn = true;
		} else {
			$("#navSideBtn").show();
			CheckSideBtn = false;
		}
	});
	$("#navSideBtn").click(function(e) {
		e.preventDefault();
		if (CheckMainBtn == false) {
			$("#navMainBtn").hide();
			CheckMainBtn = true;
		} else {
			$("#navMainBtn").show();
			CheckMainBtn = false;
		}
	});

	/* login시 joinBtn click 후 loginmodal close */
	$("#loginModalJoinBtn").click(function() {
		$('#loginModal').modal('hide');
		$('#joinModal').modal('show');
	});
	/* 중복 ID 확인 */
	$("#joinId").change(function(e) {
		e.preventDefault();
		$.get("ajaxJoinId.jsp", { "joinId": $(this).val() }, function(data) {
			var obj = jQuery.parseJSON(data);
			console.log(obj[0]);
			if (obj[0] == true) {
				$("#LoginCheck").html("<span class='form-control'>이미 사용중인 아이디 입니다.</span>");
				$("#joinbutton").attr("disabled", "disabled");
			} else {
				$("#LoginCheck").html("<span class='form-control'>중복확인이 완료되었습니다.</span>");
				$("#joinbutton").removeAttr("disabled");
			}
		});
	});
	/* 비밀번호 중복확인 */
	$(function() {
		$("#alert-success").hide();
		$("#alert-danger").hide();
		$("input").keyup(function() {
			var pwd1 = $("#pass").val();
			var pwd2 = $("#password").val();
			if (pwd1 != "" || pwd2 != "") {
				if (pwd1 == pwd2) {
					$("#alert-success").show();
					$("#alert-danger").hide();
					$("#joinbutton").removeAttr("disabled");
				} else {
					$("#alert-success").hide();
					$("#alert-danger").show();
					$("#joinbutton").attr("disabled", "disabled");
				}
			}
		});

	});

	/*
		2020/12/15 공지사항 글쓰기, 수정 모달 시작
	 */
	$(".noticeViewLink").each(function() {
		$(this).click(function() {
			console.log($(this).attr("data-num"));
			$("#notice_num").val($(this).attr("data-num"));
			$("#notice_num2").val($(this).attr("data-num"));
			$(this).parent().next().next().next().text(Number($(this).parent().next().next().next().text()) + 1);
			$.get("ajaxNotice.jsp", { "selectArticle": $(this).attr("data-num") }, function(data) {
				var view = $.parseJSON(data);
				console.log(view);
				$("#noticeName").text(view[0]);
				$("#noticeSubject").text(view[1]);
				$("#noticeContent").text(view[2]);
				$("#notice_subject2").val(view[1]);
				$("#notice_content2").val(view[2]);
			});
			var del = $.parseJSON(data);
			console.log(del);
			$("#notice_pass2").val(del[0]);
		});
	});
});
	/* 모달 끝 */
