package onitama;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpotTest {
    private Piece pieces;
    private Piece piece2;
    Position positions;
    private Spot spotVazio;
    private Spot spotPiece;
    private  Spot spotBase;

    @BeforeEach
    public void setup() {
        pieces = new Piece(Color.BLUE, false);
        piece2 = new Piece(Color.RED, false);
        positions = new Position(0,0);
        spotVazio = new Spot(positions);
        spotPiece = new Spot(pieces, positions);
        spotBase = new Spot(pieces, positions, Color.BLUE);
    }
    @Test
    void getPiece() {
        Piece p = new Piece(Color.RED, true);
        assertNotEquals(p, spotPiece.getPiece());
        assertNotEquals(p, spotBase.getPiece());
        assertNull(spotVazio.getPiece());

        assertEquals(pieces, spotPiece.getPiece());
        assertEquals(pieces, spotBase.getPiece());

    }

    @Test
    void getPos() {
        assertEquals(positions, spotVazio.getPos());
        assertEquals(positions, spotBase.getPos());
        assertEquals(positions, spotPiece.getPos());
        Position fakePosition = new Position(1,1);
        assertNotEquals(fakePosition, spotVazio.getPos());
        assertNotEquals(fakePosition, spotBase.getPos());
        assertNotEquals(fakePosition, spotPiece.getPos());

    }

    @Test
    void getColor() {
        assertNull(spotVazio.getColor());
        assertNull(spotPiece.getColor());
        assertEquals(Color.BLUE, spotBase.getColor());
    }

    @Test
    void occupySpotPiece() {
        spotPiece.occupySpot(piece2);
        assertNotNull(spotPiece.getPiece());
        assertEquals(piece2, spotPiece.getPiece());
        assertThrows(IllegalMovementException.class, () -> spotPiece.occupySpot(piece2));
    }
    @Test
    void occupySpotBase() {
        spotBase.occupySpot(piece2);
        assertNotNull(spotBase.getPiece());
        assertEquals(piece2, spotBase.getPiece());
        assertThrows(IllegalMovementException.class, () -> spotBase.occupySpot(piece2));
    }
    @Test
    void occupySpotVazio() {
        spotVazio.occupySpot(piece2);
        assertNotNull(spotVazio.getPiece());
        assertEquals(piece2, spotVazio.getPiece());
        assertThrows(IllegalMovementException.class, () -> spotVazio.occupySpot(piece2));
    }

    @Test
    void releaseSpotBase() {
        spotBase.releaseSpot();
        assertNull(spotBase.getPiece());
    }
    @Test
    void releaseSpotPiece() {
        spotPiece.releaseSpot();
        assertNull(spotPiece.getPiece());
    }

}