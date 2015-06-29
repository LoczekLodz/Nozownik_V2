package pk.noz.db.management;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pk.noz.db.model.Product;
import pk.noz.db.model.ProductTO;

@Stateless
public class ProductsManagement {
	
	@PersistenceContext(unitName = "noz")
	private EntityManager em;

	public List<ProductTO> getAllProds() {
		Query q = em.createNamedQuery("findAllProds");
		
	    @SuppressWarnings("unchecked")
		List<Product> prodList = q.getResultList();
		
	    List<ProductTO> prodOutList = new ArrayList<ProductTO>();
	    for (Product prod : prodList) {
	    	prodOutList.add(new ProductTO(prod));
	    }
		return prodOutList;
	}
}
