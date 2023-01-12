package me.fridtjof.samplegame;

import me.fridtjof.samplegame.scenes.TestScene;
import me.fridtjof.puddingengine.Core;

public class Launcher
{

    public static void main(String[] args)
    {

        //launcher parameters
        String title = Core.NAME + " - " + Core.VERSION;
        int ratioHeight = 9;
        int ratioWidth = 16;
        int height = 420;
        int width = height / ratioHeight * ratioWidth;
        boolean fullscreen = false;
        int fpsLimit = 60;
        long startTime = System.currentTimeMillis();
        boolean debug = true;

        Core core = new Core(title, width, height, fullscreen, fpsLimit, startTime, debug);

        core.setScene(new TestScene(core));
        core.setAssetLoader(new TestAssets(core));
        core.start();
    }
}