package pk.noz.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2614159638497148915L;

	private long id;

	private String status;

	private boolean availability;

	private String name;
	
	private String description;

	private BigDecimal price;
	
	private Set<ProductImageTO> productImages;
	
	private Set<ProductDiscountTO> productDiscount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Set<ProductImageTO> getProductImages() {
		return productImages;
	}

	public void setProductImages(Set<ProductImageTO> productImages) {
		this.productImages = productImages;
	}

	public Set<ProductDiscountTO> getProductDiscount() {
		return productDiscount;
	}

	public void setProductDiscount(Set<ProductDiscountTO> productDiscount) {
		this.productDiscount = productDiscount;
	}
	
	public ProductTO(Product copyFrom) {
		this.id = copyFrom.getId();
		this.status = copyFrom.getStatus();
		this.availability = copyFrom.isAvailability();
		this.description = copyFrom.getDescription();
		this.name = copyFrom.getName();
		this.price = copyFrom.getPrice();
		
		Set<ProductImageTO> imagesList = new HashSet<ProductImageTO>();
		for (ProductImage image : copyFrom.getProductImages()) {
			ProductImageTO tmpPodImage = new ProductImageTO(image);
			tmpPodImage.setParentProd(this);
			imagesList.add(tmpPodImage);
		}
		this.productImages = imagesList;
		
		Set<ProductDiscountTO> discountList = new HashSet<ProductDiscountTO>();
		for (ProductDiscount discount : copyFrom.getProductDiscount()) {
			ProductDiscountTO tmpProdDisc = new ProductDiscountTO(discount);
			tmpProdDisc.setParentProd(this);
			discountList.add(tmpProdDisc);
		}
		this.productDiscount = discountList;	
	}
	
}
