package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeDeleteProService;
import vo.ActionForward;

public class NoticeDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		String nowPage = request.getParameter("page");
		NoticeDeleteProService noticeDeleteProService = new NoticeDeleteProService();
		boolean isArticleWriter = noticeDeleteProService.isArticleWriter(notice_num, request.getParameter("notice_pass"));

		if (!isArticleWriter) {
			response.setContentType("text/html;charset = UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {
			boolean isDeleteSuccess = noticeDeleteProService.removeArticle(notice_num);

			if (!isDeleteSuccess) {
				response.setContentType("text/html;charset = UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제실패');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
			} else {
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("noticeList.do?page=" + nowPage);
			}
		}
		return forward;
	}

}
