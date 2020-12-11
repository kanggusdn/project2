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

	public boolean removeArticle(int notice_num) throws Exception {
		
		boolean isRemoveSuccess = false;
		Connection conn = getConnection();
		NoticeDAO noticeDAO = NoticeDAO.getInstance();
		noticeDAO.setConnection(conn);
		int deleteCount = noticeDAO.deleteArticle(notice_num);
		
		if(deleteCount > 0) {
			commit(conn);
			isRemoveSuccess=true;
		}else {
			rollback(conn);
			
		}
		close(conn);
		return isRemoveSuccess;
	}

}
