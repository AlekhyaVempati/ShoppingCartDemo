package com.shopping.cart.model;

public class Items {

	private double itemPrice;
	private int splQuantity;
	private double splPrice;

	public Items(double itemPrice, int splQuantity, double splPrice) {
		super();
		this.itemPrice = itemPrice;
		this.splQuantity = splQuantity;
		this.splPrice = splPrice;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getSplQuantity() {
		return splQuantity;
	}

	public void setSplQuantity(int splQuantity) {
		this.splQuantity = splQuantity;
	}

	public double getSplPrice() {
		return splPrice;
	}

	public void setSplPrice(double splPrice) {
		this.splPrice = splPrice;
	}

	@Override
	public String toString() {
		return "Items [itemPrice=" + itemPrice + ", splQuantity=" + splQuantity + ", splPrice=" + splPrice + "]";
	}
}
