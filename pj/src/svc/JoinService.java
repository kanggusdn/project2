package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.LoginDAO;
import vo.Member;

public class JoinService {

	public int insertMember(Member member) {
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection conn = null;
		int joinMember = loginDAO.insertMember(member);
		try {
			conn = getConnection();
			loginDAO.setConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		if (conn != null)
			close(conn);
		}
		return joinMember;

	}
}
