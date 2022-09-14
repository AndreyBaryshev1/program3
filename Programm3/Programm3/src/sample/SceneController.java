package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SceneController  implements Initializable {

    int page;
    @FXML
    ImageView Episode;

    public Label name;

    public void lateScene(ActionEvent actionEvent) throws IOException {

        switch (page) {
            case 1:
                Episode.setImage(new Image("2.png"));
                name.setText("Обезумевшие животные, надышавшись радиации начали изобретать технику для УНИЧТОЖЕНИЯ человечества!");
                page=2;
                break;
            case 2:
                Episode.setImage(new Image("3.png"));
                name.setText("Но БЕЗУМНЫЙ ученый БИНИДИКТ ТИЛИБИЛИТРЯМКИН создал робота способного остановить их!");
                page=3;
                break;
            case 3:

                Stage stage = (Stage) name.getScene().getWindow();
                stage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Игра");
                stage.setScene(new Scene(root1,900, 900));
                stage.show();
             break;

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Episode.setImage(new Image("1.png"));
        name.setText("Однажды кто-то выкинул на зоопарк целую гору радиации, и случилось нечто очень УЖАСНОЕ!");
        page=1;
    }
}
