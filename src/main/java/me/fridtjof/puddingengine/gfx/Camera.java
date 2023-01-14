package me.fridtjof.puddingengine.gfx;

import me.fridtjof.puddingengine.Core;

import java.awt.*;

public class Camera
{

    private Core c;
    private double camX, camY;

    private double borderCamX = 0;
    private double borderCamY = 0;
    private double scale = 1;
    private double effectiveScale;

    //TODO centering
    private boolean centered = false;

    private int sceneWidth, sceneHeight;
    private int windowWidth, windowHeight;

    public Camera(Core core, Graphics g, float scale, double camX, double camY)
    {
        this.c = core;
        this.effectiveScale = scale;

        setCamX(camX);
        setCamY(camY);

        sceneWidth = c.sceneWidth;
        sceneHeight = c.sceneHeight;
    }

    public void tick(Graphics g)
    {
        windowWidth = c.getWindow().getWidth();
        windowHeight = c.getWindow().getHeight();
        setEffectiveScale();
        renderBorders(g);
    }

    private void setEffectiveScale()
    {
        effectiveScale = Math.round((scale / ((double) getShorterSceneSide() / (double) getShorterWindowSide())) * 2) / 2.0;

        //c.logger.debug(getShorterSceneSide() + " - " + getShorterWindowSide() + " - " + effectiveScale + "");
    }

    private void renderBorders(Graphics g)
    {
        double ratioWidth = (double) windowWidth / (double) sceneWidth;
        double ratioHeight = (double) windowHeight / (double) sceneHeight;

        c.logger.debug(ratioWidth + " - " + ratioHeight);

        c.r().drawBorders(g, ratioWidth, ratioHeight);
    }

    public double posX(float posX)
    {
        return camX + (posX * effectiveScale);
    }

    public double scaleX(float sizeX)
    {
        return sizeX * effectiveScale;
    }

    public double posY(float posY)
    {
        return camY + (posY * effectiveScale);
    }

    public double scaleY(float sizeY)
    {
        return sizeY * effectiveScale;
    }

    private int getShorterSceneSide()
    {
        int side;

        if(sceneWidth > sceneHeight)
        {
            side = sceneHeight;
        }
        else
        {
            side = sceneWidth;
        }

        return side;
    }

    private int getShorterWindowSide()
    {
        int width = windowWidth;
        int height = windowHeight;
        int shorterSide;

        if(width > height)
        {
            shorterSide = height;
        }
        else
        {
            shorterSide = width;
        }

        return shorterSide;
    }

    //setters and getters

    public double getScale()
    {
        return effectiveScale;
    }

    //Should be X or X.5
    public void setScale(double scale)
    {
        this.scale = scale;
    }

    public double getCamX()
    {
        return camX;
    }

    public void setCamX(double posX)
    {
        this.camX = (posX * -1) + borderCamX;
        //this.camX = (c.width / 2F) + (posX * -1);
    }

    public double getCamY()
    {
        return camY;
    }

    public void setCamY(double posY)
    {
        this.camY = (posY * -1) + borderCamY;
        //this.camY = (c.height / 2F) + (posY * -1);
    }

    protected void setBorderCamX(double borderCamX)
    {
        this.borderCamX = borderCamX;
    }

    protected void setBorderCamY(double borderCamY)
    {
        this.borderCamY = borderCamY;
    }

    public boolean isCentered()
    {
        return centered;
    }
}
