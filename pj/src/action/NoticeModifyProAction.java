package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeModifyProService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean isModifySuccess = false;
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		String notice_subject = (String)request.getParameter("notice_subject2");
		String notice_content = (String)request.getParameter("notice_content2");
		NoticeBean article = new NoticeBean();
		NoticeModifyProService noticeModifyProService = new NoticeModifyProService();
		article.setNotice_subject(notice_subject);
		article.setNotice_content(notice_content);
		article.setNotice_num(notice_num);
		isModifySuccess = noticeModifyProService.modifyArticle(article);

			if (!isModifySuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('수정실패');");
				out.println("history.back();");
				out.println("</script>");
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("index.do");
			}
		return forward;
	}

}
