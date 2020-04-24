package domain;

import Application.DatabaseConnector;

/**
 * Sort of though as the Database Handler - From where our stock basicly comes from.
 */
public class Stock {

    DatabaseConnector DBC;
    private int productID;
    private int quantity;

    public void addToStock() {
        DBC.createConnection();
    }

    /**
     * @param productID
     */
    public void modifyStock(int productID) {

    }

    public void selectItemFromStock() {

    }

}