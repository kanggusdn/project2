package action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.RecommandWriteProService;
import vo.ActionForward;
import vo.RecommandBean;

public class RecommandWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		RecommandBean recommandBean = null;
		String realFolder = "";
		String saveFolder = "/boardUpload";
		int fileSize = 5 * 1024 * 1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
//		String realFolder = "c:/boardUpload";
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
				new DefaultFileRenamePolicy());
		recommandBean = new RecommandBean();
		recommandBean.setRecommand_name(multi.getParameter("recommand_name"));
		recommandBean.setRecommand_pass(multi.getParameter("recommand_pass"));
		recommandBean.setRecommand_subject(multi.getParameter("recommand_subject"));
		recommandBean.setRecommand_content(multi.getParameter("recommand_content"));
		recommandBean.setRecommand_file(multi.getOriginalFileName((String) multi.getFileNames().nextElement()));
		RecommandWriteProService recommandWriteProService = new RecommandWriteProService();
		boolean isWriteSuccess = recommandWriteProService.registArticle(recommandBean);

		if (!isWriteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('등록실패');");
			out.println("history.back();");
			out.println("</script>");
			out.close();
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("recommandList.do");
		}
		return forward;
	}

}
