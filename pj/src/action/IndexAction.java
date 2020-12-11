package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.NoticeListService;
import vo.ActionForward;
import vo.NoticeBean;
import vo.PageInfo;

public class IndexAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<NoticeBean> articleList = new ArrayList<NoticeBean>();
		int page = 1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		NoticeListService noticeListService = new NoticeListService();
		int listCount = noticeListService.getListCount();
		articleList = noticeListService.getArticleList(page, limit);
		int maxPage = (int)((double)listCount/limit + 0.95);
		int startPage = (((int)((double)page / 10 + 0.9)) -1) * 10 + 1;
		int endPage = startPage +10-1;
		
		if(endPage > maxPage) endPage = maxPage;
		
		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("articleList", articleList);
		ActionForward forward = new ActionForward();
		forward.setPath("/index.jsp");
		return forward;
	}

}
