package me.fridtjof.puddingengine.gfx;

import me.fridtjof.puddingengine.Core;
import me.fridtjof.samplegame.TestAssets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Renderer
{

    Core c;
    Graphics g;

    public Renderer(Core core, Graphics graphics)
    {
        this.c = core;
        this.g = graphics;
    }

    protected void drawBorders(Graphics g, double ratioWidth, double ratioHeight)
    {
        g.setColor(Color.BLACK);

        if (ratioWidth > ratioHeight)
        {
            int width = (int)(c.getWindow().getWidth() - (((double) c.getWindow().getHeight()) / (double) c.sceneHeight) * c.sceneWidth) / 2;

            g.fillRect(0, 0, width, c.getWindow().getHeight());
            g.fillRect(c.getWindow().getWidth() - width, 0, width, c.getWindow().getHeight());

            if(!c.getCamera().isCentered())
            {
                c.getCamera().setBorderCamX(width);
            }
        }
        else if(ratioWidth < ratioHeight)
        {
            int height = (int)(c.getWindow().getHeight() - (((double) c.getWindow().getWidth()) / (double) c.sceneWidth) * c.sceneHeight) / 2;

            g.fillRect(0, 0, c.getWindow().getWidth(), height);
            g.fillRect(0, c.getWindow().getHeight() - height, c.getWindow().getWidth(), height);

            if(!c.getCamera().isCentered())
            {
                c.getCamera().setBorderCamY(height);
            }
        }
    }

    public void drawImage(BufferedImage image, int x, int y)
    {
        drawImage(image, x, y, image.getWidth(), image.getHeight());
    }

    public void drawImage(BufferedImage image, int x, int y, int w, int h)
    {
        x = (int) c.getCamera().posX(x);
        y = (int) c.getCamera().posY(y);
        w = (int) c.getCamera().scaleX(w);
        h = (int) c.getCamera().scaleY(h);
        g.drawImage((Image) image, x, y, w, h, null);
    }

    public void fillRect(int x, int y, int w, int h, Color color)
    {
        x = (int) c.getCamera().posX(x);
        y = (int) c.getCamera().posY(y);
        w = (int) c.getCamera().scaleX(w);
        h = (int) c.getCamera().scaleY(h);
        g.setColor(color);
        g.fillRect(x, y, w, h);
    }
}
