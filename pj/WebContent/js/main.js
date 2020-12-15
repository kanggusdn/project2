$(function() {
	$(".nav-tabs > li").click(function(e) {
		e.preventDefault();
		$(".nav-tabs > li >a").removeClass("active");
		$(this).find("a").addClass("active");
		$(".tab-info").addClass("d-none");
		let num = $(this).index();
		$(".tab-info").eq(num).removeClass("d-none");
	});
	$("#loginModalJoinBtn").click(function() {
		$('#loginModal').modal('hide');
		$('#joinModal').modal('show');
	});
	$(".noticeViewLink").click(function(){
		$.get("ajaxNotice.jsp", {"selectArticle":$(this).attr("data-num")}, function(data){
			var view = jQuery.parseJSON(data);
			console.log(view);
			$("#noticeName").text(view[0]);
			$("#noticeSubject").text(view[1]);
			$("#noticeContent").text(view[2]);
		});
	});
});
