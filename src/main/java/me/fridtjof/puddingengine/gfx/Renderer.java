package me.fridtjof.puddingengine.gfx;

import me.fridtjof.puddingengine.Core;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer {

    Core c;
    Graphics g;

    public Renderer(Core core, Graphics graphics) {
        this.c = core;
        this.g = graphics;
    }

    public void drawImage(BufferedImage image, int x, int y) {
        drawImage(image, x, y, image.getWidth(), image.getHeight());
    }

    public void drawImage(BufferedImage image, int x, int y, int w, int h) {
        x = (int) c.getCamera().posX(x);
        y = (int) c.getCamera().posY(y);
        w = (int) c.getCamera().scaleX(w);
        h = (int) c.getCamera().scaleY(h);
        g.drawImage((Image) image, x, y, w, h, null);
    }

    public void fillRect(int x, int y, int w, int h, Color color) {
        x = (int) c.getCamera().posX(x);
        y = (int) c.getCamera().posY(y);
        w = (int) c.getCamera().scaleX(w);
        h = (int) c.getCamera().scaleY(h);
        g.setColor(color);
        g.fillRect(x, y, w, h);
    }
}
