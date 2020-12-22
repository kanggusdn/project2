function checkAll(theForm) {
		if (theForm.remove.length == undefined) {
			theForm.remove.checked = theForm.allCheck.checked;

		} else {
			for (var i = 0; i < theForm.remove.length; i++) {
				theForm.remove[i].checked = theForm.allCheck.checked;
			}
		}
	}
	function checkQty(kind, qty) {
		if (qty != 1) {
			location.href = "goodsCartQtyDown.do?kind=" + kind;
		}
	}