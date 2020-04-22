package CanteenSysDomain;

import CanteenSysApplication.DatabaseConnector;

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
        // TODO - implement Stock.modifyStock
        throw new UnsupportedOperationException();
    }

    public void selectItemFromStock() {
        // TODO - implement Stock.selectItemFromStock
        throw new UnsupportedOperationException();
    }

}