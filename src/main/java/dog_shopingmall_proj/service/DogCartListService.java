package dog_shopingmall_proj.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dog_shopingmall_proj.dto.Cart;

public class DogCartListService {
	
	@SuppressWarnings("unchecked")
	public ArrayList<Cart> getCartList(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ArrayList<Cart> cartList = (ArrayList<Cart>) session.getAttribute("cartList");
		
		return cartList;
	}
}
