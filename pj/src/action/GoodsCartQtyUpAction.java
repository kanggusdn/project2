package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GoodsCartQtyUpService;
import vo.ActionForward;

public class GoodsCartQtyUpAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String kind = request.getParameter("kind");
		GoodsCartQtyUpService goodsCartUpQtyService = new GoodsCartQtyUpService();
		GoodsCartQtyUpService.upCartQty(kind,request);
		ActionForward forward = new ActionForward("goodsCartList.do",true);
		return forward;
	}
}
