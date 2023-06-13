package onitama;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class PieceTest {
    private Piece piece1 = new Piece(Color.RED, true);
    private Piece piece2 = new Piece(Color.BLUE, false);

    @Test
    public void getColorTest(){
        assertEquals(Color.RED, piece1.getColor());
        assertEquals(Color.BLUE, piece2.getColor());
    }
    @Test
    public void testIsMaster() {
        assertTrue(piece1.isMaster());
        assertFalse(piece2.isMaster());
    }
}
