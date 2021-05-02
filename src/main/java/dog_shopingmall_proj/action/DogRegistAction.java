package dog_shopingmall_proj.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dog_shopingmall_proj.dto.Dog;
import dog_shopingmall_proj.service.DogRegistService;

public class DogRegistAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=utf-8");
		
		
		
		String realFolder = "";
		String saveFolder = "/images";
		int maxSize = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = null;
		
		try {
			multi = new MultipartRequest(
					request, 
					realFolder, 
					maxSize, 
					"utf-8", 
					new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
		System.out.println("image >> " + multi.getOriginalFileName((String)multi.getFileNames().nextElement()));
		String image = multi.getOriginalFileName((String)multi.getFileNames().nextElement());
		
		Dog dog = new Dog(
				0, 
				multi.getParameter("kind"), 
				Integer.parseInt(multi.getParameter("price")),
				image,
				multi.getParameter("nation"),
				Integer.parseInt(multi.getParameter("height")),
				Integer.parseInt(multi.getParameter("weight")),
				multi.getParameter("content"),
				0
				);
		
		DogRegistService service = new DogRegistService();
		boolean isRegistSuccess = service.registDog(dog);
		
		ActionForward forward = null;
		
		if(isRegistSuccess) {
			forward = new ActionForward("dogList.do", true);
		} else {
			response.setContentType("text/html; charset=utf-8");
			try {
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('등록실패');");
				out.println("history.back();");
				out.println("</script>");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		return forward;
	}

}
