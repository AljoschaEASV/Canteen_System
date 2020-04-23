package view;

import Application.DBwrapper;
import Application.DatabaseConnector;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class Controller {

    @FXML
    private Pane pnl_warmlunch, pnl_fruit, pnl_drinks, pnl_checkout;
    @FXML
    private JFXButton btnCheckOut, btnDrinks, btnFruits, btnWarmLunch;
    @FXML
    private JFXListView<?> orderList;
    @FXML
    private TableView tableview_warmlunch, tableview_fruit, tableview_drinks, tableview_orderBasket;

    private ObservableList<ObservableList> warmlunchList = FXCollections.observableArrayList();
    private ObservableList<ObservableList> fruitList = FXCollections.observableArrayList();
    private ObservableList<ObservableList> drinksList = FXCollections.observableArrayList();
    private ObservableList<ObservableList> basketList = FXCollections.observableArrayList();

    @FXML
    private void initialize() throws SQLException {

    fillWarmLunchList();
    fillFruitList();
    fillDrinksList();

    }

    public void handleButtonAction(javafx.event.ActionEvent event) {
        {
            if (event.getSource() == btnWarmLunch) {
                tableview_warmlunch.toFront();
            } else if (event.getSource() == btnDrinks) {
                tableview_drinks.toFront();
            } else if (event.getSource() == btnFruits) {
                tableview_fruit.toFront();
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


    private void fillWarmLunchList() throws SQLException {
        warmlunchList.clear();
        tableview_warmlunch.refresh();

        //filling warmlunch tableview
        DBwrapper.select("select ProductName, Price, GrammOrMl, ProductDescription from ItemsWithCategory where CategoryName='WarmLunch'");

        for(int i=0 ; i<DBwrapper.getResultSet().getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(DBwrapper.getResultSet().getMetaData().getColumnName(i+1));
            col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

            tableview_warmlunch.getColumns().addAll(col);
            System.out.println("Column ["+i+"] ");
        }

        while(DBwrapper.getResultSet().next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=DBwrapper.getResultSet().getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(DBwrapper.getResultSet().getString(i));
            }
            System.out.println("Row [1] added "+row );
            warmlunchList.add(row);
        }
        tableview_warmlunch.setItems(warmlunchList);
    }

    private void fillFruitList() throws SQLException {
        fruitList.clear();
        tableview_fruit.refresh();

        //filling fruitList tableview
        DBwrapper.select("select ProductName, Price, GrammOrMl, ProductDescription from ItemsWithCategory where CategoryName='Fruit'");

        for(int i=0 ; i<DBwrapper.getResultSet().getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(DBwrapper.getResultSet().getMetaData().getColumnName(i+1));
            col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

            tableview_fruit.getColumns().addAll(col);
            System.out.println("Column ["+i+"] ");
        }

        while(DBwrapper.getResultSet().next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=DBwrapper.getResultSet().getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(DBwrapper.getResultSet().getString(i));
            }
            System.out.println("Row [1] added "+row );
            fruitList.add(row);
        }
        tableview_fruit.setItems(fruitList);
    }

    private void fillDrinksList() throws SQLException {
        try {
            DBwrapper.getResultSet().close();
        } catch (SQLException e) {
            System.out.println("resultset musste nicht geloescht werden");
        }

        drinksList.clear();
        tableview_drinks.refresh();

        //filling fruitList tableview
        DBwrapper.select("select ProductName, Price, GrammOrMl, ProductDescription from ItemsWithCategory where CategoryName='Drink'");

        for(int i=0 ; i<DBwrapper.getResultSet().getMetaData().getColumnCount(); i++){
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(DBwrapper.getResultSet().getMetaData().getColumnName(i+1));
            col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

            tableview_drinks.getColumns().addAll(col);
            System.out.println("Column ["+i+"] ");
        }

        while(DBwrapper.getResultSet().next()){
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=DBwrapper.getResultSet().getMetaData().getColumnCount(); i++){
                //Iterate Column
                row.add(DBwrapper.getResultSet().getString(i));
            }
            System.out.println("Row [1] added "+row );
            drinksList.add(row);
        }
        tableview_drinks.setItems(drinksList);
    }

}




