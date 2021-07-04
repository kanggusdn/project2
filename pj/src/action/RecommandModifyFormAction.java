package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RecommandDetailService;
import vo.ActionForward;
import vo.RecommandBean;

public class RecommandModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int recommand_num = Integer.parseInt(request.getParameter("recommand_num"));
		RecommandDetailService recommandDetailService = new RecommandDetailService();
		RecommandBean article = recommandDetailService.getArticle(recommand_num);
		request.setAttribute("article", article);
		forward.setPath("/recommand/qna_recommand_modify.jsp");
		return forward;
	}
}
