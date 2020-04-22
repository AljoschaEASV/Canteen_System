package CanteenSysDomain;

public class Manager extends User {

    private String managerName = "";
    private String managerAddress = "";
    private String managerContact = "";
    private String managerEmail = "";
    private int managerCardID = 0;
    private double managerBalance = 0;

    /**
     * @param name
     * @param address
     * @param contact
     * @param email
     * @param cardID
     * @param balance
     */
    public Manager(int name, int address, int contact, int email, int cardID, int balance) {
        super(name, address, contact, email, cardID, balance);
    }

    public String getManagerName() {
        return this.managerName;
    }

    /**
     * @param managerName
     */
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerAddress() {
        return this.managerAddress;
    }

    /**
     * @param managerAddress
     */
    public void setManagerAddress(String managerAddress) {
        this.managerAddress = managerAddress;
    }

    public String getManagerContact() {
        return this.managerContact;
    }

    /**
     * @param managerContact
     */
    public void setManagerContact(String managerContact) {
        this.managerContact = managerContact;
    }

    public String getManagerEmail() {
        return this.managerEmail;
    }

    /**
     * @param managerEmail
     */
    public void setManagerEmail(String managerEmail) {
        this.managerEmail = managerEmail;
    }

    public int getManagerCardID() {
        return this.managerCardID;
    }

    /**
     * @param managerCardID
     */
    public void setManagerCardID(int managerCardID) {
        this.managerCardID = managerCardID;
    }

    public double getManagerBalance() {
        return this.managerBalance;
    }

    /**
     * @param managerBalance
     */
    public void setManagerBalance(double managerBalance) {
        this.managerBalance = managerBalance;
    }

}