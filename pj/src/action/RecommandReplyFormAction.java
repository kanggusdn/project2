package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RecommandDetailService;
import vo.ActionForward;
import vo.RecommandBean;

public class RecommandReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String nowPage = request.getParameter("page");
		int recommand_num = Integer.parseInt(request.getParameter("recommand_num"));
		RecommandDetailService recommandDetailService = new RecommandDetailService();
		RecommandBean article = recommandDetailService.getArticle(recommand_num);
		request.setAttribute("article", article);
		request.setAttribute("page", nowPage);
		forward.setPath("/recommand/qna_recommand_reply.jsp");
		return forward;
	}
}

