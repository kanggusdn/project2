package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;

import dao.AdminDAO;

public class AdminDeleteService {
	public boolean removeAdmin(String id) throws Exception {

		boolean isRemoveSuccess = false;

		Connection conn = null;
		try {
			conn = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();

			adminDAO.setConnection(conn);
			int deleteCount = adminDAO.deleteAdmin(id);

			if (deleteCount > 0) {
				commit(conn);
				isRemoveSuccess = true;
			} else {
				rollback(conn);

			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(conn);
		}
		return isRemoveSuccess;
	}
}