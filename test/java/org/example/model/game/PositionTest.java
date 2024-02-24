package org.example.model.game;

import net.jqwik.api.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PositionTest {

    @Test
    void testConstructorAndGetters() {
        Position position = new Position(1, 2);
        assertEquals(1, position.getX());
        assertEquals(2, position.getY());
    }

    @Test
    void testSetters() {
        Position position = new Position(1, 2);
        position.setX(3);
        position.setY(4);
        assertEquals(3, position.getX());
        assertEquals(4, position.getY());
    }

    @Test
    void testEquality() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(1, 2);
        Position position3 = new Position(3, 4);

        assertEquals(position1, position2);
        assertNotEquals(position1, position3);
    }

    @Test
    void testHashCode() {
        Position position1 = new Position(1, 2);
        Position position2 = new Position(1, 2);
        Position position3 = new Position(3, 4);

        assertEquals(position1.hashCode(), position2.hashCode());
        assertNotEquals(position1.hashCode(), position3.hashCode());
    }

    @Test
    void testEqualityWithNull() {
        Position position = new Position(1, 2);
        assertNotEquals(position, null);
    }
    @Property
    void settingXAndYAndUsingSettersShouldReturnCorrectValues(@ForAll int x1, @ForAll int y1, @ForAll int x2, @ForAll int y2){
        Position position = new Position(x1, y1);
        position.setX(x2);
        position.setY(y2);
        assertEquals(x2, position.getX());
        assertEquals(y2, position.getY());
    }

    @Property
    void equalityTest(@ForAll int x, @ForAll int y) {
        Position position1 = new Position(x, y);
        Position position2 = new Position(x, y);
        assertEquals(position1, position2);
    }
}
