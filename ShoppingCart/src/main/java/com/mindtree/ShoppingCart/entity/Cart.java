/**
 * 
 */
package com.mindtree.ShoppingCart.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author M1056333
 *
 */
@Entity
public class Cart implements Comparable<Cart> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private double cartPrice;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
	private List<Product> productList;

	/**
	 * 
	 */
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cartId
	 * @param cartPrice
	 * @param productList
	 */
	public Cart(int cartId, double cartPrice, List<Product> productList) {
		super();
		this.cartId = cartId;
		this.cartPrice = cartPrice;
		this.productList = productList;
	}

	/**
	 * @return the cartId
	 */
	public int getCartId() {
		return cartId;
	}

	/**
	 * @param cartId
	 *            the cartId to set
	 */
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	/**
	 * @return the cartPrice
	 */
	public double getCartPrice() {
		return cartPrice;
	}

	/**
	 * @param cartPrice
	 *            the cartPrice to set
	 */
	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}

	/**
	 * @return the productList
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * @param productList
	 *            the productList to set
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		long temp;
		temp = Double.doubleToLongBits(cartPrice);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((productList == null) ? 0 : productList.hashCode());
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		if (Double.doubleToLongBits(cartPrice) != Double.doubleToLongBits(other.cartPrice))
			return false;
		if (productList == null) {
			if (other.productList != null)
				return false;
		} else if (!productList.equals(other.productList))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cart cart) {
		if (cartId > cart.getCartId()) {
			return 1;
		} else if (cartId < cart.getCartId()) {
			return -1;
		} else {
			return 0;
		}
	}

}
