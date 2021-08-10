package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.AdminDAO;
import dao.BoardDAO;
import vo.BoardBean;
import vo.Member;

public class AdminService {

	public ArrayList<Member> getAdminList() throws Exception {
		ArrayList<Member> adminList = null;
		Connection conn = null;
		try {
			conn = getConnection();
			AdminDAO adminDAO = AdminDAO.getInstance();
			adminDAO.setConnection(conn);
			adminList = adminDAO.selectAdminList();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (conn != null)
				close(conn);
		}
		return adminList;
	}
}