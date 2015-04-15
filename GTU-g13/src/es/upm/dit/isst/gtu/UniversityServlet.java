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

public class UniversityServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UsuarioDAO userDAO = UsuarioDAOImpl.getInstance();
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		
		
		String entity = "";
		Usuario usuario = null ;

		if (user!=null && userDAO.getUsuarioByUserId(user.getNickname()) != null){
			usuario = userDAO.getUsuarioByUserId(user.getNickname());
			entity = usuario.getEntity();
 			
		}
		if(user == null || !entity.equals("University")){
			Cookie err = new Cookie("error", "0");
			resp.addCookie(err);
			resp.sendRedirect("/error");
		}
		
		String url = userService.createLogoutURL("/");

		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		
		List<CardRequest> ucr = new ArrayList<CardRequest>();
		List<CardRequest> uc = new ArrayList<CardRequest>();
		
		ucr = dao.listRequests("User", "Request");
		uc = listByUniversity(userDAO,usuario.getName(),ucr);
		
		List<CardRequest> acr = new ArrayList<CardRequest>();
		List<CardRequest> ac = new ArrayList<CardRequest>();
		acr = dao.listRequests("Stamp", "Accept");
		ac = listByUniversity(userDAO,usuario.getName(),acr);
		
		List<CardRequest> rcr = new ArrayList<CardRequest>();
		List<CardRequest> rc = new ArrayList<CardRequest>();
		rcr = dao.listRequests("Bank", "Rejected");
		rc = listByUniversity(userDAO,usuario.getName(),rcr);
		
		

		req.getSession().setAttribute("url",	url);
		req.setAttribute("cards", new ArrayList<CardRequest>(uc));
		req.setAttribute("accepted", new ArrayList<CardRequest>(ac));
		req.setAttribute("rejected", new ArrayList<CardRequest>(rc));
		RequestDispatcher	view =	req.getRequestDispatcher("University.jsp");
		view.forward(req,	resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		String action = req.getParameter("action");
		String id = req.getParameter("id");
		String entity = "University";
		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		dao.updateEntity(Long.parseLong(id), entity);
		System.out.println("LA ACCIÓN ES "+action);
		if (action.equals("Reject")) {
			System.out.println(id+" HA SIDO RECHAZADA");
			dao.updateState(Long.parseLong(id), "Rejected");
		} if (action.equals("Accept")) {
			dao.updateState(Long.parseLong(id), "Request");
		}
		//No es necesario actualizar el estado, sigue siendo peticion
		res.sendRedirect("/university");
		List<CardRequest> test = dao.listCardRequests();
		
		for(CardRequest cr : test){
			System.out.println(cr.getEntity());
		}

	}
	
	public List<CardRequest> listByUniversity(UsuarioDAO dao, String nombre,List <CardRequest> cr){
		System.out.println("Nombre: "+ nombre);
		List<CardRequest> rs= new ArrayList<CardRequest>();
		for(CardRequest c: cr){
			if(dao.getUsuarioByUserId(c.getUser())!=null){
				System.out.println("user encontrado");
				Usuario u = dao.getUsuarioByUserId(c.getUser());
				System.out.println("Universidad: "+ u.getUniversity());
				if(u.getUniversity().equals(nombre)){
					System.out.println("Igual fiesta!!");
					rs.add(c);
				}
				
			}
		}
		return rs;
		
	}

}
