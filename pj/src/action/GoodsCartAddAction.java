package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.GoodsCartAddService;
import vo.ActionForward;
import vo.Goods;

public class GoodsCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsCartAddService goodsCartAddService = new GoodsCartAddService();
		int id = Integer.parseInt(request.getParameter("id"));
		Goods cartGoods = goodsCartAddService.getCartGoods(id);
		goodsCartAddService.addCart(request,cartGoods);
		ActionForward forward = new ActionForward("goodsCartList.do",true);
		return forward;
	}
}
