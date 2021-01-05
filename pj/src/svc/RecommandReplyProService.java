package svc;

import java.sql.Connection;

import dao.RecommandDAO;

import static db.JdbcUtil.*;

import vo.RecommandBean;

public class RecommandReplyProService {

	public boolean replyArticle(RecommandBean article) throws Exception {
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection conn = null;
		try {
			conn = getConnection();
			RecommandDAO recommandDAO = RecommandDAO.getInstance();
			recommandDAO.setConnection(conn);
			insertCount = recommandDAO.insertReplyArticle(article);

			if (insertCount > 0) {
				commit(conn);
				isReplySuccess = true;
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				close(conn);
		}
		return isReplySuccess;
	}

}
