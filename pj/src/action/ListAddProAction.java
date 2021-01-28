package action;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import svc.BoardWriteProService;
import svc.ListAddProService;
import vo.ActionForward;
import vo.BoardBean;
import vo.Goods;

public class ListAddProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		Goods ListAdd = null;
		String realFolder = "";
		String saveFolder = "/boardUpload";
		int fileSize = 10 * 1024 * 1024;
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
//		String realFolder = "C:\\Users\\yn-19\\git\\Project01\\pj\\WebContent\\img";
		MultipartRequest multi1 = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
				new DefaultFileRenamePolicy());
		ListAdd = new Goods();
		ListAdd.setKind(multi1.getParameter("kind"));
		ListAdd.setName(multi1.getParameter("name"));
		ListAdd.setPrice(Integer.parseInt(multi1.getParameter("price")));
		Enumeration<?> fileNames = multi1.getFileNames();
		String temp1 = (String) fileNames.nextElement();
		String temp2 = (String) fileNames.nextElement();
		System.out.println("temp1: " + temp1);
		ListAdd.setImage(multi1.getOriginalFileName(temp2));
		ListAdd.setModalip(multi1.getParameter("name"));
		System.out.println("temp2: " + temp2);
		ListAdd.setModalimage(multi1.getOriginalFileName(temp1));
		ListAddProService listAddProService = new ListAddProService();
		boolean isWriteSuccess = listAddProService.registArticle(ListAdd);

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
			forward.setPath("index.jsp");
		}
		return forward;
	}
}
