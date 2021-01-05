package svc;

import java.sql.Connection;

import dao.NoticeDAO;

import static db.JdbcUtil.*;
import vo.NoticeBean;

public class NoticeModifyProService {

	public boolean modifyArticle(NoticeBean article) throws Exception {
		boolean isModifySuccess = false;
		Connection conn = null;
		try {
			conn = getConnection();
			NoticeDAO noticeDAO = NoticeDAO.getInstance();
			noticeDAO.setConnection(conn);
			int updateCount = noticeDAO.updateArticle(article);

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

	public boolean registArticle(NoticeBean noticeBean) {
		boolean isModifySuccess = false;
		Connection conn = null;
		try {
			conn = getConnection();
			NoticeDAO noticeDAO = NoticeDAO.getInstance();
			noticeDAO.setConnection(conn);
			int insertCount = noticeDAO.insertArticle(noticeBean);

			if (insertCount > 0) {
				commit(conn);
				isModifySuccess = true;
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return isModifySuccess;
	}

}
