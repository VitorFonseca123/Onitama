package onitama;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

class GameImplTest {
    Position[] Tiger = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
    Position[] Dragon = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
    Position[] Frog = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
    Position[] Rabbit = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
    Position[] Crab = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
    Card [] cartasTeste = new Card[] {
            new Card("Tiger",Color.BLUE ,Tiger),
            new Card("Dragon",Color.BLUE ,Dragon),
            new Card("Frog",Color.BLUE ,Frog),
            new Card("Rabbit", Color.BLUE, Rabbit),
            new Card("Crab", Color.BLUE, Crab)
    };
    Card [] cartasTeste2 = new Card[] {
            new Card("Tiger",Color.RED ,Tiger),
            new Card("Dragon",Color.RED ,Dragon),
            new Card("Frog",Color.RED ,Frog),
            new Card("Rabbit", Color.RED, Rabbit),
            new Card("Crab", Color.RED, Crab)
    };
    GameImpl game = new GameImpl();
    GameImpl game2 = new GameImpl("Red","Blue");
    GameImpl gameBlue = new GameImpl("Red", "Blue", cartasTeste);
    GameImpl gameRed = new GameImpl("Red", "Blue", cartasTeste2);
    private Board TestBoard;

    @Before
    public void setup() {
        TestBoard = new Board();
    }

    @Test
    void getSpotColorTest() {
        for(int row=0; row<5;row++){
            for(int col=0;col<5;col++){
                Spot spots1 = game.getBoard().getSpot()[row][col];
                if(spots1.getColor() != null){
                    if(row == 0 && col == 2) Assert.assertEquals(game.getSpotColor(new Position(row, col)), Color.BLUE);
                    if(row == 4 && col == 2)Assert.assertEquals(game.getSpotColor(new Position(row, col)), Color.RED);
                }else Assert.assertNull(game.getSpotColor(new Position(row, col)));
            }
        }
    }



    @Test
    void getPiece() {
        for(int row=0; row<5;row++){
            for(int col=0;col<5;col++){
                Piece piece = game2.getBoard().getSpot()[row][col].getPiece();
                if(piece != null) Assert.assertEquals(game2.getPiece(new Position(row, col)), piece);
                else  Assert.assertNull(game2.getPiece(new Position(row, col)));
            }
        }

    }

    @Test
    void getTableCard() {
        boolean diferente = true;
        Card red[] = gameBlue.getRedPlayer().getCards();
        Card blue[] = gameBlue.getBluePlayer().getCards();
        for(Card cards : red){
            if(cards == game.getTableCard())diferente = false;
        }
        for(Card cards : blue){
            if(cards == game.getTableCard())diferente = false;
        }
        Assert.assertTrue(diferente);

    }

    @Test
    void getRedPlayer() {
        Assert.assertNotEquals(gameRed.getRedPlayer().getName(), "Blue");
        Assert.assertNull(game.getRedPlayer().getName());
    }

    @Test
    void getBluePlayer() {
        Assert.assertEquals(gameBlue.getBluePlayer().getName(), "Blue");
        Assert.assertNotEquals(gameBlue.getBluePlayer().getName(), "Red");
        Assert.assertNull(game.getBluePlayer().getName());
    }

    @Test
    void makeMoveIncorrectTurnOrderException() {
        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        Assert.assertThrows(IncorrectTurnOrderException.class, ()
                -> gameBlue.makeMove(redCard,redCard.getPosition()[0], new Position(4,0)));

        Player blue = gameRed.getBluePlayer();
        Card blueCard = blue.getCards()[0];
        Assert.assertThrows(IncorrectTurnOrderException.class, ()
                -> gameRed.makeMove(blueCard,blueCard.getPosition()[1], new Position(0,0)));

    }
    @Test
    void makeMoveIllegalMovementException() {
        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        Assert.assertThrows(IllegalMovementException.class, ()
                -> gameRed.makeMove(redCard,redCard.getPosition()[1], new Position(4,0)));
        Assert.assertThrows(IllegalMovementException.class, ()
                -> gameRed.makeMove(redCard,new Position(4,0), new Position(4,0)));

    }
    @Test
    void makeMoveInvalidCardException() {
        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        Player blue = gameRed.getBluePlayer();
        Card blueCard = blue.getCards()[0];

        Assert.assertThrows(InvalidCardException.class, ()
                -> gameRed.makeMove(blueCard,blueCard.getPosition()[0], new Position(4,0)));
        Assert.assertThrows(InvalidCardException.class, ()
                -> gameBlue.makeMove(redCard,redCard.getPosition()[1], new Position(0,0)));

    }
    @Test
    void makeMoveInvalidPieceException() {

        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        Assert.assertThrows(InvalidPieceException.class, ()
                -> gameRed.makeMove(redCard,redCard.getPosition()[0], new Position(2,2)));

    }
    @Test
    void makeMove() {
        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        Card troca = gameRed.getTableCard();
        gameRed.makeMove(redCard,redCard.getPosition()[0], new Position(4,0));
        Assert.assertEquals(gameRed.getTableCard(), redCard);
        Assert.assertEquals(red.getCards()[0], troca);

        Player blue = gameBlue.getBluePlayer();
        Card blueCard = blue.getCards()[0];
        troca = gameBlue.getTableCard();
        gameBlue.makeMove(blueCard,blueCard.getPosition()[1], new Position(0,0));
        Assert.assertEquals(gameBlue.getTableCard(), blueCard);
        Assert.assertEquals(blue.getCards()[0], troca);

        Assert.assertNotNull(gameBlue.getBoard().getSpot()[1][0].getPiece());
        Assert.assertNull(gameBlue.getBoard().getSpot()[0][0].getPiece());
    }

    @Test
    void checkVictoryMasterRedKillBlue() {
        Player red = gameRed.getRedPlayer();
        Player blue = gameRed.getBluePlayer();

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,2));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,2));
        Assert.assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(3,2));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,0));
        Assert.assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(2,2));
        Assert.assertTrue(gameRed.checkVictory(red.getPieceColor()));
    }

    @Test
    void checkVictoryMasterBlueKillRed() {
        Player red = gameRed.getRedPlayer();
        Player blue = gameRed.getBluePlayer();

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,2));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,2));
        Assert.assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(3,2));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(1,2));
        Assert.assertTrue(gameRed.checkVictory(blue.getPieceColor()));
    }

    @Test
    void checkVictoryMasterRedOnTempleBlue() {
        Player red = gameRed.getRedPlayer();
        Player blue = gameRed.getBluePlayer();

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,2));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,2));
        Assert.assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(3,2));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(0,1), new Position(1,2));
        Assert.assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(2,2));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(0,1), new Position(1,3));
        Assert.assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(1,2));
        Assert.assertTrue(gameRed.checkVictory(red.getPieceColor()));
    }

    @Test
    void checkVictoryMasterBlueOnTempleRed() {
        Player red = gameRed.getRedPlayer();
        Player blue = gameRed.getBluePlayer();

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,2));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,2));
        Assert.assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(0,1) ,new Position(3,2));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(1,2));
        Assert.assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,4));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(2,2));
        Assert.assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,0));
        Assert.assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(3,2));
        Assert.assertTrue(gameRed.checkVictory(blue.getPieceColor()));
    }
}