package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GoodsCartListService;
import vo.ActionForward;
import vo.Cart;

public class GoodsCartListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsCartListService goodsCartListService = new GoodsCartListService();
		ArrayList<Cart> cartList = goodsCartListService.getcartList(request);

		// 총금액 계산
		int totalMoney = 0;
		int money = 0;
		
		if(cartList != null) {
			for (int i = 0; i < cartList.size(); i++) {
				money = cartList.get(i).getPrice();
				totalMoney += money;
			}
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		ActionForward forward = new ActionForward("goodsCartList.jsp", false);
		return forward;
	}
}
