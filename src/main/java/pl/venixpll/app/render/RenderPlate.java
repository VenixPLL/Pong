package pl.venixpll.app.render;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import pl.venixpll.app.PongGameAPP;

@AllArgsConstructor
@Data
public class RenderPlate implements IRender {

    private PongGameAPP app;
    private int posX,posY;

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(posX,posY,80,20);
        if(posX < 0 || posX == 0){
            posX = 0;
        }else if(posX + 80 > app.getContainer().getWidth() || posX + 80 == app.getContainer().getWidth()){
            posX = app.getContainer().getWidth() - 80;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void mouseMoved(int x, int y) {
        posX = x - 40;
    }
}
