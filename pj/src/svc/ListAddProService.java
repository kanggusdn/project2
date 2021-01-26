package svc;

import java.sql.Connection;

import dao.BoardDAO;
import dao.GoodsDAO;

import static db.JdbcUtil.*;
import vo.BoardBean;
import vo.Goods;

public class ListAddProService {

	public boolean registArticle(Goods goods) throws Exception {
		boolean isWriteSuccess = false;
		Connection conn = null;
		try {
			conn = getConnection();
			GoodsDAO goodsDAO = GoodsDAO.getInstance();
			goodsDAO.setConnection(conn);
			int insertCount = goodsDAO.insertGoods(goods);

			if (insertCount > 0) {
				commit(conn);
				isWriteSuccess = true;
			} else {
				rollback(conn);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return isWriteSuccess;
	}

}
