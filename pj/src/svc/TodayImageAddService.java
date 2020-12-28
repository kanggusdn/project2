package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dao.GoodsDAO;
import vo.Today;
import vo.Goods;

public class TodayImageAddService {
	public Goods getTodayGoods(int id) {
		Connection conn = getConnection();

		GoodsDAO goodsDAO = GoodsDAO.getInstance();
		goodsDAO.setConnection(conn);
		Goods Goods = goodsDAO.selectsamtb(id);
		
		close(conn);

		return Goods;
	}
	

	public void addImage(HttpServletRequest request, Goods imageGoods) {
		HttpSession session = request.getSession();
		ArrayList<Today> todayImageList = (ArrayList<Today>) session.getAttribute("todayImageList");
		
		
		
		boolean isNewImage = false;
		if (todayImageList == null) {
			todayImageList = new ArrayList<Today>();
			isNewImage = true;
		}
		
		boolean isAddImage = false;
		for (int i = 0; i < todayImageList.size(); i++) {
			if (imageGoods.getId() == todayImageList.get(i).getId()) {
				todayImageList.get(i).setQty(todayImageList.get(i).getQty() + 1);
				isAddImage = true;
				break;
			} 
		}
		
		System.out.println(isAddImage);
		System.out.println(todayImageList);
		
		if(!isAddImage) {
			Today today = new Today();
			today.setImage(imageGoods.getImage());
			today.setKind(imageGoods.getKind());
			today.setPrice(imageGoods.getPrice());
			today.setQty(1);
			todayImageList.add(today);
		}
		
		session.setAttribute("todayImageList", todayImageList);
	}
}
