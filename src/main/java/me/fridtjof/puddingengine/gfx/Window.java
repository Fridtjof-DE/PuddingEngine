package me.fridtjof.puddingengine.gfx;

import javax.swing.*;
import java.awt.*;

public class Window
{

    private static boolean fullscreen = false;
    private static JFrame frame;
    private Canvas canvas;

    private String title;
    private int width, height;

    public Window(String title, int width, int height, boolean fullscreen)
    {
        this.title = title;
        this.width = width;
        this.height = height;
        this.fullscreen = fullscreen;
        createDisplay();
    }

    private void createDisplay()
    {
        //set window properties
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
}