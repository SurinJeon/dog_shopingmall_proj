package dog_shopingmall_proj.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shopingmall_proj.dto.Cart;
import dog_shopingmall_proj.service.DogCartListService;

public class DogCartListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		DogCartListService service = new DogCartListService();
		
		ArrayList<Cart> cartList = service.getCartList(request);
		
		// 총 금액 계산
		int totalMoney = 0;
		int money = 0;
		
		for(int i = 0; i < cartList.size(); i++) {
			money = cartList.get(i).getPrice() * cartList.get(i).getQty(); // P * Q
			totalMoney += money; // 누적
		}
		
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("cartList", cartList);
		System.out.println("cartList >> " + cartList);
		ActionForward forward = new ActionForward("/dog_shopping/dogCartList.jsp", false);
		return forward;
	}

}
