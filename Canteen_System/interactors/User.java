package interactors;

public abstract class User {

    private String name;
    private String address;
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
    public User(String name, String address, String contact, String email, String cardID, double balance) {
      this.name = name;
      this.address = address;
      this.contact = contact;
      this.email = email;
      this.cardID = cardID;
      this.balance = balance;
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
        return this.address;
    }

    /**
     * @param adress
     */
    public void setAdress(String adress) {
        this.address = adress;
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