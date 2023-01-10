package me.fridtjof.puddingengine.gfx.sprites;

import java.awt.image.BufferedImage;

public class Sprite {
    private BufferedImage sprite;

    public Sprite(BufferedImage sprite) {
        this.sprite = sprite;
    }

    public BufferedImage crop(int xGrid, int yGrid, int width, int height, int gridSize) {
        return sprite.getSubimage(xGrid * gridSize, yGrid * gridSize, width * gridSize, height * gridSize);
    }

    public BufferedImage full() {
        return sprite;
    }
}