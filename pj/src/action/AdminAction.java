package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.AdminService;
import vo.ActionForward;
import vo.Member;

public class AdminAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Member> adminList = new ArrayList<Member>();
		AdminService adminListService = new AdminService();
		adminList = adminListService.getAdminList();
		request.setAttribute("adminList", adminList);
		ActionForward forward = new ActionForward();
		forward.setPath("admin.jsp");
		return forward;
	}

}
