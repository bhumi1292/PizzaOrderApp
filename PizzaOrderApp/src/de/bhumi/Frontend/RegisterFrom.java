package de.bhumi.Frontend;

import java.util.Objects;


/**
 * class creates for attribute,constructor, getter and setter,with hash code and equals method
 * @author bhumi
 *
 */
public class RegisterFrom {
	private long id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	
	
	/**
	 * @return the primaryKey
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param password
	 */
	
	/**
	 * @param primaryKey the primaryKey to set
	 */
	public void setId(long id) {
		if(this.id != 0) {
			throw new IdAlreayHaveException(this.id);
		}
		this.id = id;
	}
	/**
	 * @param firstname
	 * @param lastname
	 * @param email
	 * @param password
	 * @param total
	 */
	public RegisterFrom(String firstname, String lastname, String email, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	


	@Override
	public String toString() {
		return "RegisterFrom [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", total=" + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, id, lastname, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RegisterFrom)) {
			return false;
		}
		RegisterFrom other = (RegisterFrom) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname) && Objects.equals(password, other.password);
	}
	

}
