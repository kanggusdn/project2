package svc;

import java.sql.Connection;

import dao.RecommandDAO;

import static db.JdbcUtil.*;
import vo.RecommandBean;

public class RecommandModifyProService {

	public boolean isArtcleWriter(int recommand_num, String pass) throws Exception {
		boolean isArticleWriter = false;
		Connection conn = null;
		try {
			conn = getConnection();
			RecommandDAO recommandDAO = RecommandDAO.getInstance();
			recommandDAO.setConnection(conn);
			isArticleWriter = recommandDAO.isArticleRecommandWriter(recommand_num, pass);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				close(conn);
		}
		return isArticleWriter;
	}

	public boolean modifyArticle(RecommandBean article) throws Exception {
		boolean isModifySuccess = false;
		Connection conn = null;
		try {
			conn = getConnection();
			RecommandDAO recommandDAO = RecommandDAO.getInstance();
			recommandDAO.setConnection(conn);
			int updateCount = recommandDAO.updateArticle(article);

			if (updateCount > 0) {
				commit(conn);
				isModifySuccess = true;

			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				close(conn);
		}
		return isModifySuccess;
	}

}
