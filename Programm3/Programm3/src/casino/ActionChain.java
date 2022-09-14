package casino;

import javafx.scene.image.ImageView;

import java.util.Random;

public class ActionChain {
    Player player;
    ImageView img;
    ImageView img2;
    ImageView img3;
    ImageView img1;
    Handler chain;
    Random generate;
    String warnum;
    final int NUMHANDLER=4;
    final int NUMMAX = 7;

    public ActionChain(Player player1, ImageView view, ImageView playerimg, ImageView warimg, String warnumber){
        generate =new Random();
        img=view;
        player=player1;
        img2=playerimg;
        img3=warimg;
        warnum=warnumber;
        buildChain();
    }


    private void buildChain(){
        chain = new ShansHendler( new PositiveHandler  (new NegativeHandler(null,player),player),player);
    }

    public boolean process() {
        int type=generate.nextInt(NUMHANDLER);//розыгрыш
        return process(type);
    }

    public boolean process(Integer a) {
        return chain.process(1+a%NUMHANDLER,img,img2,img3,warnum);//обрезка по числу имеющихся обработчиков
    }
}
