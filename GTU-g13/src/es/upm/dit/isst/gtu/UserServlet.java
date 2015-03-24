package es.upm.dit.isst.gtu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.gtu.dao.CardRequestDAO;
import es.upm.dit.isst.gtu.dao.CardRequestDAOImpl;

public class UserServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		resp.setContentType("text/plain");
		RequestDispatcher	view =	req.getRequestDispatcher("User.jsp");
		view.forward(req,	resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		String user = req.getParameter("firstname");
		String entity = "User";
		String state = "Request";
		boolean mondero= req.getParameter("monedero")!=null;
		CardRequestDAO dao = CardRequestDAOImpl.getInstance();
		dao.add(entity, user, mondero, state);
		res.sendRedirect("/user");
	}

}
