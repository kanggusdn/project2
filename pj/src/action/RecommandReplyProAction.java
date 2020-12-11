package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RecommandReplyProService;
import vo.ActionForward;
import vo.RecommandBean;

public class RecommandReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		String nowPage = request.getParameter("page");
		RecommandBean article = new RecommandBean();
		article.setRecommand_num(Integer.parseInt(request.getParameter("recommand_num")));
		article.setRecommand_name(request.getParameter("recommand_name"));
		article.setRecommand_pass(request.getParameter("recommand_pass"));
		article.setRecommand_subject(request.getParameter("recommand_subject"));
		article.setRecommand_content(request.getParameter("recommand_content"));
		article.setRecommand_re_ref(Integer.parseInt(request.getParameter("recommand_re_ref")));
		article.setRecommand_re_lev(Integer.parseInt(request.getParameter("recommand_re_lev")));
		article.setRecommand_re_seq(Integer.parseInt(request.getParameter("recommand_re_seq")));
		RecommandReplyProService recommandReplyProService = new RecommandReplyProService();
		boolean isReplySuccess = recommandReplyProService.replyArticle(article);

		if (isReplySuccess) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("recommandList.do?page=" + nowPage);
		} else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답장실패');");
			out.println("history.back();");
			out.println("</script>");
		}

		return forward;
	}

}
