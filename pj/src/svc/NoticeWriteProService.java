package svc;

import java.sql.Connection;

import dao.NoticeDAO;

import static db.JdbcUtil.*;
import vo.NoticeBean;

public class NoticeWriteProService {

	public boolean registArticle(NoticeBean noticeBean) throws Exception {
		boolean isWriteSuccess = false;
		Connection conn = null;
		try {
			conn = getConnection();
			NoticeDAO noticeDAO = NoticeDAO.getInstance();
			noticeDAO.setConnection(conn);
			int insertCount = noticeDAO.insertArticle(noticeBean);

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
