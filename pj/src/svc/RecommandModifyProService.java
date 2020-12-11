package svc;

import java.sql.Connection;

import dao.RecommandDAO;

import static db.JdbcUtil.*;
import vo.RecommandBean;

public class RecommandModifyProService {

	public boolean isArtcleWriter(int recommand_num, String pass) throws Exception {
		boolean isArticleWriter = false;
		Connection con = getConnection();
		RecommandDAO recommandDAO = RecommandDAO.getInstance();
		recommandDAO.setConnection(con);
		isArticleWriter = recommandDAO.isArticleRecommandWriter(recommand_num, pass);
		if (con != null)
			close(con);
		return isArticleWriter;
	}

	public boolean modifyArticle(RecommandBean article) throws Exception {
		boolean isModifySuccess = false;
		Connection con = getConnection();
		RecommandDAO recommandDAO = RecommandDAO.getInstance();
		recommandDAO.setConnection(con);
		int updateCount = recommandDAO.updateArticle(article);

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
