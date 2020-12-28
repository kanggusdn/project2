package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.TodayImageQtyUpService;
import vo.ActionForward;

public class TodayImageQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		TodayImageQtyUpService todayImageUpQtyService = new TodayImageQtyUpService();
		TodayImageQtyUpService.upTodayQty(kind,request);
		ActionForward forward = new ActionForward("todayImageList.do",true);
		return forward;
	}

}
