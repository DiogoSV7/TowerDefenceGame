package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.elements.Pixel;

public class PixelViewer implements ElementViewer<Pixel> {
    @Override
    public void draw(Pixel pixel, Window window) {
        window.drawPixel(pixel.getPosition());
    }
}
