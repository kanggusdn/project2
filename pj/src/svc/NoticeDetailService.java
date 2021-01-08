package svc;

import java.sql.Connection;

import dao.NoticeDAO;

import static db.JdbcUtil.*;
import vo.NoticeBean;

public class NoticeDetailService {

	public NoticeBean getArticle(int notice_num) throws Exception {
		NoticeBean article = null;
		Connection con = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(con);
		int updateCount = noticeDAO.updateReadCount(notice_num);

		if (updateCount > 0) {
			commit(con);
		} else {
			rollback(con);
		}

		article = noticeDAO.selectArticle(notice_num);
		close(con);
		return article;

	}

}
