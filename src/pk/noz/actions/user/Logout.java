package pk.noz.actions.user;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pk.noz.db.management.UserManagement;

/**
 * Servlet implementation class create
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String indexUrl = "index.jsp";
    
	@EJB
	private UserManagement userManagment;
	
    public Logout() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	    response.setCharacterEncoding("UTF-8");
		
	    request.getSession().invalidate();
	    response.sendRedirect(indexUrl);
	}

}
