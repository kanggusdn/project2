package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeReplyProService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String nowPage = request.getParameter("page");
		NoticeBean article = new NoticeBean();
		article.setNotice_num(Integer.parseInt(request.getParameter("notice_num")));
		article.setNotice_name(request.getParameter("notice_name"));
		article.setNotice_pass(request.getParameter("notice_pass"));
		article.setNotice_subject(request.getParameter("notice_subject"));
		article.setNotice_content(request.getParameter("notice_content"));
		article.setNotice_re_ref(Integer.parseInt(request.getParameter("notice_re_ref")));
		article.setNotice_re_lev(Integer.parseInt(request.getParameter("notice_re_lev")));
		article.setNotice_re_seq(Integer.parseInt(request.getParameter("notice_re_seq")));
		NoticeReplyProService noticeReplyProService = new NoticeReplyProService();
		boolean isReplySuccess = noticeReplyProService.replyArticle(article);

		if (isReplySuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("noticeList.do?page=" + nowPage);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답장실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		}
		return forward;
	}

}
