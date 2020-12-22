package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.GoodsDAO;
import vo.Cart;
import vo.Goods;

public class GoodsCartAddService {
	public Goods getCartGoods(int id) {
		Connection conn = getConnection();

		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(conn);
		Goods Goods = goodsDAO.selectsamtb(id);
		
		close(conn);

		return Goods;
	}
	

	public void addCart(HttpServletRequest request, Goods cartGoods) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		
		
		
		boolean isNewCart = false;
		if (cartList == null) {
			cartList = new ArrayList<Cart>();
			isNewCart = true;
		}
		
		boolean isAddCart = false;
		for (int i = 0; i < cartList.size(); i++) {
			if (cartGoods.getId() == cartList.get(i).getId()) {
				cartList.get(i).setQty(cartList.get(i).getQty() + 1);
				isAddCart = true;
				break;
			} 
		}
		
		System.out.println(isAddCart);
		System.out.println(cartList);
		
		if(!isAddCart) {
			Cart cart = new Cart();
			cart.setImage(cartGoods.getImage());
			cart.setKind(cartGoods.getKind());
			cart.setPrice(cartGoods.getPrice());
			cart.setQty(1);
			cartList.add(cart);
		}
		
		session.setAttribute("cartList", cartList);
	}
}
