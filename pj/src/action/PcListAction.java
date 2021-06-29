package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.PcListService;
import vo.ActionForward;
import vo.Goods;

public class PcListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = "SAMSUNG";
		if(request.getParameter("kind") != null) kind = request.getParameter("kind");
		ArrayList<Goods> pcs = PcListService.getPcList(kind);
		ArrayList<String> todayImageList = new ArrayList<String>();
		Cookie[] cookieArray = request.getCookies();

		if (cookieArray != null) {
			for (int i = 0; i < cookieArray.length; i++) {
				if (cookieArray[i].getName().startsWith("today")) {
					// startWith -> today로 시작하는게 있다면.
					todayImageList.add(cookieArray[i].getValue());
				}
			}
		}
		PcListService pcListService = new PcListService();
		ArrayList<Goods> pcList = pcListService.getPcList(kind);
		request.setAttribute("pcList", pcList);
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward("pcList.jsp", false);
		return forward;
	}
}
