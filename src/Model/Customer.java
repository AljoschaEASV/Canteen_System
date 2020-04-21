package Model;

public class Customer extends User {

	private String cus_name = "";
	private String cus_address = "";
	private double cus_balance = 0;
	private int cus_cardID = 0;
	private String cus_contact = "";
	private String cus_email = "";

	/**
	 *
	 * @param name
	 * @param address
	 * @param contact
	 * @param email
	 * @param cardID
	 * @param balance
	 */
	public Customer(int name, int address, int contact, int email, int cardID, int balance) {
		super(name, address, contact, email, cardID, balance);
	}

	public String getCus_address() {
		return this.cus_address;
	}

	public double getCus_balance() {
		return this.cus_balance;
	}

	public int getCus_cardID() {
		return this.cus_cardID;
	}

	public String getCus_contact() {
		return this.cus_contact;
	}

	public String getCus_email() {
		return this.cus_email;
	}

	public String getCus_name() {
		return this.cus_name;
	}

	/**
	 * 
	 * @param emp_address
	 */
	public void setCus_address(String emp_address) {
		this.cus_address = emp_address;
	}

	/**
	 * 
	 * @param emp_balance
	 */
	public void setCus_balance(double emp_balance) {
		this.cus_balance = emp_balance;
	}

	/**
	 * 
	 * @param emp_cardID
	 */
	public void setCus_cardID(int emp_cardID) {
		this.cus_cardID = emp_cardID;
	}

	/**
	 * 
	 * @param emp_contact
	 */
	public void setCus_contact(String emp_contact) {
		this.cus_contact = emp_contact;
	}

	/**
	 * 
	 * @param emp_email
	 */
	public void setCus_email(String emp_email) {
		this.cus_email = emp_email;
	}

	/**
	 * 
	 * @param emp_name
	 */
	public void setCus_name(String emp_name) {
		this.cus_name = emp_name;
	}

}