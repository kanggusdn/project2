package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.NoticeDAO;

public class NoticeDeleteProService {

	public boolean isArticleWriter(int notice_num, String pass) throws Exception {
		boolean isArticleWriter = false;
		Connection conn = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(conn);
		isArticleWriter = noticeDAO.isArticleNoticeWriter(notice_num, pass);
		if (conn != null)
			close(conn);
		return isArticleWriter;
	}

	public void removeArticle(int notice_num) throws Exception {
		Connection conn = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(conn);
		int deleteCount = noticeDAO.deleteArticle(notice_num);
		
		if(deleteCount > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
	}

}
