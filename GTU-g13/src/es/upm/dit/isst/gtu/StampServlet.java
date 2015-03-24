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

public class StampServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
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

		req.setAttribute("cards", new ArrayList<CardRequest>(ucr));
		req.setAttribute("accepted", new ArrayList<CardRequest>(acr));
		RequestDispatcher	view =	req.getRequestDispatcher("Stamp.jsp");
		view.forward(req,	resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

		String id = req.getParameter("id");
		String entity = "Stamp";
		String state = "Accept";
		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		dao.updateEntity(Long.parseLong(id), entity);
		dao.updateState(Long.parseLong(id), state);
		res.sendRedirect("/stamp");
		List<CardRequest> test = dao.listCardRequests();
		
		for(CardRequest cr : test){
			System.out.println(cr.getEntity());
		}

	}
	
}
