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

public class BankServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		List<CardRequest> ucr = new ArrayList<CardRequest>();
		List<CardRequest> ucrm = new ArrayList<CardRequest>();
		List<CardRequest> ucrn = new ArrayList<CardRequest>();
		ucr = dao.listEntityRequests("University");
		
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
		
		List<CardRequest> acr = new ArrayList<CardRequest>();
		acr = dao.listEntityRequests("Stamp");

		req.setAttribute("cards", new ArrayList<CardRequest>(ucrn));
		req.setAttribute("cardsm", new ArrayList<CardRequest>(ucrm));
		req.setAttribute("accepted", new ArrayList<CardRequest>(acr));
		RequestDispatcher	view =	req.getRequestDispatcher("Bank.jsp");
		view.forward(req,	resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

		String id = req.getParameter("id");
		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		dao.update(Long.parseLong(id), "Bank");
		res.sendRedirect("/bank");
		List<CardRequest> test = dao.listCardRequests();
		
		for(CardRequest cr : test){
			System.out.println(cr.getEntity());
		}

	}

}
