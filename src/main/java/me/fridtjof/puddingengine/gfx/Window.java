package me.fridtjof.puddingengine.gfx;

import me.fridtjof.puddingengine.Core;

import javax.swing.*;
import java.awt.*;

public class Window
{

    private Core c;
    private static boolean fullscreen = false;
    private static JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    public Window(Core core, String title, int width, int height, boolean fullscreen)
    {
        this.c = core;
        this.title = title;
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;
        createDisplay();
    }

    private void createDisplay()
    {
        //set window properties
        if(fullscreen)
        {
            GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
            width = gd.getDisplayMode().getWidth();
            height = gd.getDisplayMode().getHeight();
        }


        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        if(fullscreen)
        {
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
        }

        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public void updateTitle(String title)
    {
        frame.setTitle(title);
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public JFrame getFrame()
    {
        return frame;
    }

    public int getWidth()
    {
        return canvas.getWidth();
    }

    public int getHeight()
    {
        return canvas.getHeight();
    }
}