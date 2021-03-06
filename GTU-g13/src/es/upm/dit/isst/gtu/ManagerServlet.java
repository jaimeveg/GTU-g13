package es.upm.dit.isst.gtu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.gtu.dao.CardRequestDAO;
import es.upm.dit.isst.gtu.dao.CardRequestDAOImpl;
import es.upm.dit.isst.gtu.dao.UsuarioDAO;
import es.upm.dit.isst.gtu.dao.UsuarioDAOImpl;
import es.upm.dit.isst.gtu.model.CardRequest;
import es.upm.dit.isst.gtu.model.Usuario;

public class ManagerServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UsuarioDAO userDAO = UsuarioDAOImpl.getInstance();
		CardRequestDAO cardRequestDAO = CardRequestDAOImpl.getInstance();
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		
		if(user==null || !user.getNickname().equals("gestor.gtu.isst")){
			Cookie err = new Cookie("error", "0");
			resp.addCookie(err);
			resp.sendRedirect("/error");
		}
		
		List<Usuario> usuarios = userDAO.listUsersByEntity("User");
		List<Usuario> universidades = userDAO.listUsersByEntity("University");
		List<Usuario> bancos = userDAO.listUsersByEntity("Bank");
		List<Usuario> estampadoras = userDAO.listUsersByEntity("Stamp");
		List<CardRequest> request = cardRequestDAO.listCardRequests();
		
		String url =	userService.createLogoutURL("/");
		
		req.getSession().setAttribute("url",	url);
		req.setAttribute("usuarios", new ArrayList<Usuario>(usuarios));
		req.setAttribute("universidades", new ArrayList<Usuario>(universidades));
		req.setAttribute("bancos", new ArrayList<Usuario>(bancos));
		req.setAttribute("estampadoras", new ArrayList<Usuario>(estampadoras));
		req.setAttribute("cards", new ArrayList<CardRequest>(request));
		RequestDispatcher	view =	req.getRequestDispatcher("Manager.jsp");
		view.forward(req,	resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		UsuarioDAO userDAO = UsuarioDAOImpl.getInstance();
		CardRequestDAO cardRequestDAO = CardRequestDAOImpl.getInstance();
		String id = req.getParameter("id");
		String cardId = req.getParameter("cardId");
		if(id != null){
			userDAO.remove(Long.parseLong(id));
		}else if(cardId != null){
			cardRequestDAO.remove(Long.parseLong(cardId));
		}
		
		res.sendRedirect("/admin");
		
	}
	
}
