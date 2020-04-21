package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import Controller.Connector;

import java.sql.Connection;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("/View/OrderUI.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        } catch (Exception e)
    {
    e.printStackTrace();
    }


    }

    public static void main(String[] args) {
        //Connector n = new Connector();
        //n.createConnection();
        launch(args);
    }
}
