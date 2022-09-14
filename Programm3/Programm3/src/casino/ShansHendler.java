package casino;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShansHendler extends Handler {
    public ShansHendler(Handler processor, Player player) {
        super(processor, player);
    }
    public boolean process(Integer request, ImageView img, ImageView playerimg, ImageView warimg,String warnum) {
        if(request!=CHANCE) return super.process(request,img,playerimg,warimg,warnum);// не свой запрос передается дальше по цепочке
        else {//свой, обрабатывается здесь
            playerimg.setImage(new Image("playerwin.gif"));
            warimg.setImage(new Image("warwin"+warnum+".gif"));
            img.setImage(new Image("shans.png"));

            player1.addNumber(1);
            return true;
        }
    }

}
