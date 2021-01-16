package svc;

import java.sql.Connection;

import dao.NoticeDAO;

import static db.JdbcUtil.*;

import vo.NoticeBean;

public class NoticeReplyProService {

	public boolean replyArticle(NoticeBean article) throws Exception {
		boolean isReplySuccess = false;
		int insertCount = 0;
		Connection conn = null;
		try {
			conn = getConnection();
			NoticeDAO noticeDAO = NoticeDAO.getInstance();
			noticeDAO.setConnection(conn);
			insertCount = noticeDAO.insertReplyArticle(article);

			if (insertCount > 0) {
				commit(conn);
				isReplySuccess = true;
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (conn != null)
				close(conn);
		}

		return isReplySuccess;
	}

}
