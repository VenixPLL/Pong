package pl.venixpll.app.render;

import lombok.AllArgsConstructor;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import pl.venixpll.app.PongGameAPP;

@AllArgsConstructor
public class RenderBall implements IRender {

    private PongGameAPP app;
    private int posX,posY;
    private double motionX,motionY;

    @Override
    public void draw(Graphics graphics) {
        final Circle circle = new Circle(posX,posY,5,50);
        graphics.fill(circle);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        graphics.draw(circle);
    }

    @Override
    public void update() {
        posX += motionX;
        posY -= motionY;

        if(posX < 0 || posX == 0){
            motionX = -motionX;
        }else if(posX > app.getContainer().getWidth() || posX == app.getContainer().getWidth()){
            motionX = -motionX;
        }

        if(posY < 0 || posY == 0){
            motionY = -motionY;
        }else if(posY > app.getContainer().getHeight() || posY == app.getContainer().getHeight()){
            motionY = -motionY;
            app.endGame();
        }

        final RenderPlate rp = app.getPlate();
        final Rectangle plateRect = new Rectangle(rp.getPosX(),rp.getPosY(),80,1);
        final Circle circleBoundingBox = new Circle(posX,posY,5,50);
        if(plateRect.intersects(circleBoundingBox)){
            motionY = -motionY;
            app.setPoints(app.getPoints() + 1);
        }

    }

    @Override
    public void mouseMoved(int x, int y) {

    }
}
