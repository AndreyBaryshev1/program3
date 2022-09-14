package casino;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Controller;

public class PositiveHandler extends Handler{
public String warn;
    public Controller controller;
    public PositiveHandler(Handler processor, Player player) {
        super(processor,player);
    }

    public boolean process(Integer request,ImageView img,ImageView playerimg, ImageView warimg,String warnum) {
        if(request!=SUCCESS) return super.process(request,img,playerimg,warimg,warnum);// не свой запрос передается дальше по цепочке
        else {
            playerimg.setImage(new Image("playerwin.gif"));
            warimg.setImage(new Image("warload"+warnum+".gif"));
            img.setImage(new Image("win.png"));

            player1.addNumber(2);
            return true;
        }
    }

}
