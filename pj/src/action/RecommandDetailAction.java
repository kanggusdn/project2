package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RecommandDetailService;
import vo.ActionForward;
import vo.RecommandBean;

public class RecommandDetailAction implements Action { 

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			int recommand_num = Integer.parseInt(request.getParameter("recommand_num"));
			String page = request.getParameter("page");
			RecommandDetailService recommandDetailservice = new RecommandDetailService();
			RecommandBean article = recommandDetailservice.getArticle(recommand_num);
			ActionForward forward = new ActionForward();
			request.setAttribute("page", page);
			request.setAttribute("article", article);
			forward.setPath("/recommand/qna_recommand_view.jsp");
			return forward;
			
	}

}
