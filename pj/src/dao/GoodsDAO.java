package dao;

import static db.JdbcUtil.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.Goods;

public class GoodsDAO {
	private static GoodsDAO boardDAO;
	private static Connection conn;
	private PreparedStatement pstmt;

	private GoodsDAO() {
	}
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	public static ArrayList<Goods> selectGoodsList(String kind) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Goods> goodsList = null;

		try {
			pstmt = conn.prepareStatement("select * from goods where kind = ?");
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				goodsList = new ArrayList<Goods>();
				// 객체를 생성하고

				do {
						goodsList.add(new Goods(rs.getInt("id"), rs.getString("kind"), rs.getString("name"),
								rs.getInt("price"), rs.getString("image"), rs.getString("modalip"),rs.getString("modalimage")));
					// 객체가 있다면 do를 해라
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(rs);
			close(pstmt);
		}
		return goodsList;
	}

	@SuppressWarnings("resource")
	public int insertGoods(Goods goods) {
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "";

		try {
			if(goods.getKind().equals("SAMSUNG") || goods.getKind().equals("HP") || goods.getKind().equals("LG") || goods.getKind().equals("LENOVO") || goods.getKind().equals("DELL") || goods.getKind().equals("ASUS")) {
				sql = "insert into pc values(null,?,?,?,?,?,?)";
			} else if(goods.getKind().equals("user") || goods.getKind().equals("CEO") || goods.getKind().equals("owner")) {
				sql = "insert into comu values(null,?,?,?,?,?,?)";
			} else {
				sql = "insert into goods values(null,?,?,?,?,?,?)";
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goods.getKind());
			pstmt.setString(2, goods.getName());
			pstmt.setInt(3, goods.getPrice());
			pstmt.setString(4, goods.getImage());
			pstmt.setString(5, goods.getModalip());
			pstmt.setString(6, goods.getModalimage());
			insertCount = pstmt.executeUpdate();
			if(insertCount != 0) {
				sql = "insert into samtb values(null,?,?,?,?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, goods.getKind());
				pstmt.setString(2, goods.getName());
				pstmt.setInt(3, goods.getPrice());
				pstmt.setString(4, goods.getImage());
				pstmt.setString(5, goods.getModalip());
				pstmt.setString(6, goods.getModalimage());
				pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return insertCount;
	}

	public int updateReadCount(int id) {
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "";

		try {
			sql = "update goods set readcount = readcount + 1 where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
		}
		return updateCount;
	}

	public Goods selectsamtb(int id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Goods goods = null;

		try {
			pstmt = conn.prepareStatement("select * from samtb where id =?");
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				goods = new Goods(rs.getInt("id"), rs.getString("kind"), rs.getString("name"), rs.getInt("price"),
						rs.getString("image"), rs.getString("modalip"),rs.getString("modalimage"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(pstmt);
			close(rs);
		}
		return goods;
	}
	
	public static ArrayList<Goods> selectpcList(String kind) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Goods> pcList = null;
		
		try {
			pstmt = conn.prepareStatement("select * from pc where kind = ?");
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				pcList = new ArrayList<Goods>();
				// 객체를 생성하고

				do {
					pcList.add(new Goods(rs.getInt("id"), rs.getString("kind"), rs.getString("name"),
								rs.getInt("price"), rs.getString("image"), rs.getString("modalip"),rs.getString("modalimage")));
					// 객체가 있다면 do를 해라
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(rs);
			close(pstmt);
		}
		return pcList;
	}
	public static ArrayList<Goods> selectComuList(String kind) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Goods> comuList = null;
		
		try {
			pstmt = conn.prepareStatement("select * from comu where kind = ?");
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				comuList = new ArrayList<Goods>();
				// 객체를 생성하고
				
				do {
					comuList.add(new Goods(rs.getInt("id"), rs.getString("kind"), rs.getString("name"),
							rs.getInt("price"), rs.getString("image"), rs.getString("modalip"),rs.getString("modalimage")));
					// 객체가 있다면 do를 해라
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			close(rs);
			close(pstmt);
		}
		return comuList;
	}



	public static GoodsDAO getInstance() {
			if (boardDAO == null) {
				boardDAO = new GoodsDAO();
			}
			return boardDAO;
	}
}
