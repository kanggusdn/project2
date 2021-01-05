package svc;

import java.sql.Connection;

import dao.NoticeDAO;

import static db.JdbcUtil.*;
import vo.NoticeBean;

public class NoticeDetailService {

	public NoticeBean getArticle(int notice_num) throws Exception {
		NoticeBean article = null;
		Connection conn = null;
		try {
			conn = getConnection();
			NoticeDAO noticeDAO = NoticeDAO.getInstance();
			noticeDAO.setConnection(conn);
			int updateCount = noticeDAO.updateReadCount(notice_num);
			article = noticeDAO.selectArticle(notice_num);
			if (updateCount > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		return article;

	}

}
