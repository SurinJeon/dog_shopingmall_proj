package dog_shopingmall_proj.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dog_shopingmall_proj.service.DogCartRemoveService;

public class DogCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ActionForward forward = null;
		String[] kindArray = request.getParameterValues("remove");
		
		if(kindArray == null) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('삭제할 내역이 없습니다.');");
				out.println("history.back();");
				out.println("</script>");
				return forward;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		DogCartRemoveService service = new DogCartRemoveService();
		
		service.cartRemove(request, kindArray);
		
		forward = new ActionForward("dogCartList.do", true);
		return forward;
	}

}
