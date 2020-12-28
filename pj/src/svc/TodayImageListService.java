package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Today;


public class TodayImageListService {

	public ArrayList<Today> gettodayList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Today> todayImageList = (ArrayList<Today>)session.getAttribute("todayImageList");
		
		return todayImageList;
	}

}
