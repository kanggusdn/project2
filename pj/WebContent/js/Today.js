$(function() {
	$(".goods__card-size").each(function() {
		$(this).click(function() {
			localStorage["Goods"] = "goodsList";
			localStorage[Goods] = "pcList";
			localStorage[Goods] = "comuList";
		})
	})
	$("#imageList").each(function() {
		$(this).click(function() {
			var goodsList = localStorage[?];
			var pcList = localStorage[?];
			var comuList = localStorage[?];
		})
	})
	$(".delete").each(function() {
		$(this).click(function() {
			delete localStorage[?];
			delete localStorage[?];
			delete localStorage[?];
		})
	})
	$(".alldelete").click(function() {
		localStorage.clear();
	})
})