package onitama;


import org.junit.Assert;
import org.junit.Test;

public class PieceTest {
    private Piece piece1 = new Piece(Color.RED, true);
    private Piece piece2 = new Piece(Color.BLUE, false);

    @Test
    public void testConstructor() {
        // Arrange
        Color color = Color.BLUE;
        boolean isMaster = false;

        Piece piece = new Piece(color, isMaster);

        Assert.assertEquals(color, piece.getColor());
        Assert.assertEquals(isMaster, piece.isMaster());
    }
    @Test
    public void getColorTest(){
        Assert.assertEquals(Color.RED, piece1.getColor());
        Assert.assertEquals(Color.BLUE, piece2.getColor());
    }
    @Test
    public void testIsMaster() {
        Assert.assertTrue(piece1.isMaster());
        Assert.assertFalse(piece2.isMaster());
    }
}
