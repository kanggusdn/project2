package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GoodsCartSearchService;
import vo.ActionForward;
import vo.Cart;

public class GoodsCartSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsCartSearchService goodsCartSearchService = new GoodsCartSearchService();
		int startMoney = 0;
		int endMoney = Integer.MAX_VALUE;
		try {
			startMoney = Integer.parseInt(request.getParameter("startMoney"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			endMoney = Integer.parseInt(request.getParameter("endMoney"));

		} catch (Exception e) {
			// TODO: handle exception
		}
		ArrayList<Cart> cartList = goodsCartSearchService.getCartSearchList(startMoney, endMoney, request);
		request.setAttribute("cartList", cartList);
		request.setAttribute("startMoney", startMoney);
		request.setAttribute("endMoney", endMoney);
		int totalMoney = 0;
		int money = 0;

		for (int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice() * cartList.get(i).getQty();
			totalMoney += money;
		}
		request.setAttribute("totalMoney", totalMoney);
		ActionForward forward = new ActionForward("goodsCartList.jsp", false);
		return forward;
	}
}
