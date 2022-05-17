package de.bhumi.backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import de.bhumi.Frontend.RegisterFrom;

/**
 * Class demonstrate the query to inserting and viewing the data.
 * 
 * @author bhumi
 *
 */
public class RegiDB {

	private static final String URL = "jdbc:mysql://localhost:3306/shopDB?createDatabaseIfNotExist=true";

	private static final String USER = "root";
	private static final String PASSWORD = "";
	private List<RegisterFrom> alldata;

//Method creates to read all the data from database

	public List<RegisterFrom> readTabel() {
		alldata = new ArrayList<RegisterFrom>();
		String query = "SELECT * From login";
		try (Connection verbindung = DriverManager.getConnection(URL, USER, PASSWORD);
				Statement trnsport = verbindung.createStatement();
				ResultSet ans = trnsport.executeQuery(query);) {

			while (ans.next()) {
				int id = ans.getInt(1);

				String firstname = ans.getString(2);
				String lastname = ans.getString(3);
				String email = ans.getString(4);
				String password = ans.getString(5);

				RegisterFrom regi = new RegisterFrom(firstname, lastname, email, password);
				regi.setId(id);
				alldata.add(regi);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alldata;

	}

//Method creates to inserting the data into database
	public void insertRegisterForm(RegisterFrom regi) {
		String sqlMitPlatshalten = "INSERT INTO login VALUE(NULL,?,?,?,?)";
		try (Connection verbindung = DriverManager.getConnection(URL, USER, PASSWORD);
				PreparedStatement trnsport = verbindung.prepareStatement(sqlMitPlatshalten);) {
			trnsport.setString(1, regi.getFirstname());
			trnsport.setString(2, regi.getLastname());
			trnsport.setString(3, regi.getEmail());
			trnsport.setString(4, regi.getPassword());
			trnsport.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the alldata
	 */
	public List<RegisterFrom> getAlldata() {
		return alldata;
	}

	/**
	 * @param alldata the alldata to set
	 */
	public void setAlldata(List<RegisterFrom> alldata) {
		this.alldata = alldata;
	}
}
