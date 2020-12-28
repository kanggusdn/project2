package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Today;

public class TodayImageSearchService {

	public ArrayList<Today> getTodaySearchList(int startMoney, int endMoney, HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Today> oldtodayImageList = (ArrayList<Today>) session.getAttribute("todayImageList");
		ArrayList<Today> todayImageList = new ArrayList<Today>();

		for (int i = 0; i < oldtodayImageList.size(); i++) {
			if (oldtodayImageList.get(i).getPrice() >= startMoney && oldtodayImageList.get(i).getPrice() <= endMoney) {
				todayImageList.add(oldtodayImageList.get(i));
			}
		}
		return todayImageList;
	}

}
