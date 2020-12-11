package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeDetailService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String nowPage = request.getParameter("page");
		int notice_num = Integer.parseInt(request.getParameter("notice_num"));
		NoticeDetailService noticeDetailService = new NoticeDetailService();
		NoticeBean article = noticeDetailService.getArticle(notice_num);
		request.setAttribute("article", article);
		request.setAttribute("page", nowPage);
		forward.setPath("/notice/qna_notice_reply.jsp");
		return forward;
	}

}

