package CanteenSysView;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
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
    private JFXButton btn_checkOut;

    @FXML
    private JFXButton btn_drinks;

    @FXML
    private JFXButton btn_fruit;

    @FXML
    private JFXButton btn_warmLunch;

    @FXML
    private JFXListView<String> orderList;


//

    public void handleButtonAction(javafx.event.ActionEvent event) {
        {
            if (event.getSource() == btn_warmLunch) {
                pnl_warmLunch.toFront();
            } else if (event.getSource() == btn_drinks) {
                pnl_drinks.toFront();
            } else if (event.getSource() == btn_fruit) {
                pnl_fruit.toFront();
            } else if (event.getSource() == btn_checkOut) {
                pnl_checkout.toFront();
            }


        }
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




