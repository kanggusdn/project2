package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Cart;

public class GoodsCartSearchService {

	public ArrayList<Cart> getCartSearchList(int startMoney, int endMoney, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> oldcartList = (ArrayList<Cart>) session.getAttribute("cartList");
		ArrayList<Cart> cartList = new ArrayList<Cart>();

		for (int i = 0; i < oldcartList.size(); i++) {
			if (oldcartList.get(i).getPrice() >= startMoney && oldcartList.get(i).getPrice() <= endMoney) {
				cartList.add(oldcartList.get(i));
			}
		}
		return cartList;
	}

}
