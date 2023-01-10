package me.fridtjof.puddingengine.gfx.sprites;

import me.fridtjof.puddingengine.Core;

public abstract class AssetLoader
{

    protected Core core;

    public AssetLoader(Core core)
    {
        this.core = core;
    }
    public abstract void init();
    private static AssetLoader currentState = null;

    public static void setState(AssetLoader state)
    {
        currentState = state;
    }

    public static AssetLoader getState()
    {
        return currentState;
    }
}