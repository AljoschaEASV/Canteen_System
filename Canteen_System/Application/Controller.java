package Application;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    @FXML
    private Pane pnl_checkout, pnlBarChart;
    @FXML
    private JFXButton btnCheckOut, btnDrinks, btnFruits, btnWarmLunch, btnBarChart;
    @FXML
    private TableView tableview_items, tableview_orderBasket;
    @FXML
    private LineChart<String, Integer> lineChart;
    @FXML
    private CategoryAxis x;
    @FXML
    private NumberAxis y;
    @FXML
    private Label lbl_total, lbl_output;
    @FXML
    private TextField txt_total, txt_id;
    @FXML
    private Button btn_pay;



    private ObservableList<ObservableList<String>> itemsList;
    private ObservableList<ObservableList<String>> basketList;

    @FXML
    private void initialize() throws SQLException {
        itemsList = FXCollections.observableArrayList();
        basketList = FXCollections.observableArrayList();

        fillList("WarmLunch");
    }

    @FXML
    void closeProgram() {
        System.exit(-1);
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
        pnlBarChart.toFront();
    }

    public void checkBalanceClicked(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();

        dialog.setTitle("Check Balance");
        dialog.setHeaderText("Please enter your ID");
        dialog.setContentText("ID:");

        dialog.showAndWait();

    }


    public void loadChart(ActionEvent event) throws SQLException {


        String productName = "SELECT ProductName From Items";
        String query = "Select * from InvoiceItemList Inner join Invoice on InvoiceItemList.InvoiceItemlistID = Invoice.InvoiceID";

        ResultSet product = DatabaseConnector.createConnection().createStatement().executeQuery(productName);
        ResultSet rs = DatabaseConnector.createConnection().createStatement().executeQuery(query);


        while (product.next()) {
            String nameVal = product.getString("ProductName");
            XYChart.Series<String, Integer> series = new XYChart.Series<>();
            series.setName(nameVal);

            while (rs.next()) {
                series.getData().add(new XYChart.Data<>(rs.getString(6), rs.getInt(3)));

            }
            lineChart.setAnimated(false);
            lineChart.getData().addAll(series);

        }
    }


    public void addItemToBasket() {
        try {
            tableview_items.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        if (event.getClickCount() == 2) {
                            if (tableview_orderBasket.getColumns().size() == 0) {
                                DBwrapper.select("select ProductName, Price from Items");
                                try {
                                    for (int i = 0; i < DBwrapper.getResultSet().getMetaData().getColumnCount(); i++) {
                                        final int j = i;
                                        TableColumn col = new TableColumn(DBwrapper.getResultSet().getMetaData().getColumnName(i + 1));
                                        col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
                                        tableview_orderBasket.getColumns().addAll(col);
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            }

                            ObservableList<String> row = FXCollections.observableArrayList();
                            row = (ObservableList<String>) tableview_items.getSelectionModel().getSelectedItem();
                            basketList.add(row);
                            tableview_orderBasket.setItems(basketList);

                            calculateTotal();
                        }

                    }
                }
            });
        } catch (NullPointerException e) {
            System.out.println("Error");
        }
    }

    public void deleteItemFromBasket() {
        try {
            tableview_orderBasket.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (event.getButton().equals(MouseButton.PRIMARY)) {
                        if (event.getClickCount() == 2) {
                            basketList.remove(tableview_orderBasket.getSelectionModel().getSelectedItem());
                            tableview_orderBasket.getSelectionModel().clearSelection();
                            tableview_orderBasket.setItems(basketList);

                            calculateTotal();
                        }
                    }
                }
            });
        } catch (NullPointerException e) {
            System.out.println("Error");
        }
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

        for (int i = 0; i < DBwrapper.getResultSet().getMetaData().getColumnCount(); i++) {
            final int j = i;
            TableColumn col = new TableColumn(DBwrapper.getResultSet().getMetaData().getColumnName(i + 1));
            col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));
            tableview_items.getColumns().addAll(col);
        }

        while (DBwrapper.getResultSet().next()) {
            ObservableList<String> row = FXCollections.observableArrayList();
            for (int i = 1; i <= DBwrapper.getResultSet().getMetaData().getColumnCount(); i++) {
                row.add(DBwrapper.getResultSet().getString(i));
            }
            itemsList.add(row);
        }
        tableview_items.setItems(itemsList);
    }

    private void calculateTotal(){
        Object itemtype;
        TableColumn prices = (TableColumn) tableview_orderBasket.getColumns().get(1);

        int rows = tableview_orderBasket.getItems().size();
        String value;

        float total=0;
        for(int i=0;i<rows;i++){
            itemtype = tableview_orderBasket.getItems().get(i);
            value = (String) prices.getCellObservableValue(itemtype).getValue();
            total += Float.parseFloat(value);
        }

        lbl_total.setText("Total: " + total);
        txt_total.setText(String.valueOf(total));
    }

    @FXML
    private void payOrder() throws SQLException {
        int id = Integer.parseInt(txt_id.getText());
        if(txt_total.getText()!=null) {
            float total = Float.parseFloat(txt_total.getText());
            DBwrapper.select("select * from Customer where EmployeeID=" + id);
            float balance = DBwrapper.getResultSet().getFloat("Balance");

            if(balance<total){
                lbl_output.setText("Not enough Balance");
            } else {
                DBwrapper.update("update Customer set Balance=" + (balance-total) + "where EmployeeID=" + id);
                lbl_output.setText("payment done!");
            }
        }
    }
}




