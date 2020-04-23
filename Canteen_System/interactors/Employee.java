package interactors;

public class Employee extends User {

    private String empName = "";
    private String empAddress = "";
    private String empContact = "";
    private String empEmail = "";
    private int empCardID = 0;
    private double empBalance = 0;

    /**
     * @param name
     * @param address
     * @param contact
     * @param email
     * @param cardID
     * @param balance
     */
    public Employee(String name, String address, String contact, String email, String cardID, double balance) {
        super(name, address, contact, email, cardID, balance);
    }

    public String getEmpName() {
        return this.empName;
    }

    /**
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;

    }

    public String getEmpAddress() {

        return this.empAddress;
    }

    /**
     * @param empAddress
     */
    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;

    }

    public String getEmpContact() {
        return empContact;

    }

    /**
     * @param empContact
     */
    public void setEmpContact(String empContact) {
        this.empContact = empContact;

    }

    public String getEmpEmail() {
        return this.empEmail;
    }

    /**
     * @param empEmail
     */
    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;

    }

    public int getEmpCardID() {
        return this.empCardID;

    }

    /**
     * @param empCardID
     */
    public void setEmpCardID(int empCardID) {
        this.empCardID = empCardID;

    }

    public double getEmpBalance() {
        return this.empBalance;

    }

    /**
     * @param empBalance
     */
    public void setEmpBalance(double empBalance) {
        this.empBalance = empBalance;

    }

}