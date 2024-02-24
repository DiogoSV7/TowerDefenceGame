package org.example.model.game.elements.enemys;

import org.example.model.game.Position;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

public class EnemyTest {
    @Test
    public void testEnemyInitialization() {
        double speed = 2.0;
        int totHP = 300;
        int x = 3;
        int y = 4;

        Orc orc = new Orc(x, y);

        assertEquals(x, orc.getPosition().getX());
        assertEquals(y, orc.getPosition().getY());
        assertEquals(speed, orc.getSpeed());
        assertEquals(totHP, orc.getActHP());
        assertEquals(totHP, orc.getActHP());
        assertEquals(totHP, orc.getHiddenHealth());
    }
    @Test
    void testDamage() {
        Enemy enemy = Mockito.mock(Enemy.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(enemy.getActHP()).thenReturn(100);
        enemy.damage(10);
        assertEquals(100, enemy.getActHP());
    }
    @Test
    void testReduceHiddenHealth() {
        Enemy enemy = Mockito.mock(Enemy.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(enemy.getHiddenHealth()).thenReturn(100);
        enemy.reduceHiddenHealth(10);
        assertEquals(100, enemy.getHiddenHealth());
    }
    @Test
    public void testHurtEnemy() {
        int x = 3;
        int y = 4;
        int damage = 30;
        Orc orc = new Orc(x, y);

        orc.damage(damage);

        assertEquals(270, orc.getActHP());
    }

    @Test
    public void testEnemyDie() {
        Enemy enemy = Mockito.mock(Enemy.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(enemy.getActHP()).thenReturn(0);
        enemy.die();
        assertTrue(enemy.isDead());
        assertEquals(0, enemy.getActHP());
    }
    @Test
    public void testEnemyDieWithNegativeHealth() {
        Enemy enemy = Mockito.mock(Enemy.class, Mockito.CALLS_REAL_METHODS);
        Mockito.when(enemy.getActHP()).thenReturn(0);
        enemy.die();
        enemy.setDeathPosition(enemy.getPosition());
        assertTrue(enemy.isDead());
        assertEquals(0, enemy.getActHP());
    }
    @Test
    public void testMoveSkeleton() {
        Skeleton skeleton = new Skeleton(1,1);
        Position originalPosition = new Position(1,8);
        skeleton.moveEnemies(skeleton);
        assertFalse(originalPosition.equals(skeleton.getPosition()));
    }

    @Test
    public void testMoveGolem() {
        Golem golem = new Golem(1,1);
        Position originalPosition = new Position(1,7);

        golem.moveEnemies(golem);
        assertFalse(originalPosition.equals(golem.getPosition()));
    }

    @Test
    public void testMoveOrc() {
        Orc orc = new Orc(1,1);
        Position originalPosition = new Position(1,6);
        orc.moveEnemies(orc);
        assertFalse(originalPosition.equals(orc.getPosition()));
    }
    @ParameterizedTest
    @ValueSource(ints = {6,7,8,9,10,11,12,13, 14,15,16,17,18,19,20,21})
    void testMoveOrcDown(int initialY){
        Orc orc = new Orc(42, initialY);
        Position originalPos = orc.getPosition();
        orc.moveOrc(orc);

        assertEquals(originalPos.getY()+1, orc.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {8,9,10,11,12,13, 14,15,16,17,18,19})
    void testMoveSkeletonDown(int initialY){
        Skeleton skeleton = new Skeleton(40, initialY);
        Position originalPos = skeleton.getPosition();
        skeleton.moveSkeleton(skeleton);

        assertEquals(originalPos.getY()+1, skeleton.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {7,8,9,10,11,12,13, 14,15,16,17,18,19,20})
    void testMoveGolemDown(int initialY){
        Golem golem = new Golem(41, initialY);
        Position originalPos = golem.getPosition();
        golem.moveGolem(golem);

        assertEquals(originalPos.getY()+1, golem.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {22,23,24,25,26,27,28,29,30})
    void testMoveOrcDown2(int initialY){
        Orc orc = new Orc(23, initialY);
        Position originalPos = orc.getPosition();
        orc.moveOrc(orc);

        assertEquals(originalPos.getY()+1, orc.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {23,24,25,26,27,28,29,30,31})
    void testMoveGolemDown2(int initialY){
        Golem golem = new Golem(22, initialY);
        Position originalPos = golem.getPosition();
        golem.moveGolem(golem);

        assertEquals(originalPos.getY()+1, golem.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {24,25,26,27,28,29,30,31,32})
    void testMoveSkeletonDown2(int initialY){
        Skeleton skeleton = new Skeleton(21, initialY);
        Position originalPos = skeleton.getPosition();
        skeleton.moveSkeleton(skeleton);

        assertEquals(originalPos.getY()+1, skeleton.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {24,25,26,27,28,29,30,31,32,33,34,35,36,37,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49, 50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90})
    void testMoveOrcLeft(int initialX) {
        Orc orc = new Orc(initialX, 22);
        Position originalPos = orc.getPosition();
        orc.moveOrc(orc);

        assertEquals(originalPos.getX()-1, orc.getPosition().getX());
    }
    @ParameterizedTest
    @ValueSource(ints = {23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48, 49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91})
    void testMoveGolemLeft(int initialX) {
        Golem golem = new Golem(initialX, 21);
        Position originalPos = golem.getPosition();
        golem.moveGolem(golem);

        assertEquals(originalPos.getX()-1, golem.getPosition().getX());
    }
    @ParameterizedTest
    @ValueSource(ints = {22,23,24,25,26,27,28,29,30,31,32,33,34,35,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46, 47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92})
    void testMoveSkeletonLeft(int initialX) {
        Skeleton skeleton = new Skeleton(initialX, 20);
        Position originalPos = skeleton.getPosition();
        skeleton.moveSkeleton(skeleton);

        assertEquals(originalPos.getX()-1, skeleton.getPosition().getX());
    }
    @ParameterizedTest
    @ValueSource(ints = {23,24,25,26,27,28,29,30})
    void testMoveOrcUp(int initialY) {
        Orc orc = new Orc(23, initialY);
        Position originalPos = orc.getPosition();
        orc.moveOrc(orc);

        assertEquals(originalPos.getY()+1, orc.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {24,25,26,27,28,29,30,31})
    void testMoveGolemUp(int initialY) {
        Golem golem = new Golem(22, initialY);
        Position originalPos = golem.getPosition();
        golem.moveGolem(golem);

        assertEquals(originalPos.getY()+1, golem.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {25,26,27,28,29,30,31,32})
    void testMoveSkeletonUp(int initialY) {
        Skeleton skeleton = new Skeleton(21, initialY);
        Position originalPos = skeleton.getPosition();
        skeleton.moveSkeleton(skeleton);

        assertEquals(originalPos.getY()+1, skeleton.getPosition().getY());
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11,12,13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29, 30,31,32,33,34,35,36,37,38,39,40})
    void testMoveOrcRight(int initialX) {
        Orc orc = new Orc(initialX, 5);
        Position otiginalPos = orc.getPosition();
        orc.moveOrc(orc);
        assertEquals(otiginalPos.getX()+1  , orc.getPosition().getX());
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11,12,13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27,28})
    void testMoveGolemRight(int initialX) {
        Golem golem = new Golem(initialX, 6);
        Position otiginalPos = golem.getPosition();
        golem.moveGolem(golem);
        assertEquals(otiginalPos.getX()+1  , golem.getPosition().getX());
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7,8,9,10,11,12,13, 14,15,16,17,18,19,20,21,22,23,24,25,26,27})
    void testMoveSkeletonRight(int initialX) {
        Skeleton skeleton = new Skeleton(initialX, 7);
        Position otiginalPos = skeleton.getPosition();
        skeleton.moveSkeleton(skeleton);
        assertEquals(otiginalPos.getX()+1  , skeleton.getPosition().getX());
    }

    @ParameterizedTest
    @ValueSource(ints = {32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16, 15,14,13,12,11,10,9,8,7,6})
    void testMoveOrcToEnd(int initialY) {
        Orc orc = new Orc(91, initialY);
        Position originalPos = orc.getPosition();
        orc.moveOrc(orc);

        assertEquals(originalPos.getY()-1, orc.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16, 15,14,13,12,11,10,9,8,7,6})
    void testMoveGolemToEnd(int initialY) {
        Golem golem = new Golem(92, initialY);
        Position originalPos = golem.getPosition();
        golem.moveGolem(golem);

        assertEquals(originalPos.getY()-1, golem.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19, 18,17,16,15,14,13,12,11,10,9,8,7,6})
    void testMoveSkeletonToEnd(int initialY) {
        Skeleton skeleton = new Skeleton(93, initialY);
        Position originalPos = skeleton.getPosition();
        skeleton.moveSkeleton(skeleton);

        assertEquals(originalPos.getY()-1, skeleton.getPosition().getY());
    }
    @ParameterizedTest
    @ValueSource(ints = {22,23,24,25,26,27,28,29,30,31,32,33,34,35,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46, 47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90})
    void testMoveOrcRight2(int initialX){
        Orc orc = new Orc(initialX, 31);
        Position originalPos = orc.getPosition();
        orc.moveOrc(orc);

        assertEquals(originalPos.getX()+1, orc.getPosition().getX());
    }
    @ParameterizedTest
    @ValueSource(ints = {23,24,25,26,27,28,29,30,31,32,33,34,35,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46, 47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91})
    void testMoveGolemRight2(int initialX){
        Golem golem = new Golem(initialX, 32);
        Position originalPos = golem.getPosition();
        golem.moveGolem(golem);

        assertEquals(originalPos.getX()+1, golem.getPosition().getX());
    }
    @ParameterizedTest
    @ValueSource(ints = {24,25,26,27,28,29,30,31,32,33,34,35,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46, 47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92})
    void testMoveSkeletonRight2(int initialX){
        Skeleton skeleton = new Skeleton(initialX, 33);
        Position originalPos = skeleton.getPosition();
        skeleton.moveSkeleton(skeleton);

        assertEquals(originalPos.getX()+1, skeleton.getPosition().getX());
    }
}
