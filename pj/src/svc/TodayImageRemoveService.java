package svc;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import vo.Today;

public class TodayImageRemoveService {

	public void todayRemove(HttpServletRequest request, String[] kindArray) {
		HttpSession session = request.getSession();
		ArrayList<Today> todayImageList = (ArrayList<Today>)session.getAttribute("todayImageList");
		if(kindArray == null)return;
		for(int i = 0; i < kindArray.length;i++) {
			for(int j = 0; j < todayImageList.size();j++) {
				if(todayImageList.get(j).getKind().equals(kindArray[i])) {
					todayImageList.remove(todayImageList.get(j));
				}
			}
		}
	}

}
