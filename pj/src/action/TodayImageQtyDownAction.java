package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.TodayImageQtyDownService;
import vo.ActionForward;

public class TodayImageQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		TodayImageQtyDownService todayImageQtyDownService = new TodayImageQtyDownService();
		todayImageQtyDownService.downTodayQty(kind,request);
		ActionForward forward = new ActionForward("todayImageList.do",true);
		return forward;
	}

}
