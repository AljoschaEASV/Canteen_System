package Application;

import Application.DBwrapper;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.sql.SQLException;

//testchange
public class Controller {

    @FXML
    private Pane pnl_warmlunch, pnl_fruit, pnl_drinks, pnl_checkout;
    @FXML
    private JFXButton btnCheckOut, btnDrinks, btnFruits, btnWarmLunch;
    @FXML
    private JFXListView<?> orderList;
    @FXML
    private TableView tableviewItems;

    private ObservableList<ObservableList> itemsList = FXCollections.observableArrayList();

    @FXML
    private void initialize() throws SQLException {

        fillList("WarmLunch");

    }

    public void handleButtonAction(javafx.event.ActionEvent event) throws SQLException {
        {
            if (event.getSource() == btnWarmLunch) {
                tableviewItems.toFront();
                fillList("WarmLunch");
            } else if (event.getSource() == btnDrinks) {
                tableviewItems.toFront();
                fillList("Drink");
            } else if (event.getSource() == btnFruits) {
                tableviewItems.toFront();
                fillList("Fruit");
            } else if (event.getSource() == btnCheckOut) {
                pnl_checkout.toFront();
            }
        }
    }

    public void addCategoryClicked(ActionEvent event) {

    }

    public void addProductClicked(ActionEvent event) {

    }

    public void viewSalesClicked(ActionEvent event) {

    }

    /*
    public void addItemToBasket() {
        try {
//            tbData.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                @Override
//                public void handle(MouseEvent event) {
//                    if(event.getButton().equals(MouseButton.PRIMARY)) {
//                        if (event.getClickCount() == 2) {
//                            MediaFile selection = tbData.getSelectionModel().getSelectedItem();
//
//                            mainController.runSingleChoice(selection);
//                        }
//
//                    }
//                }
//            });
//        }catch (NullPointerException e)
//        {
//            e.getCause();
//        }
    }*/


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


    private void fillList(String itemCategory) throws SQLException {
        itemsList.clear();
        tableviewItems.getColumns().clear();
        tableviewItems.refresh();

        //filling warmlunch tableview
        DBwrapper.select("select ProductName, Price, GrammOrMl, ProductDescription, Amount from ItemsWithCategoryAndStock where CategoryName='" + itemCategory + "'");

        for (int i = 0; i < DBwrapper.getResultSet().getMetaData().getColumnCount(); i++) {
            //We are using non property style for making dynamic table
            final int j = i;
            TableColumn col = new TableColumn(DBwrapper.getResultSet().getMetaData().getColumnName(i + 1));
            col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

            tableviewItems.getColumns().addAll(col);
            System.out.println("Column [" + i + "] ");
        }

        while (DBwrapper.getResultSet().next()) {
            //Iterate Row
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <= DBwrapper.getResultSet().getMetaData().getColumnCount(); i++) {
                //Iterate Column
                row.add(DBwrapper.getResultSet().getString(i));
            }
            System.out.println("Row [1] added " + row);
            itemsList.add(row);
        }
        tableviewItems.setItems(itemsList);
    }

}




