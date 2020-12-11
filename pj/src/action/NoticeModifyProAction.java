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
		NoticeBean article = new NoticeBean();
		NoticeModifyProService noticeModifyProService = new NoticeModifyProService();
		boolean isRightUser = noticeModifyProService.isArtcleWriter(notice_num, request.getParameter("notice_pass"));

		if (!isRightUser) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			article.setNotice_num(notice_num);
			article.setNotice_subject(request.getParameter("notice_subject"));
			article.setNotice_content(request.getParameter("notice_content"));
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
				forward.setPath("noticeDetail.do?notice_num=" + article.getNotice_num() + "&page=" + request.getParameter("page"));
			}
		}
		return forward;
	}

}
