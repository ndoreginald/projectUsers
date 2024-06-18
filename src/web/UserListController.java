package web;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.ModelUser;
import metier.TestMetier;
import metier.User;
import metier.UserMetierImpl;
import metier.UserMetierInterface;

/**
 * Servlet implementation class UserListController
 */
@WebServlet("/UserListController")
public class UserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Déclarer un objet "métier"
			UserMetierInterface metier =null;
			
			
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// instancier le métier
		metier =new UserMetierImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
				List<User> users = new ArrayList<User>();
				String mc = (String)request.getParameter("motCle");
				if(mc!=null && !mc.isEmpty()) {
					users = metier.getUserByName(mc);
				}
				else {
					users = metier.listUsers();
				}
				
				//Récupérer une session			
				HttpSession session =request.getSession(true);
				session.setAttribute("listOfUsers", users);
				request.getRequestDispatcher("UserList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	HttpSession session = request.getSession();
	User u = (User) session.getAttribute("user");
	if (u == null) {
		request.getRequestDispatcher("UserConnexion.jsp").forward(request, response);
	} 
	else {
		super.service(request, response);
	}
}

}
