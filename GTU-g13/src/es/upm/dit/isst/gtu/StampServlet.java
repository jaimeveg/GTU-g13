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

public class StampServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UsuarioDAO userDAO = UsuarioDAOImpl.getInstance();
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		
		String entity = "";
		if (user!=null && userDAO.getUsuarioByUserId(user.getNickname()) != null){
			Usuario usuario = userDAO.getUsuarioByUserId(user.getNickname());
			entity = usuario.getEntity();
		}
		if(user == null || !entity.equals("Stamp")){
			Cookie err = new Cookie("error", "0");
			resp.addCookie(err);
			resp.sendRedirect("/error");
		}
		String url =	userService.createLogoutURL("/");
		
		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		List<CardRequest> ucr = new ArrayList<CardRequest>();
		ucr = dao.listRequests("Bank", "Request");
		
		for(CardRequest cr : ucr){
			System.out.println(cr.getUser());
			System.out.println(cr.getEntity());
			System.out.println();
		}
		
		List<CardRequest> acr = new ArrayList<CardRequest>();
		acr = dao.listRequests("Stamp", "Accept");

		req.getSession().setAttribute("url",	url);
		req.setAttribute("cards", new ArrayList<CardRequest>(ucr));
		req.setAttribute("accepted", new ArrayList<CardRequest>(acr));
		RequestDispatcher	view =	req.getRequestDispatcher("Stamp.jsp");
		view.forward(req,	resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

		String action = req.getParameter("action");
		String id = req.getParameter("id");
		String entity = "Stamp";
		String state = "";
		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		dao.updateEntity(Long.parseLong(id), entity);
		if (action.equals("Accept")){
			state = "Accept";
		} else if (action.equals("Reject")){
			state = "Rejected";
		}
		dao.updateState(Long.parseLong(id), state);
		res.sendRedirect("/stamp");
		List<CardRequest> test = dao.listCardRequests();
		
		for(CardRequest cr : test){
			System.out.println(cr.getEntity());
		}

	}
	
}
