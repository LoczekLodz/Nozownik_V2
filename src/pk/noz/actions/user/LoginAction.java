package pk.noz.actions.user;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pk.noz.db.management.UserManagement;

import com.google.common.base.Strings;

/**
 * Servlet implementation class create
 */
@WebServlet("/loginAction")
public class LoginAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String indexUrl = "index.jsp";
    
	@EJB
	private UserManagement userManagment;
	
    public LoginAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	    response.setCharacterEncoding("UTF-8");
		
	    HttpSession session = request.getSession();
	    session.setAttribute("checkLogin", (Boolean) true);
	    if (!Strings.isNullOrEmpty((String) request.getParameter("login"))
	    		&& !Strings.isNullOrEmpty((String) request.getParameter("password"))) {
	    
	    	if(userManagment.checkLogin((String) request.getParameter("login"), (String) request.getParameter("password"))) {
	    		session.setAttribute("login", (String) request.getParameter("login"));
	    		response.sendRedirect(indexUrl);
	    	} else {
	    		response.sendRedirect(indexUrl);
	    	}
	    } else {
	    	response.sendRedirect(indexUrl);
	    }
	}

}
