package pk.noz.db.model;

import java.io.Serializable;

public class ProductImageTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6628479074893859293L;

	private long id;
	
	private String location;
	
	private ProductTO parentProd;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public ProductTO getParentProd() {
		return parentProd;
	}

	public void setParentProd(ProductTO parentProd) {
		this.parentProd = parentProd;
	}
	
	public ProductImageTO(ProductImage copyFrom) {
		this.id = copyFrom.getId();
		this.location = copyFrom.getLocation();
	}

}
