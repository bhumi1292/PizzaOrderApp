package de.bhumi.appUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/*
 * In class extends JFrame for showing user Interface.which helps to show history of Order.
 */
@SuppressWarnings("serial")
public class AdminOrderData extends JFrame {

	DefaultTableModel model;

	/**
	 * Create the frame.
	 */
	public AdminOrderData() {

		// Creating Window using JFrame
		JFrame frame = new JFrame();
		// frame.setTitle(title);
		frame.setSize(805, 570);

		// Adding Table View
		frame.getContentPane().add(getTablePanel());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private JPanel getTablePanel() {

		JPanel tableJPanel = new JPanel();

		tableJPanel.setLayout(new BorderLayout());

		// Column Header
		String[] columns = { "Id", "FoodFlavor", "Size", "Price", "AddOns", "Choose", "Quantity", "Total" };

		// Getting Data for Table from Database
		Object[][] data = getAllOrder();

		// Creating JTable object passing data and header
		JTable employeeTable = new JTable(data, columns);

		tableJPanel.add(employeeTable.getTableHeader(), BorderLayout.NORTH);
		tableJPanel.add(employeeTable, BorderLayout.CENTER);

		return tableJPanel;
	}

//method to get all the data from the Database.
	private Object[][] getAllOrder() {

		Object[][] data = null;

		final String CONNECTION_URL = "jdbc:mysql://localhost:3306/ShopDB";
		final String USERNAME = "root";
		final String PASSWORD = "";

		final String QUERY = "Select * from orderData";

		try (Connection connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);

				Statement statement = connection.createStatement();

				ResultSet rs = statement.executeQuery(QUERY);) {

			int rowCount = getRowCount(rs); // Row Count
			int columnCount = getColumnCount(rs); // Column Count

			data = new Object[rowCount][columnCount];

			// Starting from First Row for Iteration
			rs.beforeFirst();

			int i = 0;

			while (rs.next()) {

				int j = 0;

				data[i][j++] = rs.getInt("id");
				data[i][j++] = rs.getString("foodFlavor");
				data[i][j++] = rs.getString("size");
				data[i][j++] = rs.getDouble("price");
				data[i][j++] = rs.getString("addOns");
				data[i][j++] = rs.getString("choose");
				data[i][j++] = rs.getString("quantity");
				data[i][j++] = rs.getString("total");

				i++;
			}

			@SuppressWarnings("unused")
			boolean status = true;

			// Closing the Resources;
			// statement.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;
	}

// Method to get Row Count from ResultSet Object
	private int getRowCount(ResultSet rs) {

		try {

			if (rs != null) {

				rs.last();

				return rs.getRow();
			}

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}

// Method to get Column Count from ResultSet Object
	private int getColumnCount(ResultSet rs) {

		try {

			if (rs != null)
				return rs.getMetaData().getColumnCount();

		} catch (SQLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return 0;
	}
}
