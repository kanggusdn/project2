package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.TodayImageListService;
import vo.ActionForward;
import vo.Today;

public class TodayImageListAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TodayImageListService todayImageListService = new TodayImageListService();
		ArrayList<Today> todayImageList = todayImageListService.gettodayList(request);

		// 총금액 계산
		int totalMoney = 0;
		int money = 0;
		
		if(todayImageList != null) {
			for (int i = 0; i < todayImageList.size(); i++) {
				money = todayImageList.get(i).getPrice();
				totalMoney += money;
			}
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward("todayImageList.jsp", false);
		return forward;
	}

}
