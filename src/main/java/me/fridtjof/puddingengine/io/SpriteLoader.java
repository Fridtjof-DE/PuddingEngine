package me.fridtjof.puddingengine.io;

import me.fridtjof.puddingengine.Core;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

public class SpriteLoader
{

    Core c;

    public SpriteLoader(Core c)
    {
        this.c = c;
    }

    public BufferedImage loadImage(String path)
    {
        try
        {
            return ImageIO.read(Objects.requireNonNull(SpriteLoader.class.getResource(path)));
        }
        catch (IOException | IllegalArgumentException e)
        {
            c.logger.error("Could not load image!");
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
