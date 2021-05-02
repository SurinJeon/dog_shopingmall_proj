package dog_shopingmall_proj.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shopingmall_proj.dto.Dog;
import dog_shopingmall_proj.service.DogViewService;

public class DogViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		DogViewService service = new DogViewService();
		
		int id = Integer.parseInt(request.getParameter("id"));
		Dog dog = service.getDogView(id);

		request.setAttribute("dog", dog);
		Cookie todayImageCookie = new Cookie("today" + id, dog.getImage());
		todayImageCookie.setMaxAge(60*60*24); // 하루동안만 쿠키에 살아있도록
		
		response.addCookie(todayImageCookie);
		
		ActionForward forward = new ActionForward("/dog_shopping/dogView.jsp");
		return forward;
	}

}
