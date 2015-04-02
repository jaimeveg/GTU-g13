package es.upm.dit.isst.gtu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.gtu.dao.UsuarioDAO;
import es.upm.dit.isst.gtu.dao.UsuarioDAOImpl;
import es.upm.dit.isst.gtu.model.Usuario;

public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UsuarioDAO userDAO = UsuarioDAOImpl.getInstance();
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		String	url =	userService.createLoginURL("/register");
		
		String entity = "";
		if(user != null){
			String userId = user.getNickname();
			Usuario usuario = userDAO.getUsuarioByUserId(userId);
			if (usuario != null){
				entity = usuario.getEntity();
				entity = entity.toLowerCase();
			}else{
				System.out.println(user.getNickname());
				if(user.getNickname().equals("getsor.gtu.isst")){
					Cookie err = new Cookie("error", "1");
					resp.addCookie(err);
					resp.sendRedirect("/error");
					return;
				}else{
					resp.sendRedirect("/admin");
					return;
				}
			}
		}
		String	urlLogin =	userService.createLoginURL("/");
		req.getSession().setAttribute("url",	url);
		req.getSession().setAttribute("urlLogin",	urlLogin);
		if(user != null){
			resp.sendRedirect("/"+entity);
		}else{
			RequestDispatcher	view =	req.getRequestDispatcher("Main.jsp");
			view.forward(req,	resp);
		}
	}
	
}
