package org.example.gui;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;
import org.example.model.game.Position;
import org.example.model.game.elements.Chest;
import org.example.model.game.elements.TowerPositions;
import org.example.model.game.elements.enemys.Enemy;
import org.example.model.game.elements.towers.Tower;
import org.example.states.MenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WindowTest {
    private Window window;
    private TextGraphics tg;
    private ArrayList<TowerPositions> towerPositions;

    @BeforeEach
    void setUp() {
        Screen screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        window = new Window(screen);
        towerPositions = new ArrayList<>();
        towerPositions.add(new TowerPositions(1, 1, '1'));
    }

    @Test
    void drawIntoGameText() throws Exception {
        window.drawIntoGameText(new Position(1, 1), "Hello World", "#336699");
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("#336699"));
        verify(tg, times(1)).putString(1, 1, "Hello World");
    }

    @Test
    void drawWall() throws Exception {
        window.drawWall(new Position(1, 1));
        verify(window.getScreen(), times(1)).setCharacter(1, 1, TextCharacter.DEFAULT_CHARACTER.withBackgroundColor(TextColor.ANSI.WHITE));
    }

    @Test
    void drawPixel() throws Exception {
        window.drawPixel(new Position(1, 1));
        verify(window.getScreen(), times(1)).setCharacter(1, 1, TextCharacter.DEFAULT_CHARACTER.withBackgroundColor(TextColor.ANSI.GREEN_BRIGHT));
    }

    @Test
    void testRefresh() throws Exception {
        window.refresh();
        verify(window.getScreen(), times(1)).refresh();
    }

    @Test
    void testDrawChest() throws Exception {
        window.drawChest(new Position(1, 1), new Chest(1, 1));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("YELLOW"));
        verify(tg, times(1)).putString(1, 1, "C");
    }

    @Test
    void testDrawPath() throws Exception {
        window.drawPath(new Position(1, 1));
        verify(window.getScreen(), times(1)).setCharacter(1, 1, TextCharacter.DEFAULT_CHARACTER.withBackgroundColor(TextColor.ANSI.WHITE));
    }

    @Test
    void testClear() throws Exception {
        window.clear();
        verify(window.getScreen(), times(1)).clear();
    }

    @Test
    void testClose() throws Exception {
        window.close();
        verify(window.getScreen(), times(1)).close();
    }

    @Test
    void testDrawTowerPositions() throws Exception {
        window.drawTowerPositions(new Position(1, 1), towerPositions.get(0));
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("GREEN"));
        verify(tg, times(1)).putString(1, 1, "1");
    }

    @Test
    void testDrawEnemy() throws Exception {
        Enemy enemy = Mockito.mock(Enemy.class);
        when(enemy.getEnemySymbol()).thenReturn('E');
        window.drawEnemy(new Position(1, 1), enemy);
        verify(tg).setForegroundColor(TextColor.Factory.fromString("RED"));
        verify(tg).putString(1, 1, "E");
    }

    @Test
    void testDrawTower() throws Exception {
        Tower tower = Mockito.mock(Tower.class);
        when(tower.getTowerSymbol()).thenReturn('T');
        window.drawTower(new Position(1, 1), tower);
        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString("GREEN"));
        verify(tg, times(1)).putString(1, 1, "T");
    }

    @Test
    void testDrawIntoGameText() throws Exception {
        window.drawIntoGameText(new Position(4, 4), "TEXT", "BLUE");
        verify(tg).setForegroundColor(TextColor.Factory.fromString("BLUE"));
        verify(tg).putString(4, 4, "TEXT");
    }

    @Test
    void drawTextTest() {
        Position position = new Position(1, 1);
        window.drawText(position, "Test Text", "GREEN");
        verify(tg).putString(1, 1, "Test Text", SGR.BOLD);
    }

    @Test
    void drawProjectileTest() {
        Position position = new Position(1, 1);
        window.drawProjectiles(position, window);
        verify(tg).putString(1, 1, "o");
    }

    @Test
    void testDrawIntoGameChar() throws Exception {
        window.drawIntoGameChar(5, 5, 'C', "YELLOW");
        verify(tg).setForegroundColor(TextColor.Factory.fromString("YELLOW"));
        verify(tg).putString(5, 5, "C");
    }

    @Test
    void testFromNumericValue() {
        assertEquals(WindowInterface.KEY.NUM_1, WindowInterface.KEY.fromNumericValue(1));
        assertEquals(WindowInterface.KEY.NUM_2, WindowInterface.KEY.fromNumericValue(2));
        assertEquals(WindowInterface.KEY.NUM_3, WindowInterface.KEY.fromNumericValue(3));
        assertEquals(WindowInterface.KEY.NUM_4, WindowInterface.KEY.fromNumericValue(4));
        assertEquals(WindowInterface.KEY.NUM_5, WindowInterface.KEY.fromNumericValue(5));
        assertEquals(WindowInterface.KEY.NUM_6, WindowInterface.KEY.fromNumericValue(6));
        assertEquals(WindowInterface.KEY.NUM_7, WindowInterface.KEY.fromNumericValue(7));
        assertEquals(WindowInterface.KEY.NUM_8, WindowInterface.KEY.fromNumericValue(8));
        assertEquals(WindowInterface.KEY.NUM_9, WindowInterface.KEY.fromNumericValue(9));
    }

    @Test
    void drawTextWithFontSizeTest() {
        Position position = new Position(10, 10);
        String text = "Test";
        String color = "YELLOW";
        int fontSize = 2;

        window.drawTextWithFontSize(position, text, color, fontSize);

        verify(tg, times(1)).setForegroundColor(TextColor.Factory.fromString(color));
    }

    @Test
    public void testProcessKey_qKey_shouldReturnQuit() throws IOException {
        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('q');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);


        assertEquals(WindowInterface.KEY.QUIT, window.processKey());
    }

    @Test
    public void testProcessKey_mKey_shouldReturnM() throws IOException {
        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('m');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.M, window.processKey());
    }

    @Test
    public void testProcessKey_cKey_shouldReturnC() throws IOException {
        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('c');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.C, window.processKey());
    }

    @Test
    public void testProcessKey_aKey_shouldReturnA() throws IOException {
        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('a');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.A, window.processKey());
    }

    @Test
    public void testProcessKey_uKey_shouldReturnU() throws IOException {
        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('u');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.U, window.processKey());
    }

    @Test
    public void testProcessKey_arrowKey_shouldReturnAppropriateKey() throws IOException {
        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowUp);
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.UP, window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowDown);
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.DOWN, window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowRight);
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.RIGHT, window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.ArrowLeft);
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.LEFT, window.processKey());
    }

    @Test
    public void testProcessKey_numericKey_shouldReturnAppropriateKey() throws IOException {
        KeyStroke keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('1');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.fromNumericValue(1), window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('2');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.fromNumericValue(2), window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('3');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.fromNumericValue(3), window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('4');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.fromNumericValue(4), window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('5');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.fromNumericValue(5), window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('6');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.fromNumericValue(6), window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('7');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.fromNumericValue(7), window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('8');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.fromNumericValue(8), window.processKey());

        keyStroke = mock(KeyStroke.class);
        when(keyStroke.getKeyType()).thenReturn(KeyType.Character);
        when(keyStroke.getCharacter()).thenReturn('9');
        when(window.getScreen().pollInput()).thenReturn(keyStroke);

        assertEquals(WindowInterface.KEY.fromNumericValue(9), window.processKey());

    }
}