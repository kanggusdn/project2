package svc;

import java.sql.Connection;

import dao.RecommandDAO;

import static db.JdbcUtil.*;
import vo.RecommandBean;

public class RecommandDetailService {

	public RecommandBean getArticle(int recommand_num) throws Exception{ 
		RecommandBean article = null;
			Connection con = getConnection();
			RecommandDAO recommandDAO = RecommandDAO.getInstance();
			recommandDAO.setConnection(con);
			int updateCount = recommandDAO.updateReadCount(recommand_num);
			
			if(updateCount > 0) {
				commit(con);
			} else {
				rollback(con);
			}
			
			article = recommandDAO.selectArticle(recommand_num);
			close(con);
			return article; 
			
	
	}

}
