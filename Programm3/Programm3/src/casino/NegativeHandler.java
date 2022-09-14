package casino;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NegativeHandler extends Handler {
    public NegativeHandler(Handler processor, Player player) {
        super(processor,player);
    }

    public boolean process(Integer request,ImageView img,ImageView playerimg, ImageView warimg,String warnum) {
        //свой, обрабатывается здесь
        warimg.setImage(new Image("warwin"+warnum+".gif"));
            img.setImage(new Image("miss.png"));
            return true;
    }
}
