package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RecommandModifyProService;
import vo.ActionForward;
import vo.RecommandBean;

public class RecommandModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		boolean isModifySuccess = false;
		int recommand_num = Integer.parseInt(request.getParameter("recommand_num"));
		RecommandBean article = new RecommandBean();
		RecommandModifyProService recommandModifyProService = new RecommandModifyProService();
		boolean isRightUser = recommandModifyProService.isArtcleWriter(recommand_num, request.getParameter("recommand_pass"));

		if (!isRightUser) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			request.setCharacterEncoding("UTF-8");
			out.println("<script>");
			out.println("alert('수정할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		} else {
			article.setRecommand_num(recommand_num);
			article.setRecommand_subject(request.getParameter("recommand_subject"));
			article.setRecommand_content(request.getParameter("recommand_content"));
			isModifySuccess = recommandModifyProService.modifyArticle(article);

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
				forward.setPath("recommandDetail.do?recommand_num=" + article.getRecommand_num() + "&page=" + request.getParameter("page"));
			}
		}
		return forward;
	}

}
