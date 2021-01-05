package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Member;

public class AdminDAO {
	private static AdminDAO adminDAO;
	private Connection conn;
	private PreparedStatement pstmt;

	public AdminDAO() {

	}

	public static AdminDAO getInstance() {
		if (adminDAO == null) {
			adminDAO = new AdminDAO();
		}
		return adminDAO;
	}

	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public ArrayList<Member> selectAdminList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member";
		ArrayList<Member> adminList = new ArrayList<Member>();
		Member member = null;

		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new Member();
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setName(rs.getString("name"));
				member.setAge(rs.getInt("age"));
				member.setGender(rs.getString("gender"));
				member.setEmail(rs.getString("email"));
				member.setAddr1(rs.getString("addr1"));
				member.setAddr2(rs.getString("addr2"));
				member.setAddr3(rs.getString("addr3"));
				adminList.add(member);
			}
		} catch (Exception e) {
			System.out.println("getmemberList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}

		return adminList;
	}
	
	public int deleteAdmin(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int deleteCount = 0;
		String admin_delete_sql = "delete from member where id=?";
		
		try {
			pstmt = conn.prepareStatement(admin_delete_sql);
			pstmt.setString(1, id);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("boardDelete 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
			if(rs != null) close(rs);
		}
		
		return deleteCount;
	}
}
