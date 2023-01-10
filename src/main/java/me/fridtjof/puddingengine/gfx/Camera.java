package me.fridtjof.puddingengine.gfx;

import me.fridtjof.puddingengine.Core;

public class Camera
{

    private Core c;
    private double camX;
    private double camY;
    private double scale;

    public Camera(Core core, float scale, double camX, double camY)
    {
        this.c = core;
        this.scale = scale;

        setCamX(camX);
        setCamY(camY);
    }

    public double posX(float posX)
    {
        return camX + (posX * scale);
    }

    public double scaleX(float sizeX)
    {
        return sizeX * scale;
    }

    public double posY(float posY)
    {
        return camY + (posY * scale);
    }

    public double scaleY(float sizeY)
    {
        return sizeY * scale;
    }

    //setters and getters


    public double getScale()
    {
        return scale;
    }

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
        this.camX = posX * -1;
        //this.camX = (c.width / 2F) + (posX * -1);
    }

    public double getCamY()
    {
        return camY;
    }

    public void setCamY(double posY)
    {
        this.camY = posY * -1;
        //this.camY = (c.height / 2F) + (posY * -1);
    }
}
