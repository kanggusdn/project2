package svc;

import java.sql.Connection;

import dao.BoardDAO;

import static db.JdbcUtil.*;
import vo.BoardBean;

public class BoardDetailService {

	public BoardBean getArticle(int board_num) throws Exception {
		BoardBean article = null;
		Connection conn = null;
		try {
			conn = getConnection();
			BoardDAO boardDAO = BoardDAO.getInstance();
			boardDAO.setConnection(conn);
			int updateCount = boardDAO.updateReadCount(board_num);
			article = boardDAO.selectArticle(board_num);
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
