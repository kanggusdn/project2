package svc;
import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GoodsDAO;
import vo.Goods;

public class ComuListService {

	public static ArrayList<Goods> getComuList(String kind) {
			
			GoodsDAO comuDAO = GoodsDAO.getInstance();
			Connection conn = getConnection();
			comuDAO.setConnection(conn);
			ArrayList<Goods> comuList = GoodsDAO.selectComuList(kind);
			if(comuList != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
			ArrayList<Goods> comus = GoodsDAO.selectComuList(kind);
			close(conn);
		return comuList;
	}

}
