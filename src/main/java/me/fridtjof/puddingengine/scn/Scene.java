package me.fridtjof.puddingengine.scn;

import me.fridtjof.puddingengine.Core;

import java.awt.*;

public abstract class Scene
{

    private static Scene currentState = null;

    public static void setState(Scene state)
    {
        currentState = state;
    }

    public static Scene getState()
    {
        return currentState;
    }

    protected Core core;

    public Scene(Core core)
    {
        this.core = core;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}