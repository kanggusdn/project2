package dao;

import static db.JdbcUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import vo.NoticeBean;

public class NoticeDAO {
	DataSource ds;
	Connection conn;
	private static NoticeDAO noticeDAO;
	
	private NoticeDAO() {
	}
	
	public static NoticeDAO getInstance() {
		if(noticeDAO == null) noticeDAO = new NoticeDAO();
		return noticeDAO;
	}
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public int selectListCount() {
		int listCount = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement("select count(*) from notice");
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
	
	public ArrayList<NoticeBean> selectArticleList(int page, int limit) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String notice_list_sql = "select * from notice order by notice_re_ref desc, notice_re_seq asc limit ?, ?";
		ArrayList<NoticeBean> articleList = new ArrayList<NoticeBean>();
		NoticeBean notice = null;
		int startRow = (page - 1) * 10;
		
		try {
			pstmt = conn.prepareStatement(notice_list_sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, limit);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				notice = new NoticeBean();
				notice.setNotice_num(rs.getInt("notice_num"));
				notice.setNotice_name(rs.getString("notice_name"));
				notice.setNotice_subject(rs.getString("notice_subject"));
				notice.setNotice_content(rs.getString("notice_content"));
				notice.setNotice_file(rs.getString("notice_file"));
				notice.setNotice_re_ref(rs.getInt("notice_re_ref"));
				notice.setNotice_re_lev(rs.getInt("notice_re_lev"));
				notice.setNotice_re_seq(rs.getInt("notice_re_seq"));
				notice.setNotice_readcount(rs.getInt("notice_readcount"));
				notice.setNotice_date(rs.getDate("notice_date"));
				articleList.add(notice);
			}
		} catch (Exception e) {
			System.out.println("getNoticeList 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return articleList;
	}
	
	public NoticeBean selectArticle(int notice_num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		NoticeBean noticeBean = null;
		
		try {
			pstmt = conn.prepareStatement("select * from notice where notice_num = ?");
			pstmt.setInt(1, notice_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				noticeBean = new NoticeBean();
				noticeBean.setNotice_num(rs.getInt("notice_num"));
				noticeBean.setNotice_name(rs.getString("notice_name"));
				noticeBean.setNotice_subject(rs.getString("notice_subject"));
				noticeBean.setNotice_content(rs.getString("notice_content"));
				noticeBean.setNotice_file(rs.getString("notice_file"));
				noticeBean.setNotice_re_ref(rs.getInt("notice_re_ref"));
				noticeBean.setNotice_re_lev(rs.getInt("notice_re_lev"));
				noticeBean.setNotice_re_seq(rs.getInt("notice_re_seq"));
				noticeBean.setNotice_readcount(rs.getInt("notice_readcount"));
				noticeBean.setNotice_date(rs.getDate("notice_date"));
			}
		}catch (Exception e) {
			System.out.println("getDetail 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return noticeBean;
	}
	
	public int insertArticle(NoticeBean article) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int num = 0;
		String sql = "";
		int insertCount = 0;
		
		try {
			pstmt = conn.prepareStatement("select max(notice_num) from notice");
			rs = pstmt.executeQuery();
			
			if(rs.next()) num = rs.getInt(1) + 1;
			else num = 1;
			
			sql = "insert into notice values (?,?,?,?,?,?,?,?,?,?,now())";
			if(rs != null) close(rs);
			if(pstmt != null) close(pstmt);

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  num);
			pstmt.setString(2, article.getNotice_name());
			pstmt.setString(3, article.getNotice_pass());
			pstmt.setString(4, article.getNotice_subject());
			pstmt.setString(5, article.getNotice_content());
			pstmt.setString(6, article.getNotice_file());
			pstmt.setInt(7,  num);
			pstmt.setInt(8,  0);
			pstmt.setInt(9,  0);
			pstmt.setInt(10,  0);
			
			insertCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("noticeInsert 에러: " + e);
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return insertCount;
	}

	public int updateReadCount(int notice_num) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "update notice set notice_readcount = notice_readcount + 1 where notice_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			updateCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("setReadCountUpdate 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
		}
		
		return updateCount;
	}

	public int insertReplyArticle(NoticeBean article) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String notice_max_sql = "select max(notice_num) from notice";
		String sql = "";
		int num = 0;
		int insertCount = 0;
		int re_ref = article.getNotice_re_ref();
		int re_lev = article.getNotice_re_lev();
		int re_seq = article.getNotice_re_seq();
		
		try {
			pstmt = conn.prepareStatement(notice_max_sql);
			rs = pstmt.executeQuery();
			if(rs.next()) num = rs.getInt(1) + 1;
			else num = 1;
			if(rs != null) close(rs);
			if(pstmt != null) close(pstmt);

			sql = "update notice set notice_re_seq=notice_re_seq+1 where notice_re_ref=? and notice_re_seq>?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, re_ref);
			pstmt.setInt(2, re_seq);
			int updateCount = pstmt.executeUpdate();
			
			if(updateCount > 0) commit(conn);
			re_seq = re_seq + 1;
			re_lev = re_lev + 1;
			sql = "insert into notice values (?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.setString(2, article.getNotice_name());
			pstmt.setString(3, article.getNotice_pass());
			pstmt.setString(4, article.getNotice_subject());
			pstmt.setString(5, article.getNotice_content());
			pstmt.setString(6, article.getNotice_file());
			pstmt.setInt(7,  re_ref);
			pstmt.setInt(8,  re_lev);
			pstmt.setInt(9,  re_seq);
			pstmt.setInt(10,  0);
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("noticeReply 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
		}
		
		return insertCount;
	}

	public boolean isArticleNoticeWriter(int notice_num, String pass) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String notice_sql = "select notice_pass from notice where notice_num=?";
		boolean isWriter = false;
		
		try {
			pstmt = conn.prepareStatement(notice_sql);
			pstmt.setInt(1, notice_num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(pass.equals(rs.getString("notice_pass"))) {
					isWriter = true;
				}
			}
		} catch (SQLException e) {
			System.out.println("isnoticeWriter 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
		}
		
		return isWriter;
	}

	public int updateArticle(NoticeBean article) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update notice set notice_subject=?, notice_content=? where notice_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, article.getNotice_subject());
			pstmt.setString(2, article.getNotice_content());
			pstmt.setInt(3, article.getNotice_num());
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("NoticeModify 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
		}
		
		return updateCount;
	}

	public int deleteArticle(int notice_num) {
		PreparedStatement pstmt = null;
		String notice_delete_sql = "delete from notice where notice_num=?";
		int deleteCount = 0;
		
		try {
			pstmt = conn.prepareStatement(notice_delete_sql);
			pstmt.setInt(1, notice_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("noticeDelete 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
		}
		
		return deleteCount;
	}
	
	public int addCountArticle(int selectArticle) {
		int updateCount = 0;
		PreparedStatement pstmt = null;
		String sql = "update notice set notice_readcount=notice_readcount+1 where notice_num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selectArticle);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("addCountArticle 에러: " + e);
		} finally {
			if(pstmt != null) close(pstmt);
		}
		
		return updateCount;
	}

}
