package CanteenSysView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;


public class Controller {

    @FXML
    private Pane pnl_warmLunch;

    @FXML
    private Pane pnl_fruit;

    @FXML
    private Pane pnl_drinks;

    @FXML
    private Pane pnl_checkout;

    @FXML
    private JFXButton btnCheckOut;

    @FXML
    private JFXButton btnDrinks;

    @FXML
    private JFXButton btnFruits;

    @FXML
    private JFXButton btnWarmLunch;

    @FXML
    private JFXListView<String> orderList;


//

    public void handleButtonAction(javafx.event.ActionEvent event) {
        {
            if (event.getSource() == btnWarmLunch) {
                pnl_warmLunch.toFront();
            } else if (event.getSource() == btnDrinks) {
                pnl_drinks.toFront();
            } else if (event.getSource() == btnFruits) {
                pnl_fruit.toFront();
            } else if (event.getSource() == btnCheckOut) {
                pnl_checkout.toFront();
            }


        }
    }

    public void addCategoryClicked(ActionEvent event)
    {

    }
    public void addProductClicked(ActionEvent event)
    {

    }
    public void viewSalesClicked(ActionEvent event)
    {

    }

    public void addItemToLBasket() {
    }


    public void deleteItemFromBasket() {
    }


    public void showCurrentStockAvailable() {
    }


    public void calculatePriceForItems() {
    }


    public void displayTrendCurve() {
    }

    public void pickAmountOfSelectedItem() {
    }

    public void displayTotalPrice() {
    }

    public void showLastPurchase() {
    }

    public void displayAllPurchases() {
    }


}




