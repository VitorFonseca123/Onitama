package onitama;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void getRow() {
        Position position = new Position(2, 3);
        int row = 2;
        assertEquals(row, position.getRow());

    }

    @Test
    public void getCol() {
        Position position = new Position(2, 3);
        int col = 3;
        assertEquals(col, position.getCol());

    }
}