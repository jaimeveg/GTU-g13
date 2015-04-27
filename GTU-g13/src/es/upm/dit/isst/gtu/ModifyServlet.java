package es.upm.dit.isst.gtu;

import java.io.IOException;
import java.io.PrintWriter;
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

public class ModifyServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		UsuarioDAO userDAO = UsuarioDAOImpl.getInstance();
		CardRequestDAO carRequestDAO = CardRequestDAOImpl.getInstance();
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		Usuario usuario = null;
		boolean error = false;
		
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
		
		CardRequest cr = carRequestDAO.getCardRequestByUserId(user.getNickname());
		
		if(cr != null){
			error = true;
		}
		
		List<Usuario> uni = userDAO.listUsersByEntity("University");
		List<Usuario> bank = userDAO.listUsersByEntity("Bank");
		
		resp.setContentType("text/plain");
		req.getSession().setAttribute("error",	error);
		req.getSession().setAttribute("usuario", usuario);
		req.getSession().setAttribute("univs", new ArrayList<Usuario>(uni));
		req.getSession().setAttribute("banks", new ArrayList<Usuario>(bank));
		RequestDispatcher	view =	req.getRequestDispatcher("Modify.jsp");
		view.forward(req,	resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		UsuarioDAO usuarioDAO = UsuarioDAOImpl.getInstance();
		Usuario usuario = usuarioDAO.getUsuarioByUserId(user.getNickname());
		Long id = usuario.getId();
		
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String dni = req.getParameter("dni");
		String address = req.getParameter("address");
		String university = req.getParameter("university");
		String bank = req.getParameter("bank");
		
		if(bank.equals("") || university.equals("")){
			PrintWriter out = res.getWriter();  
			res.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Se deben rellenar los campos Universidad y Banco con uno de entre los disponibles.');");
			out.println("window.location.href='/modify'");
			out.println("</script>");
		}else{	
			usuarioDAO.updateUser(id, name, surname, dni, university, bank, address);
			res.sendRedirect("/user");
		}
	}

}
