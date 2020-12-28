package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.TodayImageRemoveService;
import vo.ActionForward;

public class TodayImageRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] kindArray = request.getParameterValues("remove");
		TodayImageRemoveService todayImageRemoveService = new TodayImageRemoveService();
		todayImageRemoveService.todayRemove(request,kindArray);
		ActionForward forward = new ActionForward("todayImageList.do", true);
		return forward;
	}

}
