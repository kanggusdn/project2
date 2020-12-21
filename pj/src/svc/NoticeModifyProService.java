package svc;

import java.sql.Connection;

import dao.NoticeDAO;

import static db.JdbcUtil.*;
import vo.NoticeBean;

public class NoticeModifyProService {

	public boolean modifyArticle(NoticeBean article) throws Exception {
		boolean isModifySuccess = false;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		int updateCount = noticeDAO.updateArticle(article);

		if (updateCount > 0) {
			commit(con);
			isModifySuccess = true;

		} else {
			rollback(con);
		}
		if (con != null)
			close(con);
		return isModifySuccess;
	}

}
