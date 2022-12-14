package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Parent root1 = FXMLLoader.load(getClass().getResource("firstScene.fxml"));
        primaryStage.setTitle("Игра");
        primaryStage.setScene(new Scene(root1, 900, 530));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
