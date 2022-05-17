package de.bhumi.Frontend;

import java.util.Objects;

/**
 * class creates Fronted with attributes, getter,setter,constructor
 * 
 * @author bhumi
 *
 */
public class PizzaInfo {
	private int id;
	private String foodFlavor;
	private String size;
	private double price;
	private String addOns;
	private String choose;
	private int quantity;
	private double total;

	/**
	 *
	 * @param foodFlavor
	 * @param size
	 * @param price
	 * @param addOns
	 * @param choose
	 * @param quantity
	 */
	public PizzaInfo(String foodFlavor, String size, double price, String addOns, String choose, int quantity,
			double total) {
		this.foodFlavor = foodFlavor;
		this.size = size;
		this.price = price;
		this.addOns = addOns;
		this.choose = choose;
		this.quantity = quantity;
		this.total = total;
	}

	/**
	 * @return the foodFlavor
	 */
	public String getFoodFlavor() {
		return foodFlavor;
	}

	/**
	 * @param foodFlavor the foodFlavor to set
	 */
	public void setFoodFlavor(String foodFlavor) {
		this.foodFlavor = foodFlavor;
	}

	/**
	 * @return the size
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the addOns
	 */
	public String getAddOns() {
		return addOns;
	}

	/**
	 * @param addOns the addOns to set
	 */
	public void setAddOns(String addOns) {
		this.addOns = addOns;
	}

	/**
	 * @return the choose
	 */
	public String getChoose() {
		return choose;
	}

	/**
	 * @param choose the choose to set
	 */
	public void setChoose(String choose) {
		this.choose = choose;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 */
	public PizzaInfo() {
	}

	@Override
	public int hashCode() {
		return Objects.hash(size, addOns, choose, foodFlavor, id, price, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof PizzaInfo)) {
			return false;
		}
		PizzaInfo other = (PizzaInfo) obj;
		return Objects.equals(size, other.size) && Objects.equals(addOns, other.addOns)
				&& Objects.equals(choose, other.choose) && Objects.equals(foodFlavor, other.foodFlavor)
				&& id == other.id && Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& quantity == other.quantity;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "PizzaInfo [id=" + id + ", foodFlavor=" + foodFlavor + ", size=" + size + ", price=" + price
				+ ", addOns=" + addOns + ", choose=" + choose + ", quantity=" + quantity + ", total=" + total + "]";
	}

}
