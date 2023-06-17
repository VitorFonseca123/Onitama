package onitama;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



class SpotTest {
    private Piece pieces;
    private Piece piece2;
    Position positions;
    private Spot spotVazio;
    private Spot spotPiece;
    private  Spot spotBase;

    @Before
    public void setup() {
        pieces = new Piece(Color.BLUE, false);
        piece2 = new Piece(Color.RED, false);
        positions = new Position(0,0);
        spotVazio = new Spot(positions);
        spotPiece = new Spot(pieces, positions);
        spotBase = new Spot(pieces, positions, Color.BLUE);
    }
    @Test
    void testConstructor_Spot() {
        Position expectedPosition = new Position(1, 1);
        Spot spot = new Spot(expectedPosition);

        Assert.assertEquals(expectedPosition,spot.getPos());
        Assert.assertNull(spot.getPiece());
        Assert.assertNull(spot.getColor());
    }
    @Test
    void testConstructor_SpotWithPiece() {
        Position expectedPosition = new Position(1, 1);
        Piece expectedPiece = new Piece(Color.BLUE, false);
        Spot spot = new Spot(expectedPiece,expectedPosition);

        Assert.assertEquals(expectedPosition,spot.getPos());
        Assert.assertEquals(expectedPiece,spot.getPiece());
        Assert.assertNull(spot.getColor());
    }
    @Test
    void testConstructor_SpotWithBase() {
        Position expectedPosition = new Position(1, 1);
        Piece expectedPiece = new Piece(Color.BLUE, false);
        Color expectedColor = Color.RED;
        Spot spot = new Spot(expectedPiece,expectedPosition,expectedColor);

        Assert.assertEquals(expectedPosition,spot.getPos());
        Assert.assertEquals(expectedPiece,spot.getPiece());
        Assert.assertEquals(expectedColor, spot.getColor());
    }
    @Test
    void getPiece() {
        Piece p = new Piece(Color.RED, true);
        Assert.assertNotEquals(p, spotPiece.getPiece());
        Assert.assertNotEquals(p, spotBase.getPiece());
        Assert.assertNull(spotVazio.getPiece());

        Assert.assertEquals(pieces, spotPiece.getPiece());
        Assert.assertEquals(pieces, spotBase.getPiece());

    }

    @Test
    void getPos() {
        Assert.assertEquals(positions, spotVazio.getPos());
        Assert.assertEquals(positions, spotBase.getPos());
        Assert.assertEquals(positions, spotPiece.getPos());
        Position fakePosition = new Position(1,1);
        Assert.assertNotEquals(fakePosition, spotVazio.getPos());
        Assert.assertNotEquals(fakePosition, spotBase.getPos());
        Assert.assertNotEquals(fakePosition, spotPiece.getPos());

    }

    @Test
    void getColor() {
        Assert.assertNull(spotVazio.getColor());
        Assert.assertNull(spotPiece.getColor());
        Assert.assertEquals(Color.BLUE, spotBase.getColor());
    }

    @Test
    void occupySpotPiece() {
        spotPiece.occupySpot(piece2);
        Assert.assertNotNull(spotPiece.getPiece());
        Assert.assertEquals(piece2, spotPiece.getPiece());
        Assert.assertThrows(IllegalMovementException.class, () -> spotPiece.occupySpot(piece2));
    }
    @Test
    void occupySpotBase() {
        spotBase.occupySpot(piece2);
        Assert.assertNotNull(spotBase.getPiece());
        Assert.assertEquals(piece2, spotBase.getPiece());
        Assert.assertThrows(IllegalMovementException.class, () -> spotBase.occupySpot(piece2));
    }
    @Test
    void occupySpotVazio() {
        spotVazio.occupySpot(piece2);
        Assert.assertNotNull(spotVazio.getPiece());
        Assert.assertEquals(piece2, spotVazio.getPiece());
        Assert.assertThrows(IllegalMovementException.class, () -> spotVazio.occupySpot(piece2));
    }

    @Test
    void releaseSpotBase() {
        spotBase.releaseSpot();
        Assert.assertNull(spotBase.getPiece());
    }
    @Test
    void releaseSpotPiece() {
        spotPiece.releaseSpot();
        Assert.assertNull(spotPiece.getPiece());
    }

}