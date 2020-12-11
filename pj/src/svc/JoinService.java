package svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.LoginDAO;
import vo.Member;

public class JoinService {

	public int insertMember(Member member) {
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection conn = getConnection();
		loginDAO.setConnection(conn);
		int joinMember = loginDAO.insertMember(member);
		if (conn != null)
			close(conn);
		return joinMember;

	}
}
