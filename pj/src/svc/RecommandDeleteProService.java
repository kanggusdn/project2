package svc;

import static db.JdbcUtil.*;
import java.sql.Connection;

import dao.RecommandDAO;

public class RecommandDeleteProService {

	public boolean isArticleWriter(int recommand_num, String pass) throws Exception {
		boolean isArticleWriter = false;
		Connection conn = getConnection();
		RecommandDAO recommandDAO = RecommandDAO.getInstance();
		recommandDAO.setConnection(conn);
		isArticleWriter = recommandDAO.isArticleRecommandWriter(recommand_num, pass);
		if (conn != null)
			close(conn);
		return isArticleWriter;
	}

	public boolean removeArticle(int recommand_num) throws Exception {
		
		boolean isRemoveSuccess = false;
		Connection conn = getConnection();
		RecommandDAO recommandDAO = RecommandDAO.getInstance();
		recommandDAO.setConnection(conn);
		int deleteCount = recommandDAO.deleteArticle(recommand_num);
		
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
