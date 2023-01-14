package me.fridtjof.samplegame.scenes;

import me.fridtjof.puddingengine.Core;
import me.fridtjof.puddingengine.scn.Scene;
import me.fridtjof.samplegame.TestAssets;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestScene extends Scene {

    Core c;

    public TestScene(Core c) {
        super(c);
        this.c = c;
    }

    @Override
    public void tick()
    {
        if (c.getInput().isKeyPressed(KeyEvent.VK_W))
        {
            c.logger.info("test W");
        }
        if (c.getInput().isButtonJustReleased(1))
        {
            c.logger.debug("test MOuse");
        }
        if (c.getInput().isKeyJustReleased(KeyEvent.VK_S))
        {
            c.logger.debug("test 1");
        }
        if (c.getInput().isKeyJustPressed(KeyEvent.VK_D))
        {
            c.logger.debug("test 5");
        }
    }

    @Override
    public void render(Graphics g) {

        c.getCamera().setCamX(-50);
        c.getCamera().setCamY(-50);
        //c.getCamera().setScale(7.5);

        c.r().fillRect(1, 150, 50, 50, Color.RED);

        c.r().drawImage(TestAssets.PURPLE_TILE, 0, 0, 50, 50);
        c.r().drawImage(TestAssets.PURPLE_TILE, 50, 0, 50, 50);
        c.r().drawImage(TestAssets.PURPLE_TILE, 100, 0, 50, 50);
        c.r().drawImage(TestAssets.PURPLE_TILE, 150, 0, 50, 50);
        c.r().drawImage(TestAssets.PURPLE_TILE, -50, -50, 50, 50);
        //g.drawImage(TestAssets.PURPLE_TILE, 200, 400, 16, 160, null);
        //g.drawImage(TestAssets.SHEET, c.sceneWidth / 2, c.sceneHeight / 2, 250, 250, null);
    }
}
