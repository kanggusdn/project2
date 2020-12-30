$(function() {
	$("card goods__card-size").click(function() {
		localStorage.setItem("#todayImage1", "goodsList");
		localStorage.setItem("#todayImage2", "pcList");
		localStorage.setItem("#todayImage3", "comuList");
	})
	$("#imageList").click(function() {
		var goodsList = localStorage.getItem("#todayImage1");
		var pcList = localStorage.getItem("#todayImage2");
		var comuList = localStorage.getItem("#todayImage3");
	})
	$(".delete").click(function() {
		localStorage.removeItem("#todayImage1");
		localStorage.removeItem("#todayImage2");
		localStorage.removeItem("#todayImage3");
	})
	$(".alldelete").click(function() {
		localStorage.clear();
	})
})