package pk.noz.actions.user;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pk.noz.db.management.ProductsManagement;
import pk.noz.db.model.ProductTO;

/**
 * Servlet implementation class create
 */
@WebServlet("/getProducts")
public class GetProducts extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
	@EJB
	private ProductsManagement products;
	
    public GetProducts() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	    response.setCharacterEncoding("UTF-8");
		
	    List<ProductTO> prodOutList = products.getAllProds();
	    
	    request.setAttribute("products", prodOutList);
	    request.getRequestDispatcher("products.jsp").forward(request, response);
	}

}
