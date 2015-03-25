package es.upm.dit.isst.gtu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		String	url =	userService.createLoginURL("/register");
		
		req.getSession().setAttribute("url",	url);
		RequestDispatcher	view =	req.getRequestDispatcher("Main.jsp");
		view.forward(req,	resp);
	}
	
}
