package svc;

import java.sql.Connection;

import dao.BoardDAO;

import static db.JdbcUtil.*;
import vo.BoardBean;

public class BoardModifyProService {

	public boolean isArticleWriter(int board_num, String pass) throws Exception {
		boolean isArticleWriter = false;
		Connection conn = null;
		try {
			conn = getConnection();
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(conn);
			isArticleWriter = boardDAO.isArticleBoardWriter(board_num, pass);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				close(conn);
		}
		return isArticleWriter;
	}

	public boolean modifyArticle(BoardBean article) throws Exception {
		boolean isModifySuccess = false;
		Connection conn = null;
		try {
			conn = getConnection();
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(conn);
			int updateCount = boardDAO.updateArticle(article);

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

}
