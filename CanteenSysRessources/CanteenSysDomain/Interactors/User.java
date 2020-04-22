package CanteenSysDomain.Interactors;

public abstract class User {

    private String name;
    private String adress;
    private String contact;
    private String email;
    private String cardID;
    private double balance;

    /**
     * @param name
     * @param address
     * @param contact
     * @param email
     * @param cardID
     * @param balance
     */
    public User(int name, int address, int contact, int email, int cardID, int balance) {
        // TODO - implement User.User
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return this.name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return this.adress;
    }

    /**
     * @param adress
     */
    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getContact() {
        return this.contact;
    }

    /**
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return this.email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCardID() {
        return this.cardID;
    }

    /**
     * @param cardID
     */
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public double getBalance() {
        return this.balance;
    }

    /**
     * @param balance
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

}