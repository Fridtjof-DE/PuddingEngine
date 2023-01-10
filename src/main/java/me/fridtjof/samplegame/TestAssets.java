package me.fridtjof.samplegame;

import me.fridtjof.puddingengine.Core;
import me.fridtjof.puddingengine.gfx.sprites.AssetLoader;
import me.fridtjof.puddingengine.gfx.sprites.Sprite;

import java.awt.image.BufferedImage;

public class TestAssets extends AssetLoader
{
    Core c;

    private static final int GRID = 16;
    public static BufferedImage GRASS_TILE, PLAYER, ROCK_TILE, PURPLE_TILE, SHEET;

    public TestAssets(Core c)
    {
        super(c);
        this.c = c;
    }

    @Override
    public void init()
    {
        Sprite tileSheet = new Sprite(c.getSpriteLoader().loadImage("/samplegame/images/tile_map.png"));

        GRASS_TILE = tileSheet.crop(0, 0, 1, 1, GRID);
        PLAYER = tileSheet.crop(1, 0, 1, 1, GRID);
        ROCK_TILE = tileSheet.crop(0, 1, 1, 1, GRID);
        PURPLE_TILE = tileSheet.crop(1, 1, 1, 1, GRID);

        SHEET =  tileSheet.full();
    }
}
