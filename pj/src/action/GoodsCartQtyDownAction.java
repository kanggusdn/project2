package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GoodsCartQtyDownService;
import vo.ActionForward;

public class GoodsCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		GoodsCartQtyDownService goodsCartQtyDownService = new GoodsCartQtyDownService();
		goodsCartQtyDownService.downCartQty(kind,request);
		ActionForward forward = new ActionForward("goodsCartList.do",true);
		return forward;
	}

}
