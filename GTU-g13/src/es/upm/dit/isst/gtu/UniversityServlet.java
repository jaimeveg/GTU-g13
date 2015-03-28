package es.upm.dit.isst.gtu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gtu.dao.CardRequestDAO;
import es.upm.dit.isst.gtu.dao.CardRequestDAOImpl;
import es.upm.dit.isst.gtu.model.CardRequest;

public class UniversityServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		List<CardRequest> ucr = new ArrayList<CardRequest>();
		ucr = dao.listRequests("User", "Request");
		
		for(CardRequest cr : ucr){
			System.out.println(cr.getUser());
		}
		
		List<CardRequest> acr = new ArrayList<CardRequest>();
		acr = dao.listRequests("Stamp", "Accept");
		
		List<CardRequest> rcr = new ArrayList<CardRequest>();
		rcr = dao.listRequests("Bank", "Rejected");

		req.setAttribute("cards", new ArrayList<CardRequest>(ucr));
		req.setAttribute("accepted", new ArrayList<CardRequest>(acr));
		req.setAttribute("rejected", new ArrayList<CardRequest>(rcr));
		RequestDispatcher	view =	req.getRequestDispatcher("University.jsp");
		view.forward(req,	resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		String action = req.getParameter("action");
		String id = req.getParameter("id");
		String entity = "University";
		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		dao.updateEntity(Long.parseLong(id), entity);
		System.out.println("LA ACCI�N ES "+action);
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

}
