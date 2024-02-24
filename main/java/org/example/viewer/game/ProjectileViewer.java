package org.example.viewer.game;

import org.example.gui.Window;
import org.example.model.game.elements.towers.Projectile;

public class ProjectileViewer implements ElementViewer<Projectile> {
    @Override
    public void draw(Projectile projectile, Window window) {
        window.drawProjectiles(projectile.getPosition(), window);

    }
}