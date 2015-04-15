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

public class BankServlet extends HttpServlet {
		
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		UsuarioDAO userDAO = UsuarioDAOImpl.getInstance();
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		Usuario usuario = null;
		
		String entity = "";
		if (user!=null && userDAO.getUsuarioByUserId(user.getNickname()) != null){
			 usuario = userDAO.getUsuarioByUserId(user.getNickname());
			entity = usuario.getEntity();
		}
		if(user == null || !entity.equals("Bank")){
			Cookie err = new Cookie("error", "0");
			resp.addCookie(err);
			resp.sendRedirect("/error");
		}
		
		String url =	userService.createLogoutURL("/");
		
		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		List<CardRequest> ucr = new ArrayList<CardRequest>();
		List<CardRequest> ucrm = new ArrayList<CardRequest>();
		List<CardRequest> ucrn = new ArrayList<CardRequest>();
		List<CardRequest> ucm = new ArrayList<CardRequest>();
		List<CardRequest> ucn = new ArrayList<CardRequest>();
		
		ucr = dao.listRequests("University", "Request");
		
		for(CardRequest cr : ucr){
			System.out.println(cr.getUser());
			System.out.println(cr.getEntity());
			if(cr.getMonedero() ){
				System.out.println("Solicita tarjeta monedero");
				ucrm.add(cr);
				}
				
			
			else{
				System.out.println("No solicita tarjeta monedero");
				
					ucrn.add(cr);
				
			}
		}
		ucm = listByBank(userDAO,usuario.getName(),ucrm);
		ucn = listByBank(userDAO,usuario.getName(),ucrn);
		
		
		List<CardRequest> rcr = new ArrayList<CardRequest>();
		List<CardRequest> rc = new ArrayList<CardRequest>();
		rcr = dao.listRequests("Stamp", "Rejected");
		rc = listByBank(userDAO,usuario.getName(),rcr);
		
		
		List<CardRequest> acr = new ArrayList<CardRequest>();
		List<CardRequest> ac = new ArrayList<CardRequest>();
		acr = dao.listRequests("Stamp", "Accept");
		ac = listByBank(userDAO,usuario.getSurname(),acr);

		resp.setContentType("text/plain");
		req.getSession().setAttribute("url",	url);
		req.setAttribute("cards", new ArrayList<CardRequest>(ucn));
		req.setAttribute("cardsm", new ArrayList<CardRequest>(ucm));
		req.setAttribute("accepted", new ArrayList<CardRequest>(ac));
		req.setAttribute("rejected", new ArrayList<CardRequest>(rc ));

		RequestDispatcher	view =	req.getRequestDispatcher("Bank.jsp");
		view.forward(req,	resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

		String action = req.getParameter("action");

		String id = req.getParameter("id");
		String entity = "Bank";
		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		dao.updateEntity(Long.parseLong(id), entity);
		//Si es un rechazo, se actualiza el estado
		System.out.println("LA ACCIÓN ES "+action);
		if (action.equals("Reject")) {
			System.out.println("HA SIDO RECHAZADA "+id);
			dao.updateState(Long.parseLong(id), "Rejected");
		} if (action.equals("Accept")) {
			dao.updateState(Long.parseLong(id), "Request");
		}
		res.sendRedirect("/bank");
		List<CardRequest> test = dao.listCardRequests();
		
		for(CardRequest cr : test){
			System.out.println(cr.getEntity());
		}

	}
	
	public List<CardRequest> listByBank(UsuarioDAO dao, String nombre,List <CardRequest> cr){
		List<CardRequest> rs= new ArrayList<CardRequest>();
		for(CardRequest c: cr){
			if(dao.getUsuarioByUserId(c.getUser())!=null){
				Usuario u = dao.getUsuarioByUserId(c.getUser());
				if(u.getBank().equals(nombre)){
					rs.add(c);
				}
				
			}
		}
		return rs;
		
	}

}

