/**
 * 
 */
package com.mindtree.ShoppingCart.entity;

import javax.persistence.Entity;

/**
 * @author M1056333
 *
 */
@Entity
public class Apparel extends Product {

	private String type;
	private String brand;
	private String design;

	/**
	 * 
	 */
	public Apparel() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param productId
	 * @param productName
	 * @param price
	 * @param quantity
	 * @param cart
	 */
	public Apparel(int productId, String productName, double price, int quantity, Cart cart) {
		super(productId, productName, price, quantity, cart);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param type
	 * @param brand
	 * @param design
	 */
	public Apparel(String type, String brand, String design) {
		super();
		this.type = type;
		this.brand = brand;
		this.design = design;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 *            the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the design
	 */
	public String getDesign() {
		return design;
	}

	/**
	 * @param design
	 *            the design to set
	 */
	public void setDesign(String design) {
		this.design = design;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + ((design == null) ? 0 : design.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apparel other = (Apparel) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (design == null) {
			if (other.design != null)
				return false;
		} else if (!design.equals(other.design))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
