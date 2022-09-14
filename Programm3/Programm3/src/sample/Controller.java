package sample;

import casino.ActionChain;
import casino.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public TextField name;
    public Button addMoney;
    public Button restart;

    public Button goplay;
    public Label money;
    public int sizeimage;
    String warnumber;

    int temp=1;

    @FXML
    ImageView view1;
    @FXML
    ImageView view2;

    @FXML
    ImageView warimg;
    @FXML
    ImageView playerimg;
    @FXML
    ImageView view3;
    ActionChain action=null;
    Player player1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        warnumber= String.valueOf(getRandomIntegerBetweenRange(1,2));
        resetimage();
        view1.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (player1!=null) {
                player1.pay(1);
                onStart(view1,warnumber);
                if (action == null) return;//если цепочка обработки отсутствует
                if (action.process()) init();//продолжить играть и проверить наличия монетки у игрока
                else action = null;//завершить игру, сделав обработку недоступной
                money.setText(player1.getNumber().toString());
                imageDisable(true);
            }
        });
        view2.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (player1!=null) {
                player1.pay(1);
                onStart(view2,warnumber);
                if (action == null) return;//если цепочка обработки отсутствует
                if (action.process()) init();//продолжить играть и проверить наличия монетки у игрока
                else action = null;//завершить игру, сделав обработку недоступной
                money.setText(player1.getNumber().toString());
                imageDisable(true);
            }
        });
        view3.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (player1!=null) {
                player1.pay(1);
                onStart(view3,warnumber);
                if (action == null) return;//если цепочка обработки отсутствует
                if (action.process()) init();//продолжить играть и проверить наличия монетки у игрока
                else action = null;//завершить игру, сделав обработку недоступной
                money.setText(player1.getNumber().toString());
                imageDisable(true);
            }
        });

    }
    public void createPlayer()
    {
        player1=new Player(name.getText(),5);
        money.setText(player1.getNumber().toString());
        addMoney.setDisable(false);
        restart.setDisable(false);
    }
    public void onPay(ActionEvent actionEvent) {
        player1.addNumber(1);
        money.setText(player1.getNumber().toString());
    }

    public void restartPlay(ActionEvent actionEvent) {

        imageDisable(false);
        resetimage();
    }

    public void resetimage(){
        sizeimage=0;
        view1.setImage(new Image("load.png"));
        view2.setImage(new Image("load.png"));
        view3.setImage(new Image("load.png"));
        playerimg.setImage(new Image("playerload.gif"));
        warimg.setImage(new Image("warload"+warnumber+".gif"));

    }

    public static int getRandomIntegerBetweenRange(int min, int max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return (int) x;
    }
    public void imageDisable(boolean temp){
        view1.setDisable(temp);
        view2.setDisable(temp);
        view3.setDisable(temp);
    }

    public void onStart(ImageView view1,String warnumber) {
        if(!init()) return;//проверка ликвидности
        action=new ActionChain(player1,view1,playerimg,warimg,warnumber);//запуск механизма розыгрыша
    }

    public boolean init(){

       int PlayerMoney=Integer.parseInt(money.getText());
       if (player1.getNumber()-PlayerMoney ==1)
       {
           switch (warnumber){
               case "1":
                   warnumber="2";
                   warimg.setImage(new Image("warload"+warnumber+".gif"));
                   break;
               case "2":
                   warnumber="1";
                   warimg.setImage(new Image("warload"+warnumber+".gif"));
                   break;
           }
       }
        if(player1.getNumber()==0) {
            money.setText("0");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Баланс всё!");
            alert.show();
            action=null;
            resetimage();
            return false;
        }

        if(PlayerMoney==10) {
            if (temp==1) {
                Stage stage = (Stage) name.getScene().getWindow();
                stage.close();

                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("lastScene.fxml"));
                Parent root1 = null;
                try {
                    root1 = (Parent) fxmlLoader.load();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                stage = new Stage();
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setTitle("Игра");
                stage.setScene(new Scene(root1, 900, 530));
                stage.show();

                temp=2;

                return false;
            }
            else return false;
        }

        else return true;
    }

}
