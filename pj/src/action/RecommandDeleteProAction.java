package action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RecommandDeleteProService;
import vo.ActionForward;

public class RecommandDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int recommand_num = Integer.parseInt(request.getParameter("recommand_num"));
		String nowPage = request.getParameter("page");
		RecommandDeleteProService recommandDeleteProService = new RecommandDeleteProService();
		boolean isArticleWriter = recommandDeleteProService.isArticleWriter(recommand_num, request.getParameter("recommand_pass"));

		if (!isArticleWriter) {
			response.setContentType("text/html;charset = UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제할 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {
			boolean isDeleteSuccess = recommandDeleteProService.removeArticle(recommand_num);

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
				forward.setPath("recommandList.do?page=" + nowPage);
			}
		}
		return forward;
	}

}
