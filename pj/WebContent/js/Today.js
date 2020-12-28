$(function() {
	$(".").each(function() {
		$(this).click(function() {
			console.log($(this).find("img").attr("src"));
			$("#todayImage1").val();
			$("#todayImage2").val();
			$("#todayImage3").val();
			$.get("todayImageList.jsp", { "src": $(this).val() });
		});
	});
});