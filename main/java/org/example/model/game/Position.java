package org.example.model.game;

import java.util.Objects;

public class Position {
    private  float x;
    private float y;
    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void setX(float x){
        this.x=x;
    }
    public void setY(float y){
        this.y=y;
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Float.compare(position.x, x) == 0 && Float.compare(position.y, y) == 0;
    }


    @Override
    public int hashCode() {
        return Objects.hash(Float.hashCode(x), Float.hashCode(y));
    }

}

