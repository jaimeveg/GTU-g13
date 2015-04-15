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

import es.upm.dit.isst.gtu.dao.CardRequestDAO;
import es.upm.dit.isst.gtu.dao.CardRequestDAOImpl;
import es.upm.dit.isst.gtu.dao.UsuarioDAO;
import es.upm.dit.isst.gtu.dao.UsuarioDAOImpl;
import es.upm.dit.isst.gtu.model.CardRequest;
import es.upm.dit.isst.gtu.model.Usuario;

public class ConsultaServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UsuarioDAO userDAO = UsuarioDAOImpl.getInstance();
		CardRequestDAO cardRequestDAO = CardRequestDAOImpl.getInstance();
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		Usuario usuario = null;
		
		String entity = "";
		if (user!=null && userDAO.getUsuarioByUserId(user.getNickname()) != null){
			usuario = userDAO.getUsuarioByUserId(user.getNickname());
			entity = usuario.getEntity();
		}
		if(user == null || !entity.equals("User")){
			Cookie err = new Cookie("error", "0");
			resp.addCookie(err);
			resp.sendRedirect("/error");
		}
		
		CardRequest cr = cardRequestDAO.getCardRequestByUserId(user.getNickname());
		
		resp.setContentType("text/plain");
		req.getSession().setAttribute("card",	cr);
		req.getSession().setAttribute("usuario", usuario);
		RequestDispatcher	view =	req.getRequestDispatcher("Consulta.jsp");
		view.forward(req,	resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		CardRequestDAO cardRequestDAO = CardRequestDAOImpl.getInstance();
		String id = req.getParameter("id");
		
		cardRequestDAO.updateState(Long.parseLong(id), "Delete");
		
		res.sendRedirect("/user");
		
	}
	
}
