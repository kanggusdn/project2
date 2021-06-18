package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.LoginService;
import vo.ActionForward;
import vo.Member;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		LoginService loginservice = new LoginService();
		Member loginMember = loginservice.getLoginMember(id, passwd);
		// 로그인이 성공되면 Member 객체가 넘어오고 실패하면 null이 넘어옴.

		if (loginMember != null) {
			HttpSession session = request.getSession();
			forward = new ActionForward();
			session.setAttribute("loginMember", loginMember);
			forward.setPath("index.do");
			forward.setRedirect(true);

		} else {
			response.setContentType("text/html;charset = UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('로그인실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		return forward;
	}
}
