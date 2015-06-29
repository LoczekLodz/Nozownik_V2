package pk.noz.db.management;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.google.common.collect.Iterables;

import pk.noz.db.model.User;
import pk.noz.db.model.UserAddress;
import pk.noz.db.model.UserAddressTO;
import pk.noz.db.model.UserTO;

@Stateless
public class UserManagement {
	
	@PersistenceContext(unitName = "noz")
	private EntityManager em;

	public void createUser(UserTO user) {
				
		User newUser = new User();
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setLogin(user.getLogin());
		newUser.setPassword(user.getPassword());
		
		if(null != user.getUserAddresses()) {
			for (UserAddressTO a : user.getUserAddresses()) {
				UserAddress address = new UserAddress();
				address.setDefaultAddress(a.getDefaultAddress());
				address.setCity(a.getCity());
				address.setStreet(a.getStreet());
				address.setLocaleNum(a.getLocaleNum());
				address.setPostCode(a.getPostCode());
				address.setParentUser(newUser);
				em.persist(address);
			}
		}
		
		em.persist(newUser); 
	}
	
	public boolean checkLogin(String login, String password) {
		Query q = em.createNamedQuery("findProfileByLogin");
	    q.setParameter("login", login);
		
	    @SuppressWarnings("unchecked")
		List<User> users = q.getResultList();
	    if (null != users && users.size() == 1) {
	    	User user = Iterables.getOnlyElement(users);
	    	if (null != user && password.equals(user.getPassword())) {
	    		return true;
	    	}
	    	return false;
	    }
		return false;
	}
}
