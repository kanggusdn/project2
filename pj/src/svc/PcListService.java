package svc;
import static db.JdbcUtil.close;
import static db.JdbcUtil.commit;
import static db.JdbcUtil.getConnection;
import static db.JdbcUtil.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import dao.GoodsDAO;
import vo.Goods;

public class PcListService {

	public static ArrayList<Goods> getPcList(String kind) {
			
			GoodsDAO pcDAO = GoodsDAO.getInstance();
			Connection conn = getConnection();
			pcDAO.setConnection(conn);
			ArrayList<Goods> pcList = GoodsDAO.selectpcList(kind);
			if(pcList != null) {
				commit(conn);
			} else {
				rollback(conn);
			}
			ArrayList<Goods> pcs = GoodsDAO.selectpcList(kind);
			close(conn);
		return pcList;
	}

}
