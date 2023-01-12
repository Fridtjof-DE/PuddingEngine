package me.fridtjof.puddingengine.io;

import me.fridtjof.puddingengine.Core;

import java.awt.event.*;

public class Input implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener
{
    private Core c;

    private final int NUM_KEYS = 256;
    private boolean[] keys = new boolean[NUM_KEYS];
    private boolean[] keysLast = new boolean[NUM_KEYS];

    private final int NUM_BUTTONS = 5;
    private boolean[] buttons = new boolean[NUM_BUTTONS];
    private boolean[] buttonsLast = new boolean[NUM_BUTTONS];

    private int mouseX, mouseY;
    private int scroll;

    public Input(Core c)
    {
        this.c = c;
        mouseX = 0;
        mouseY = 0;
        scroll = 0;

        c.getWindow().getFrame().addKeyListener(this);
        c.getWindow().getCanvas().addMouseListener(this);
        c.getWindow().getCanvas().addMouseMotionListener(this);
        c.getWindow().getCanvas().addMouseWheelListener(this);
    }

    public void tick()
    {
        scroll = 0;

        for(int i = 0; i < NUM_KEYS; i++)
        {
            keysLast[i] = keys[i];
        }

        for(int i = 0; i < NUM_BUTTONS; i++) {

            buttonsLast[i] = buttons[i];
        }
    }

    public boolean isKeyPressed(int keyCode)
    {
        return keys[keyCode];
    }
    public boolean isKeyJustReleased(int keyCode)
    {
        return !keys[keyCode] && keysLast[keyCode];
    }
    public boolean isKeyJustPressed(int keyCode)
    {
        return keys[keyCode] && !keysLast[keyCode];
    }

    public boolean isButtonPressed(int button)
    {
        return buttons[button];
    }
    public boolean isButtonJustReleased(int button)
    {
        return !buttons[button] && buttonsLast[button];
    }
    public boolean isButtonJustPressed(int button)
    {
        return buttons[button] && !buttonsLast[button];
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        c.logger.debug("Key Pressed Event");
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        c.logger.debug("Key Released Event");
        keys[e.getKeyCode()] = false;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {

    }

    @Override
    public void mouseExited(MouseEvent e)
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
        mouseX = (int)(e.getX());
        mouseY = (int)(e.getY());
        //mouseX = (int)(e.getX() / c.getScale());
        //mouseY = (int)(e.getY() / c.getScale());
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        mouseX = (int)(e.getX());
        mouseY = (int)(e.getY());
        //mouseX = (int)(e.getX() / c.getScale());
        //mouseY = (int)(e.getY() / c.getScale());
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e)
    {
        scroll = e.getWheelRotation();
    }


    //getters

    public int getMouseX()
    {
        return mouseX;
    }

    public int getMouseY()
    {
        return mouseY;
    }

    public int getScroll()
    {
        return scroll;
    }
}
