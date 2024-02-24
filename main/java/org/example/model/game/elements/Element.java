package org.example.model.game.elements;

import org.example.model.game.Position;

public class Element {
    private Position position;

    public Element(float x, float y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }
    public float getX(){
        return position.getX();
    }
    public float getY(){
        return position.getY();
    }
    public void setX(float x){
        position.setX(x);
    }
    public void setY(float y){
        position.setY(y);
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
