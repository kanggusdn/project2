package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GoodsCartRemoveService;
import vo.ActionForward;

public class GoodsCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String[] kindArray = request.getParameterValues("remove");
		GoodsCartRemoveService goodsCartRemoveService = new GoodsCartRemoveService();
		goodsCartRemoveService.cartRemove(request,kindArray);
		ActionForward forward = new ActionForward("goodsCartList.do", true);
		return forward;
	}

}
