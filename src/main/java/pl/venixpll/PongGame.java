package pl.venixpll;

import org.newdawn.slick.AppGameContainer;
import pl.venixpll.app.PongGameAPP;

public class PongGame {

    public static void main(String[] args) throws Exception {
        System.out.println("Uruchamianie...");
        final AppGameContainer appgc = new AppGameContainer(new PongGameAPP("Pong"));
        appgc.setVSync(true);
        appgc.setShowFPS(true);
        appgc.setTargetFrameRate(60);
        appgc.setDisplayMode(800,600,false);
        appgc.start();
    }

}
