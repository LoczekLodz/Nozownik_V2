package pk.noz.actions.user;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.common.base.Strings;

import pk.noz.db.management.UserManagement;
import pk.noz.db.model.UserAddressTO;
import pk.noz.db.model.UserTO;

/**
 * Servlet implementation class create
 */
@WebServlet("/register")
public class Register extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	@EJB
	private UserManagement userManagment;
	
    public Register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	    response.setCharacterEncoding("UTF-8");
		
	    if (!Strings.isNullOrEmpty((String) request.getParameter("name"))
	    		&& !Strings.isNullOrEmpty((String) request.getParameter("surname"))
	    		&& !Strings.isNullOrEmpty((String) request.getParameter("login"))
	    		&& !Strings.isNullOrEmpty((String) request.getParameter("city"))
	    		&& !Strings.isNullOrEmpty((String) request.getParameter("address"))) {

	    	UserTO newUser = new UserTO();
			newUser.setFirstName((String) request.getParameter("name"));
			newUser.setLastName((String) request.getParameter("surname"));
			newUser.setLogin((String) request.getParameter("login"));
			newUser.setPassword((String) request.getParameter("password"));
			
			Set<UserAddressTO> userAddressesList = new HashSet<UserAddressTO>(1);
			
			UserAddressTO address= new UserAddressTO();
			address.setParentUser(newUser);
			address.setCity((String) request.getParameter("city"));
			address.setPostCode((String) request.getParameter("zip_code"));
			address.setStreet((String) request.getParameter("address"));
			address.setLocaleNum((String) request.getParameter("loc_number"));
			address.setDefaultAddress(true);
			userAddressesList.add(address);
			
			newUser.setUserAddresses(userAddressesList);
			userManagment.createUser(newUser);
	    }
	    
	    HttpSession session = request.getSession();
	    session.setAttribute("registerred", (Boolean) true);
	    
		response.sendRedirect("index.jsp");
	}

}
