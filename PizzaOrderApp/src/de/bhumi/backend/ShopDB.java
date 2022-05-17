package de.bhumi.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.bhumi.Frontend.PizzaInfo;
/**
 * class demonstrate methods for inserting and reading the order.
 * @author bhumi
 *
 */
public class ShopDB {
	private static final String url = "jdbc:mysql://localhost:3306/shopDB?createDatabaseIfNotExist=true";
	private static final String root = "root";
	private static final String password = "";

	// MEthod creates to insert Order records in the database
	public void insertOrderInfo(PizzaInfo allinfo) {
		String query = "INSERT INTO orderData VALUE(NULL,?,?,?,?,?,?,?)";
		try (Connection verbindung = DriverManager.getConnection(url, root, password);
				PreparedStatement trnsport = verbindung.prepareStatement(query);) {
			trnsport.setString(1, allinfo.getFoodFlavor());
			trnsport.setString(2, allinfo.getSize());
			trnsport.setDouble(3, allinfo.getPrice());
			trnsport.setString(4, allinfo.getAddOns());
			trnsport.setString(5, allinfo.getChoose());
			trnsport.setInt(6, allinfo.getQuantity());
			trnsport.setDouble(7, allinfo.getTotal());
			trnsport.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Method creates to view order records from the MySQL database.
	public List<PizzaInfo> viewOrderInfo() {
		List<PizzaInfo> allOrder = new ArrayList<PizzaInfo>();
		String query = "SELECT * FROM orderData";
		try (Connection con = DriverManager.getConnection(url, root, password);
				Statement trnasport = con.createStatement();
				ResultSet antwort = trnasport.executeQuery(query);) {
			while (antwort.next()) {
				int id = antwort.getInt(1);
				String foodFlavor = antwort.getString(2);
				String size = antwort.getString(3);
				double price = antwort.getDouble(4);
				String addOns = antwort.getString(5);
				String choose = antwort.getString(6);
				int quantity = antwort.getInt(7);
				double total = antwort.getDouble(8);
				PizzaInfo info = new PizzaInfo(foodFlavor, size, price, addOns, choose, quantity, total);
				info.setId(id);
				allOrder.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allOrder;
	}

}
