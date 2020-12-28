package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.TodayImageSearchService;
import vo.ActionForward;
import vo.Today;

public class TodayImageSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TodayImageSearchService todayImageSearchService = new TodayImageSearchService();
		int startMoney = 0;
		int endMoney = Integer.MAX_VALUE;
		try {

			startMoney = Integer.parseInt(request.getParameter("startMoney"));
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			endMoney = Integer.parseInt(request.getParameter("endMoney"));

		} catch (Exception e) {
			// TODO: handle exception
		}
		ArrayList<Today> todayImageList = todayImageSearchService.getTodaySearchList(startMoney, endMoney, request);
		request.setAttribute("todayImageList", todayImageList);
		request.setAttribute("startMoney", startMoney);
		request.setAttribute("endMoney", endMoney);
		int totalMoney = 0;
		int money = 0;

		for (int i = 0; i < todayImageList.size(); i++) {
			money = todayImageList.get(i).getPrice() * todayImageList.get(i).getQty();
			totalMoney += money;
		}
		request.setAttribute("totalMoney", totalMoney);
		ActionForward forward = new ActionForward("todayImageList.jsp", false);
		return forward;
	}

}
