$(function() {
	$(".nav-tabs > li").click(function(e) {
		e.preventDefault();
		$(".nav-tabs > li >a").removeClass("active");
		$(this).find("a").addClass("active");
		$(".tab-info").addClass("d-none");
		let num = $(this).index();
		$(".tab-info").eq(num).removeClass("d-none");
	});
	
	/*
		2020/12/15 공지사항 모달 시작
	 */
	$(".noticeViewLink").click(function(){
		$.get("ajaxNotice.jsp", {"selectArticle":$(this).attr("data-num")}, function(data){
			var view = $.parseJSON(data);
			console.log(view);
			$("#noticeName").text(view[0]);
			$("#noticeSubject").text(view[1]);
			$("#noticeContent").text(view[2]);
		});
	});
});
	/* 모달 끝 */