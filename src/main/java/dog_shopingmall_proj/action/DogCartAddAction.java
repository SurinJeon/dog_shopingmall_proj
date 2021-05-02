package dog_shopingmall_proj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shopingmall_proj.dto.Dog;
import dog_shopingmall_proj.service.DogCartAddService;

public class DogCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		DogCartAddService service = new DogCartAddService();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Dog cartDog = service.getCartDog(id);
		System.out.println("cartDog in add action>> " + cartDog);
		
		service.addCart(request, cartDog);
		
		ActionForward forward = new ActionForward("dogCartList.do", true);
		return forward;
	}

}
