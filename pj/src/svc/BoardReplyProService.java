package svc;

import java.sql.Connection;

import dao.BoardDAO;

import static db.JdbcUtil.*;

import vo.BoardBean;

public class BoardReplyProService {

	public boolean replyArticle(BoardBean article) throws Exception {
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection conn = null;
		try {
			conn = getConnection();
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(conn);
			insertCount = boardDAO.insertReplyArticle(article);

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
