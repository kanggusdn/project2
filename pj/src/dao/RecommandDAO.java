package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.RecommandBean;

public class RecommandDAO {
	DataSource ds;
	Connection conn;
	private static RecommandDAO recommandDAO;
	
	private RecommandDAO() {
	}
	
	public static RecommandDAO getInstance() {
		if(recommandDAO == null) recommandDAO = new RecommandDAO();
		return recommandDAO;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select count(*) from recommand");
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
				
			}
		} catch (Exception e) {
			System.out.println("getListCount 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return listCount;
	}
	
	public ArrayList<RecommandBean> selectArticleList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String recommand_list_sql = "select * from recommand order by recommand_re_ref desc, recommand_re_seq asc limit ?, ?";
		ArrayList<RecommandBean> articleList = new ArrayList<RecommandBean>();
		RecommandBean recommand = null;
		int startRow = (page - 1) * 10;
		
		try {
			pstmt = conn.prepareStatement(recommand_list_sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				recommand = new RecommandBean();
				recommand.setRecommand_num(rs.getInt("recommand_num"));
				recommand.setRecommand_name(rs.getString("recommand_name"));
				recommand.setRecommand_subject(rs.getString("recommand_subject"));
				recommand.setRecommand_content(rs.getString("recommand_content"));
				recommand.setRecommand_file(rs.getString("recommand_file"));
				recommand.setRecommand_re_ref(rs.getInt("recommand_re_ref"));
				recommand.setRecommand_re_lev(rs.getInt("recommand_re_lev"));
				recommand.setRecommand_re_seq(rs.getInt("recommand_re_seq"));
				recommand.setRecommand_readcount(rs.getInt("recommand_readcount"));
				recommand.setRecommand_date(rs.getDate("recommand_date"));
				articleList.add(recommand);
			}
		} catch (Exception e) {
			System.out.println("getRecommandList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return articleList;
	}
	
	public RecommandBean selectArticle(int recommand_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RecommandBean recommandBean = null;
		
		try {
			pstmt = conn.prepareStatement("select * from recommand where recommand_num = ?");
			pstmt.setInt(1, recommand_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				recommandBean = new RecommandBean();
				recommandBean.setRecommand_num(rs.getInt("recommand_num"));
				recommandBean.setRecommand_name(rs.getString("recommand_name"));
				recommandBean.setRecommand_subject(rs.getString("recommand_subject"));
				recommandBean.setRecommand_content(rs.getString("recommand_content"));
				recommandBean.setRecommand_file(rs.getString("recommand_file"));
				recommandBean.setRecommand_re_ref(rs.getInt("recommand_re_ref"));
				recommandBean.setRecommand_re_lev(rs.getInt("recommand_re_lev"));
				recommandBean.setRecommand_re_seq(rs.getInt("recommand_re_seq"));
				recommandBean.setRecommand_readcount(rs.getInt("recommand_readcount"));
				recommandBean.setRecommand_date(rs.getDate("recommand_date"));
			}
		} catch (Exception e) {
			System.out.println("getDetail 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return recommandBean;
	}
	
	public int insertArticle(RecommandBean article) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;
		
		try {
			pstmt = conn.prepareStatement("select max(recommand_num) from recommand");
			rs = pstmt.executeQuery();
			
			if(rs.next()) num = rs.getInt(1) + 1;
			else num = 1;
			
			sql = "insert into recommand values (?,?,?,?,?,?,?,?,?,?,now())";
			if(rs != null) close(rs);
			if(pstmt != null) close(pstmt);

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  num);
			pstmt.setString(2, article.getRecommand_name());
			pstmt.setString(3, article.getRecommand_pass());
			pstmt.setString(4, article.getRecommand_subject());
			pstmt.setString(5, article.getRecommand_content());
			pstmt.setString(6, article.getRecommand_file());
			pstmt.setInt(7,  num);
			pstmt.setInt(8,  0);
			pstmt.setInt(9,  0);
			pstmt.setInt(10,  0);
			
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("recommandInsert 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}

	public int updateReadCount(int recommand_num) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update recommand set recommand_readcount = recommand_readcount + 1 where recommand_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, recommand_num);
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("setReadCountUpdate 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
		}
		
		return updateCount;
	}

	public int insertReplyArticle(RecommandBean article) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String recommand_max_sql = "select max(recommand_num) from recommand";
		String sql = "";
		int num = 0;
		int insertCount = 0;
		int re_ref = article.getRecommand_re_ref();
		int re_lev = article.getRecommand_re_lev();
		int re_seq = article.getRecommand_re_seq();
		
		try {
			pstmt = conn.prepareStatement(recommand_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next()) num = rs.getInt(1) + 1;
			else num = 1;
			if(rs != null) close(rs);
			if(pstmt != null) close(pstmt);

			sql = "update recommand set recommand_re_seq=recommand_re_seq+1 where recommand_re_ref=? and recommand_re_seq>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();
			
			if(updateCount > 0) commit(conn);
			re_seq = re_seq + 1;
			re_lev = re_lev + 1;
			sql = "insert into recommand values (?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getRecommand_name());
			pstmt.setString(3, article.getRecommand_pass());
			pstmt.setString(4, article.getRecommand_subject());
			pstmt.setString(5, article.getRecommand_content());
			pstmt.setString(6, article.getRecommand_file());
			pstmt.setInt(7,  re_ref);
			pstmt.setInt(8,  re_lev);
			pstmt.setInt(9,  re_seq);
			pstmt.setInt(10,  0);
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("recommandReply 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
			if(rs != null) close(rs);
			
		}
		
		return insertCount;
	}

	public boolean isArticleRecommandWriter(int recommand_num, String pass) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String recommand_sql = "select recommand_pass from recommand where recommand_num=?";
		boolean isWriter = false;
		
		try {
			pstmt = conn.prepareStatement(recommand_sql);
			pstmt.setInt(1, recommand_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(pass.equals(rs.getString("recommand_pass"))) {
					isWriter = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("isrecommandWriter 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
			if(rs != null) close(rs);
		}
		
		return isWriter;
	}

	public int updateArticle(RecommandBean article) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update recommand set recommand_subject=?, recommand_content=? where recommand_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getRecommand_subject());
			pstmt.setString(2, article.getRecommand_content());
			pstmt.setInt(3, article.getRecommand_num());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("recommandModify 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
		}
		
		return updateCount;
	}

	public int deleteArticle(int recommand_num) {
		PreparedStatement pstmt = null;
		String recommand_delete_sql = "delete from recommand where recommand_num=?";
		int deleteCount = 0;
		
		try {
			pstmt = conn.prepareStatement(recommand_delete_sql);
			pstmt.setInt(1, recommand_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("recommandDelete 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
		}
		
		return deleteCount;
	}
}
