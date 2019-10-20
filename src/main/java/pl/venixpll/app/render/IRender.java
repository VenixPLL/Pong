package pl.venixpll.app.render;

import org.newdawn.slick.Graphics;

public interface IRender {

    void draw(final Graphics graphics);
    void update();
    void mouseMoved(int x,int y);

}
