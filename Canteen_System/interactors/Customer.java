package interactors;

public class Customer extends User {

    private String customerName = "";
    private String customerAddress = "";
    private double customerBalance = 0;
    private int customerCardID = 0;
    private String customerContact = "";
    private String customerEmail = "";

    /**
     * @param name
     * @param address
     * @param contact
     * @param email
     * @param cardID
     * @param balance
     */
    public Customer(String name, String address, String contact, String email, String cardID, int balance) {
        super(name, address, contact, email, cardID, balance);
    }

    public String getcustomerAddress() {
        return this.customerAddress;
    }

    /**
     * @param employeeAddress
     */
    public void setcustomerAddress(String employeeAddress) {


        this.customerAddress = employeeAddress;
    }

    public double getcustomerBalance() {

        return this.customerBalance;
    }

    /**
     * @param employeeBalance
     */
    public void setcustomerBalance(double employeeBalance) {

        this.customerBalance = employeeBalance;
    }

    public int getcustomerCardID() {
        return this.customerCardID;
    }

    /**
     * @param employeeCardID
     */
    public void setcustomerCardID(int employeeCardID) {

        this.customerCardID = employeeCardID;
    }

    public String getcustomerContact() {
        return this.customerContact;
    }

    /**
     * @param employeeContact
     */
    public void setcustomerContact(String employeeContact) {

        this.customerContact = employeeContact;
    }

    public String getcustomerEmail() {

        return this.customerEmail;
    }

    /**
     * @param employeeEmail
     */
    public void setcustomerEmail(String employeeEmail) {
        this.customerEmail = employeeEmail;
    }

    public String getcustomerName() {

        return this.customerName;
    }

    /**
     * @param employeeName
     */
    public void setcustomerName(String employeeName) {
        this.customerName = employeeName;
    }

}