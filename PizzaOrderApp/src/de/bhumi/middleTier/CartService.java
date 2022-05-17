package de.bhumi.middleTier;

import de.bhumi.Frontend.PizzaInfo;
import de.bhumi.backend.ShopDB;
/**
 * Service Implements to make connection between back end and front end.
 * @author bhumi
 *
 */
public class CartService {
	private ShopDB db;

	/**Constructor with database parameter
	 * @param db
	 */
	public CartService(ShopDB db) {
		this.db = db;
	}

	//Method connects the database and userInterface
	public void writedata(String foodFlavor, String size, double price, String addOns, String choose, int quantity,
			double total) {
		PizzaInfo newuser = new PizzaInfo(foodFlavor, size, price, addOns, choose, quantity, total);
		db.insertOrderInfo(newuser);

	}
}
