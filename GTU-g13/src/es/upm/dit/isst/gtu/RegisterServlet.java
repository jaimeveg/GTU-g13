package es.upm.dit.isst.gtu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.upm.dit.isst.gtu.dao.UsuarioDAO;
import es.upm.dit.isst.gtu.dao.UsuarioDAOImpl;
import es.upm.dit.isst.gtu.model.Usuario;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		UsuarioDAO userDAO = UsuarioDAOImpl.getInstance();
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		String userId = user.getNickname();
		Usuario usuario = userDAO.getUsuarioByUserId(userId);
		
		if(usuario != null){
			System.out.println("Ya existe un usuario registrado con este id");
			resp.sendRedirect("/");
		}
		
		List<Usuario> universities = userDAO.listUsersByEntity("University");
		List<Usuario> banks = userDAO.listUsersByEntity("Bank");
		
		req.getSession().setAttribute("banks", new ArrayList<Usuario>(banks));
		req.getSession().setAttribute("univs", new ArrayList<Usuario>(universities));
		req.getSession().setAttribute("user", user);
		RequestDispatcher	view =	req.getRequestDispatcher("Register.jsp");
		view.forward(req,	resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserService	userService =	UserServiceFactory.getUserService();
		User	user =	userService.getCurrentUser();
		UsuarioDAO userDAO = UsuarioDAOImpl.getInstance();
		String entity = req.getParameter("entity");
		String userId = user.getNickname();
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String dni = req.getParameter("dni");
		String address = req.getParameter("address");
		String university = req.getParameter("university");
		String bank = req.getParameter("bank");	
		String entityName = req.getParameter("entityName");
		String entityAb = req.getParameter("entityAb");
		if(entity.equals("User")){
			userDAO.add(entity, userId, name, surname, dni, university, bank, address);
		}else{
			userDAO.add(entity, userId, entityName, entityAb, "", "", "", "");
		}
		switch (entity) {
		case "User": 
			resp.sendRedirect("/user");
			break;
		case "University":
			resp.sendRedirect("/university");
			break;
		case "Bank":
			resp.sendRedirect("/bank");
			break;
		case "Stamp":
			resp.sendRedirect("/stamp");
			break;
		default:
			resp.sendRedirect("/");
			break;
		}
	}
		
}
