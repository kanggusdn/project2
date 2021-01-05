package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.RecommandDAO;
import vo.RecommandBean;

public class RecommandListService {

	public int getListCount() throws Exception {
		int listCount = 0;
		Connection conn = null;
		try {
			conn = getConnection();
			RecommandDAO recommandDAO = RecommandDAO.getInstance();
			recommandDAO.setConnection(conn);
			listCount = recommandDAO.selectListCount();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				close(conn);
		}
		return listCount;
	}

	public ArrayList<RecommandBean> getArticleList(int page, int limit) throws Exception {
		ArrayList<RecommandBean> articleList = null;
		Connection conn = null;
		try {
			conn = getConnection();
			RecommandDAO recommandDAO = RecommandDAO.getInstance();
			recommandDAO.setConnection(conn);
			articleList = recommandDAO.selectArticleList(page, limit);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				close(conn);
		}
		return articleList;

	}

}
