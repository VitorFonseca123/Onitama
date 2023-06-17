package onitama;

import org.junit.Assert;
import org.junit.Test;


public class PositionTest {

    @Test
    public void getRow() {
        Position position = new Position(2, 3);
        int row = 2;
        Assert.assertEquals(row, position.getRow());

    }

    @Test
    public void getCol() {
        Position position = new Position(2, 3);
        int col = 3;
        Assert.assertEquals(col, position.getCol());

    }
}