package view;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    private Pane pnl_warmlunch, pnl_fruit, pnl_drinks, pnl_checkout;
    @FXML
    private JFXButton btnCheckOut, btnDrinks, btnFruits, btnWarmLunch;
    @FXML
    private JFXListView<?> orderList;
    @FXML
    private TableView tableview_warmlunch;

    @FXML
    private void initialize(){

    }

    public void handleButtonAction(javafx.event.ActionEvent event) {
        {
            if (event.getSource() == btnWarmLunch) {
                pnl_warmlunch.toFront();
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




