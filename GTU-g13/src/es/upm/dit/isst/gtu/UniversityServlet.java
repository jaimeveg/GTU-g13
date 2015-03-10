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
		ucr = dao.listUserRequests();
		
		for(CardRequest cr : ucr){
			System.out.println(cr.getUser());
		}

		req.setAttribute("cards", new ArrayList<CardRequest>(ucr));
		RequestDispatcher	view =	req.getRequestDispatcher("University.jsp");
		view.forward(req,	resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{

		String id = req.getParameter("id");
		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		dao.remove(Long.parseLong(id));
		res.sendRedirect("/university");

	}

}
