package pl.venixpll.app;

import lombok.Data;
import org.lwjgl.input.Keyboard;
import org.newdawn.slick.*;
import pl.venixpll.app.render.RenderBall;
import pl.venixpll.app.render.RenderPlate;

import java.util.Random;

@Data
public class PongGameAPP extends BasicGame {

    public PongGameAPP(String title) {
        super(title);
    }

    private RenderPlate plate;
    private RenderBall ball;
    private GameContainer container;
    private Image ballImage;
    private Image backgroundImage;
    private Image plateImage;

    private int points = 0;

    private boolean endGame = true;

    private int leftClickTime;
    private int rightClickTime;

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.container = gameContainer;
        plate = new RenderPlate(this,(gameContainer.getWidth() / 2) - 40,gameContainer.getHeight() - 100);
        final Random random = new Random();
        int motionX = random.nextInt(5) + 4;
        int motionY = 4;
        if(random.nextBoolean()){
            motionX = -motionX;
        }
        ball = new RenderBall(this,(gameContainer.getWidth() / 2),gameContainer.getHeight() - 130,motionX,motionY);
    }

    public void endGame(){
        try {
            endGame = true;
            init(container);
        }catch(Exception exc){}
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        if(!endGame) {
            plate.update();
            ball.update();
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        if(!endGame){
            if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
                plate.setPosX(plate.getPosX() - 7);
            }else if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
                plate.setPosX(plate.getPosX() + 7);
            }
        }
        plate.draw(graphics);
        ball.draw(graphics);
        graphics.drawString("Punkty: " + points,10,22);
        if(endGame){
            final String text = "Nacisnij dowolny przycisk aby rozpocząc gre!";
            graphics.drawString(text,gameContainer.getWidth() / 2 - graphics.getFont().getWidth(text) / 2,gameContainer.getHeight() / 2);
        }
    }

    @Override
    public void mouseMoved(int oldx, int oldy, int newx, int newy) {
        if(!endGame) {
            plate.mouseMoved(newx, newy);
            ball.mouseMoved(newx, newy);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if(endGame) {
            endGame = false;
            points = 0;
        }
    }

    @Override
    public void keyReleased(int key, char c) {
        if(key == Keyboard.KEY_RIGHT){
            rightClickTime = 0;
        }else if(key == Keyboard.KEY_LEFT){
           leftClickTime = 0;
        }
    }

    public int hashCode(){
        return 0;
    }
}
