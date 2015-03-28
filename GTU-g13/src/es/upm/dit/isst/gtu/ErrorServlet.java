package es.upm.dit.isst.gtu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class ErrorServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		Cookie[] cookies = req.getCookies();
		String code = "";
		for (int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("error")){
				code = cookies[i].getValue();
			}
		}
		System.out.println(code);
		UserService	userService =	UserServiceFactory.getUserService();
		
		String msg = "";
		String url = "";
		switch (code) {
		case "0":
			msg = "Acceso denegado";
			url = "/";
			break;
		case "1":
			msg = "Usuario no encontrado, por favor registrese y vuelva a intentarlo";
			url = userService.createLogoutURL("/");
			break;
		default:
			msg = "Error no tratado";
			url = "/";
			break;
		}
		
		req.setAttribute("msg", msg);
		req.setAttribute("url", url);
		RequestDispatcher	view =	req.getRequestDispatcher("error.jsp");
		view.forward(req,	resp);
		
	}
}
