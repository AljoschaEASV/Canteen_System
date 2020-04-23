package domain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import Application.DBwrapper;
import Application.DatabaseConnector;

import java.sql.ResultSet;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        preloader();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/OrderUI.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void preloader(){
        DatabaseConnector.createConnection();

        //testing sql query with view
        /*
        DBwrapper.select("select * from ItemsWithCategory where CategoryName='Fruit'");
        while(DBwrapper.getResultSet().next()){
            System.out.print("Name: " + DBwrapper.getResultSet().getString("ProductName") + " | ");
            System.out.print("Price: " + DBwrapper.getResultSet().getDouble("Price") + " | ");
            System.out.print("Gramm: " + DBwrapper.getResultSet().getInt("Gramm") + " | ");
            System.out.println("Category: " + DBwrapper.getResultSet().getString("CategoryName"));
        }
        */
    }
}
