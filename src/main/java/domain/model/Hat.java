package domain.model;

import domain.Product;


public class Hat extends Product {

	public Hat(String code, String name, float price) {
	super(code, name, price);
	}

	@Override
	public String getCode() {
		return super.getCode();
	}

	@Override
	public void setCode(String code) {
		super.setCode(code);
	}

	@Override
	public String getName() {
		return super.getName();
	}

	@Override
	public void setName(String name) {
		super.setName(name);
	}

	@Override
	public float getPrice() {
		return super.getPrice();
	}

	@Override
	public void setPrice(float price) {
		super.setPrice(price);
	}

	@Override
	public String toString() {
		return   "ProductCode: " + getCode() + "  " + "Name: " + getName() + "  " + "Price: " + getPrice() + "\n" ;
	}
}