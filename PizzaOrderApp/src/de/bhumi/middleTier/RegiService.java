package de.bhumi.middleTier;

import java.util.List;
import de.bhumi.Frontend.RegisterFrom;
import de.bhumi.backend.RegiDB;

/**
 * class has Method, constructor and attribute.
 * 
 * @author bhumi
 *
 */
public class RegiService {
	private RegiDB db;
	private List<RegisterFrom> alldata;

	/**
	 * @param db
	 */
	public RegiService(RegiDB db) {
		this.db = db;
		alldata = db.readTabel();

	}

	// Method sends true if the user name and password are matched.
	public boolean istAlreadyUser(String firstname, String password) {
		for (RegisterFrom reg : alldata) {
			if (reg.getFirstname().equals(firstname) && (reg.getPassword().equals(password))) {
				return true;
			}
		}

		return false;

	}

	// Method to insert data into the database by calling object reference.
	public void writeUser(String firstname, String lastname, String email, String password) {

		RegisterFrom newUser = new RegisterFrom(firstname, lastname, email, password);
		db.insertRegisterForm(newUser);

	}

}
