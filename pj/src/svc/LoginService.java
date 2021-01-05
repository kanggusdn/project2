package svc;

import java.sql.Connection;

import dao.LoginDAO;
import vo.Member;
import static db.JdbcUtil.*;

public class LoginService {

	public Member getLoginMember(String id, String passwd) {
		Connection conn = null;
		LoginDAO loginDAO = null;
		Member loginMember = null;
		try {
			loginDAO = LoginDAO.getInstance();
			conn = getConnection();
			loginDAO.setConnection(conn);
			loginMember = loginDAO.selectLoginMember(id, passwd);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		if (conn != null)
			close(conn);
		}
		return loginMember;
	}

}
