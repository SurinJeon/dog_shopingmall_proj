package dog_shopingmall_proj.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dog_shopingmall_proj.dto.Cart;

public class DogCartSearchService {

	public ArrayList<Cart> getCartSearchList(int start_money, int end_money, HttpServletRequest request) {

		HttpSession session = request.getSession();
		
		ArrayList<Cart> oldCartList = (ArrayList<Cart>) session.getAttribute("cartList");
		System.out.printf("oldCartList >> ");
		oldCartList.stream().forEach(System.out::println);
		
		ArrayList<Cart> cartList = new ArrayList<Cart>();

		for (int i = 0; i < oldCartList.size(); i++) {

			if (oldCartList.get(i).getPrice() >= start_money && oldCartList.get(i).getPrice() <= end_money) {
				cartList.add(oldCartList.get(i));
			}
		}

		return cartList;
	}
}
