package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeDetailService;
import vo.ActionForward;
import vo.NoticeBean;

public class NoticeDetailAction implements Action { 

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			int notice_num = Integer.parseInt(request.getParameter("notice_num"));
			String page = request.getParameter("page");
			NoticeDetailService noticeDetailservice = new NoticeDetailService();
			NoticeBean article = noticeDetailservice.getArticle(notice_num);
			ActionForward forward = new ActionForward();
			request.setAttribute("page", page);
			request.setAttribute("article", article);
			forward.setPath("/notice/qna_notice_view.jsp");
			return forward;
			
	}

}
