package svc;

import java.sql.Connection;

import dao.RecommandDAO;

import static db.JdbcUtil.*;
import vo.RecommandBean;

public class RecommandWriteProService {

	public boolean registArticle(RecommandBean recommandBean) throws Exception{
		boolean isWriteSuccess = false;
		Connection conn = getConnection();
		RecommandDAO recommandDAO = RecommandDAO.getInstance();
		recommandDAO.setConnection(conn);
		int insertCount = recommandDAO.insertArticle(recommandBean);
		
		if(insertCount > 0) {
			commit(conn);
			isWriteSuccess = true;
		} else {
			rollback(conn);
			
		}
		close(conn);
		return isWriteSuccess;
	}
	
}
