package action;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.ComuListService;
import vo.ActionForward;
import vo.Goods;

public class ComuListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = "user";
		if(request.getParameter("kind") != null) kind = request.getParameter("kind");
		ArrayList<Goods> comus = ComuListService.getComuList(kind);
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
		ComuListService comuListService = new ComuListService();
		ArrayList<Goods> comuList = comuListService.getComuList(kind);
		request.setAttribute("comuList", comuList);
		request.setAttribute("todayImageList", todayImageList);
		ActionForward forward = new ActionForward("comuList.jsp", false);
		return forward;
	}

}
