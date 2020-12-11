package svc;

import java.sql.Connection;

import dao.NoticeDAO;

import static db.JdbcUtil.*;
import vo.NoticeBean;

public class NoticeModifyProService {

	public boolean isArtcleWriter(int notice_num, String pass) throws Exception {
		boolean isArticleWriter = false;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		isArticleWriter = noticeDAO.isArticleNoticeWriter(notice_num, pass);
		if (con != null)
			close(con);
		return isArticleWriter;
	}

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
