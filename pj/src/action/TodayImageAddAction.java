package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.TodayImageAddService;
import vo.ActionForward;
import vo.Goods;

public class TodayImageAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TodayImageAddService todayImageAddService = new TodayImageAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Goods todayGoods = todayImageAddService.getTodayGoods(id);
		todayImageAddService.addImage(request,todayGoods);
		ActionForward forward = new ActionForward("todayImageList.do",true);
		return forward;
	}

}
