package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LastScene implements Initializable {
    int page;
    @FXML
    ImageView Episode;
    @FXML
    Button goplay;

    public Label name;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Episode.setImage(new Image("4.png"));
        name.setText("И вот наш герой набрал !10! очков и остановил ЗЛЫХ зверей!");
        page = 5;
    }

    public void lateScene(ActionEvent actionEvent) {
        switch (page) {
            case 5:
                Episode.setImage(new Image("5.png"));
                name.setText("И в мире стало спокойно.");
                page = 6;
                break;
            case 6:
                Episode.setImage(new Image("6.png"));
                name.setText("Надолго ли?...");
                page = 7;
                goplay.setText("Конец");
                break;
            case 7:
                Stage stage = (Stage) name.getScene().getWindow();
                stage.close();
                break;
        }
    }
}
