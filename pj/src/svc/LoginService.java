package svc;

import java.sql.Connection;

import dao.LoginDAO;
import vo.Member;
import static db.JdbcUtil.*;

public class LoginService {

	public Member getLoginMember(String id, String passwd) {
		LoginDAO loginDAO = LoginDAO.getInstance();
		Connection conn = null;
		Member loginMember = null;
		try {
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
