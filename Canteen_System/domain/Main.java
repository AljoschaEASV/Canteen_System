package domain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import Application.DatabaseConnector;

public class Main extends Application {

    public static void main(String[] args) {
        DatabaseConnector n = new DatabaseConnector();
        n.createConnection();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/OrderUI.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
