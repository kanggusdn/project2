package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeDeleteProService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int notice_num = Integer.parseInt(request.getParameter("notice_num2"));
		String notice_pass = (String)request.getParameter("notice_pass2");
//		String nowPage = request.getParameter("page");
//		NoticeBean article = new NoticeBean();
		NoticeDeleteProService noticeDeleteProService = new NoticeDeleteProService();
//		article.setNotice_content(notice_pass);
//		article.setNotice_num(notice_num);
		boolean isArticleWriter = noticeDeleteProService.isArticleWriter(notice_num, notice_pass);

		if (!isArticleWriter) {
			response.setContentType("text/html;charset = UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {
			noticeDeleteProService.removeArticle(notice_num);
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("index.do");
		}
		return forward;
	}

}
