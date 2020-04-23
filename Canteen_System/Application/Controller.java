package Application;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.sql.SQLException;

public class Controller {

    @FXML
    private Pane pnl_checkout;
    @FXML
    private JFXButton btnCheckOut, btnDrinks, btnFruits, btnWarmLunch;
    @FXML
    private TableView tableview_items, tableview_orderBasket;
    @FXML
    private TableColumn orderColumnName, orderColumnPrice;

    private ObservableList<ObservableList<String>> itemsList;
    private ObservableList<ObservableList<String>> basketList;

    @FXML
    private void initialize() throws SQLException {
        itemsList = FXCollections.observableArrayList();
        basketList = FXCollections.observableArrayList();

        fillList("WarmLunch");
    }

    public void handleButtonAction(javafx.event.ActionEvent event) throws SQLException {
        {
            if (event.getSource() == btnWarmLunch) {
                tableview_items.toFront();
                fillList("WarmLunch");
            } else if (event.getSource() == btnDrinks) {
                tableview_items.toFront();
                fillList("Drink");
            } else if (event.getSource() == btnFruits) {
                tableview_items.toFront();
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

    public void addItemToBasket(MouseEvent event) {
        try {
            tableview_items.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if(event.getButton().equals(MouseButton.PRIMARY)) {
                        if (event.getClickCount() == 2) {
                            if(tableview_orderBasket.getItems().size()==0){
                                DBwrapper.select("select ProductName, Price from Items");
                                try {
                                    for(int i=0 ; i<DBwrapper.getResultSet().getMetaData().getColumnCount(); i++){
                                        final int j = i;
                                        TableColumn col = new TableColumn(DBwrapper.getResultSet().getMetaData().getColumnName(i+1));
                                        col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
                                        tableview_orderBasket.getColumns().addAll(col);
                                        System.out.println("Column ["+i+"] ");
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }

                            ObservableList<String> row = FXCollections.observableArrayList();
                            row = (ObservableList<String>) tableview_items.getSelectionModel().getSelectedItem();
                            basketList.add(row);
                            tableview_orderBasket.setItems(basketList);
                        }

                    }
                }
            });
        }catch (NullPointerException e)
        {
            System.out.println("Error");
        }
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

    private void fillList(String itemCategory) throws SQLException {
        itemsList.clear();
        tableview_items.getColumns().clear();
        tableview_items.refresh();

        DBwrapper.select("select ProductName, Price, GrammOrMl, ProductDescription, Amount from ItemsWithCategoryAndStock where CategoryName='" + itemCategory + "'");

        for(int i=0 ; i<DBwrapper.getResultSet().getMetaData().getColumnCount(); i++){
            final int j = i;
            TableColumn col = new TableColumn(DBwrapper.getResultSet().getMetaData().getColumnName(i+1));
            col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
            tableview_items.getColumns().addAll(col);
            System.out.println("Column ["+i+"] ");
        }

        while(DBwrapper.getResultSet().next()){
            ObservableList<String> row = FXCollections.observableArrayList();
            for(int i=1 ; i<=DBwrapper.getResultSet().getMetaData().getColumnCount(); i++){
                row.add(DBwrapper.getResultSet().getString(i));
            }
            System.out.println("Row added "+ row );
            itemsList.add(row);
        }
        tableview_items.setItems(itemsList);
    }

}




