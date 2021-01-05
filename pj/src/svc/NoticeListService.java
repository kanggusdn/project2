package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;

import dao.NoticeDAO;
import vo.NoticeBean;

public class NoticeListService {

	public int getListCount() throws Exception {
		int listCount = 0;
		Connection conn = null;
		try {
			conn = getConnection();
			NoticeDAO noticeDAO = NoticeDAO.getInstance();
			noticeDAO.setConnection(conn);
			listCount = noticeDAO.selectListCount();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				close(conn);
		}
		return listCount;
	}

	public ArrayList<NoticeBean> getArticleList(int page, int limit) throws Exception {
		ArrayList<NoticeBean> articleList = null;
		Connection conn = null;
		try {
			conn = getConnection();
			NoticeDAO noticeDAO = NoticeDAO.getInstance();
			noticeDAO.setConnection(conn);
			articleList = noticeDAO.selectArticleList(page, limit);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				close(conn);
		}
		return articleList;

	}

}
