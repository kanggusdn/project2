$(function() {
	$(".goods__card-size").each(function() {
		$(this).click(function() {
			localStorage["Goods"] = "goodsList 이것 2,3,4,5";
			localStorage[Goods] = "pcList 이것 2,3,4,5";
			localStorage[Goods] = "comuList 이것 2,3,4,5";
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