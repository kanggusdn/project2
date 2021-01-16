package svc;

import java.sql.Connection;

import dao.NoticeDAO;

import static db.JdbcUtil.*;
import vo.NoticeBean;

public class NoticeModifyProService {

	public boolean modifyArticle(NoticeBean article) throws Exception {
		boolean isModifySuccess = false;
		Connection con = null;
		try {
			con = getConnection();
			NoticeDAO noticeDAO = NoticeDAO.getInstance();
			noticeDAO.setConnection(con);
			int updateCount = noticeDAO.updateArticle(article);

			if (updateCount > 0) {
				commit(con);
				isModifySuccess = true;

			} else {
				rollback(con);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (con != null)
				close(con);
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
			// TODO: handle exception
		} finally {
			close(conn);
		}

		return isModifySuccess;
	}

}
