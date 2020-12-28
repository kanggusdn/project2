package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Today;

public class TodayImageQtyDownService {

	public void downTodayQty(String kind, HttpServletRequest request) {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		ArrayList<Today> todayImageList = (ArrayList<Today>)session.getAttribute("todayImageList");
		
		for(int i = 0; i <todayImageList.size();i++) {
			if(todayImageList.get(i).getKind().equals(kind)) {
				todayImageList.get(i).setQty(todayImageList.get(i).getQty()-1);
			}
		}
	}

}
