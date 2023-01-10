package me.fridtjof.puddingengine;

import me.fridtjof.puddingengine.gfx.Camera;
import me.fridtjof.puddingengine.gfx.Renderer;
import me.fridtjof.puddingengine.gfx.Window;
import me.fridtjof.puddingengine.gfx.sprites.AssetLoader;
import me.fridtjof.puddingengine.io.Input;
import me.fridtjof.puddingengine.io.SpriteLoader;
import me.fridtjof.puddingengine.io.Logger;
import me.fridtjof.puddingengine.scn.Scene;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Core implements Runnable{

    //window
    private me.fridtjof.puddingengine.gfx.Window window;
    private BufferStrategy bs;
    private Graphics g;
    public int width, height, fpsLimit;
    private boolean fullscreen, debug;

    public Logger logger;
    public Scene scene;

    private SpriteLoader spriteLoader;
    private AssetLoader assetLoader;
    private Camera camera;
    private Renderer renderer;
    private Input input;

    public static String VERSION = "ALPHA";
    public static String NAME = "Pudding Engine";
    public String title;
    public long startTime;

    private boolean running = false;
    private Thread thread;


    public Core(String title, int width, int height, boolean fullscreen, int fpsLimit, long startTime, boolean debug) {
        this.title = title;
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;
        this.fpsLimit = fpsLimit;
        this.startTime = startTime;
        this.debug = debug;

        logger = new Logger(debug);
    }

    private void init() {
        //logging
        logger.info("Initialisation...");

        //window
        if(fullscreen) {
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            width = gd.getDisplayMode().getWidth();
            height = gd.getDisplayMode().getHeight();
        }
        window = new me.fridtjof.puddingengine.gfx.Window(title, width, height, fullscreen);

        spriteLoader = new SpriteLoader(this);
        assetLoader.init();
        camera = new Camera(this,1, 0, 0);

        input = new Input(this);

        Scene.setState(scene);

        //logging
        long bootTime = System.currentTimeMillis() - startTime;
        logger.info("Engine successfully initialized in " + bootTime + "ms!");
    }

    private void tick() {

        input.tick();

        if(Scene.getState() != null) {
            Scene.getState().tick();
        }
    }

    private void render() {
        bs = window.getCanvas().getBufferStrategy();
        if(bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        renderer = new Renderer(this, g);

        //Clear Screen
        g.clearRect(0, 0, width, height);

        //Draw Here!
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, width, height);


        if(Scene.getState() != null) {
            Scene.getState().render(g);
        }

        //End drawing!
        bs.show();
        g.dispose();
    }

    public void run() {

        init();

        int tpsLimit = 60;
        double timePerTick = 1E9 / tpsLimit;
        double timePerFrame = 1E9 / fpsLimit;
        double delta_tps = 0;
        double delta_fps = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        int frames = 0;


        while(running) {
            now = System.nanoTime();
            delta_tps += (now - lastTime) / timePerTick;
            delta_fps += (now - lastTime) / timePerFrame;
            timer += now - lastTime;
            lastTime = now;

            if(delta_tps >= 1) {
                tick();
                ticks++;
                delta_tps--;
            }

            if(delta_fps >= 1) {
                render();
                frames++;
                delta_fps--;
            }

            if(timer >= 1000000000) {

                //window title
                window.updateTitle(title + " | TPS: " + ticks + ", FPS: " + frames);

                ticks = 0;
                frames = 0;
                timer = 0;
            }
        }

        stop();
    }

    public synchronized void start() {
        if(running) {
            return;
        } else {

            running = true;
            thread = new Thread(this);
            thread.setName("Main thread");
            logger.info("Starting main thread...");
            thread.start();
        }
    }

    public synchronized void stop() {
        logger.info("Stopping engine...");
        if(!running) {
            return;
        } else {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //setters and getters

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setAssetLoader(AssetLoader assetLoader) {
        this.assetLoader = assetLoader;
    }

    public AssetLoader getAssetLoader() {
        return assetLoader;
    }

    public SpriteLoader getSpriteLoader() {
        return spriteLoader;
    }

    public Window getWindow() {
        return window;
    }

    public Camera getCamera() {
        return camera;
    }

    public Renderer r() {
        return renderer;
    }

    public Input getInput() {
        return input;
    }
}