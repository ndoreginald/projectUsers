package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.ModelUser;
import metier.User;
import metier.UserMetierImpl;
import metier.UserMetierInterface;

/**
 * Servlet implementation class UserSearch
 */
@WebServlet("/UserSearch")
public class UserSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Déclarer un objet "métier"
				UserMetierInterface metier =null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException {
		// instancier le métier
		metier =new UserMetierImpl();
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String motCle = request.getParameter("motCle");
		ModelUser mod = new ModelUser();
		mod.setMotCle(motCle);
		List<User> usr = (List<User>) metier.getUserByName(motCle);
		mod.setList(usr);	
		//Récupérer une session			
		HttpSession session =request.getSession(true);
		session.setAttribute("listOfUsers", mod);
		request.getRequestDispatcher("UserList.jsp").forward(request, response);
	}

}
