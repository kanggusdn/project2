package svc;

import java.sql.Connection;

import dao.RecommandDAO;

import static db.JdbcUtil.*;
import vo.RecommandBean;

public class RecommandDetailService {

	public RecommandBean getArticle(int recommand_num) throws Exception {
		RecommandBean article = null;
		Connection conn = null;
		try {
			conn = getConnection();
			RecommandDAO recommandDAO = RecommandDAO.getInstance();
			recommandDAO.setConnection(conn);
			int updateCount = recommandDAO.updateReadCount(recommand_num);
			article = recommandDAO.selectArticle(recommand_num);
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
