package onitama;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
                    if(row == 0 && col == 2)assertEquals(game.getSpotColor(new Position(row, col)), Color.BLUE);
                    if(row == 4 && col == 2)assertEquals(game.getSpotColor(new Position(row, col)), Color.RED);
                }else assertNull(game.getSpotColor(new Position(row, col)));
            }
        }
    }



    @Test
    void getPiece() {
        for(int row=0; row<5;row++){
            for(int col=0;col<5;col++){
                Piece piece = game2.getBoard().getSpot()[row][col].getPiece();
                if(piece != null)assertEquals(game2.getPiece(new Position(row, col)), piece);
                else assertNull(game2.getPiece(new Position(row, col)));
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
        assertTrue(diferente);

    }

    @Test
    void getRedPlayer() {
        assertNotEquals(gameRed.getRedPlayer().getName(), "Blue");
        assertNull(game.getRedPlayer().getName());
    }

    @Test
    void getBluePlayer() {
        assertEquals(gameBlue.getBluePlayer().getName(), "Blue");
        assertNotEquals(gameBlue.getBluePlayer().getName(), "Red");
        assertNull(game.getBluePlayer().getName());
    }

    @Test
    void makeMoveIncorrectTurnOrderException() {
        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        assertThrows(IncorrectTurnOrderException.class, ()
                -> gameBlue.makeMove(redCard,redCard.getPosition()[0], new Position(4,0)));

        Player blue = gameRed.getBluePlayer();
        Card blueCard = blue.getCards()[0];
        assertThrows(IncorrectTurnOrderException.class, ()
                -> gameRed.makeMove(blueCard,blueCard.getPosition()[1], new Position(0,0)));

    }
    @Test
    void makeMoveIllegalMovementException() {
        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        assertThrows(IllegalMovementException.class, ()
                -> gameRed.makeMove(redCard,redCard.getPosition()[1], new Position(4,0)));
        assertThrows(IllegalMovementException.class, ()
                -> gameRed.makeMove(redCard,new Position(4,0), new Position(4,0)));

    }
    @Test
    void makeMoveInvalidCardException() {
        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        Player blue = gameRed.getBluePlayer();
        Card blueCard = blue.getCards()[0];

        assertThrows(InvalidCardException.class, ()
                -> gameRed.makeMove(blueCard,blueCard.getPosition()[0], new Position(4,0)));
        assertThrows(InvalidCardException.class, ()
                -> gameBlue.makeMove(redCard,redCard.getPosition()[1], new Position(0,0)));

    }
    @Test
    void makeMoveInvalidPieceException() {

        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        assertThrows(InvalidPieceException.class, ()
                -> gameRed.makeMove(redCard,redCard.getPosition()[0], new Position(2,2)));

    }
    @Test
    void makeMove() {
        Player red = gameRed.getRedPlayer();
        Card redCard = red.getCards()[0];
        Card troca = gameRed.getTableCard();
        gameRed.makeMove(redCard,redCard.getPosition()[0], new Position(4,0));
        assertEquals(gameRed.getTableCard(), redCard);
        assertEquals(red.getCards()[0], troca);

        Player blue = gameBlue.getBluePlayer();
        Card blueCard = blue.getCards()[0];
        troca = gameBlue.getTableCard();
        gameBlue.makeMove(blueCard,blueCard.getPosition()[1], new Position(0,0));
        assertEquals(gameBlue.getTableCard(), blueCard);
        assertEquals(blue.getCards()[0], troca);

        assertNotNull(gameBlue.getBoard().getSpot()[1][0].getPiece());
        assertNull(gameBlue.getBoard().getSpot()[0][0].getPiece());
    }

    @Test
    void checkVictoryMasterRedKillBlue() {
        Player red = gameRed.getRedPlayer();
        Player blue = gameRed.getBluePlayer();

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,2));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(3,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,0));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(2,2));
        assertTrue(gameRed.checkVictory(red.getPieceColor()));
    }

    @Test
    void checkVictoryMasterBlueKillRed() {
        Player red = gameRed.getRedPlayer();
        Player blue = gameRed.getBluePlayer();

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,2));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(3,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(1,2));
        assertTrue(gameRed.checkVictory(blue.getPieceColor()));
    }

    @Test
    void checkVictoryMasterRedOnTempleBlue() {
        Player red = gameRed.getRedPlayer();
        Player blue = gameRed.getBluePlayer();

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,2));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(3,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(0,1), new Position(1,2));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(2,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(0,1), new Position(1,3));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(1,2));
        assertTrue(gameRed.checkVictory(red.getPieceColor()));
    }

    @Test
    void checkVictoryMasterBlueOnTempleRed() {
        Player red = gameRed.getRedPlayer();
        Player blue = gameRed.getBluePlayer();

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(0,2));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(0,1) ,new Position(3,2));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(1,2));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,4));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(2,2));
        assertFalse(gameRed.checkVictory(blue.getPieceColor()));

        gameRed.makeMove(red.getCards()[0], new Position(-1,0) ,new Position(4,0));
        assertFalse(gameRed.checkVictory(red.getPieceColor()));

        gameRed.makeMove(blue.getCards()[0], new Position(1,0), new Position(3,2));
        assertTrue(gameRed.checkVictory(blue.getPieceColor()));
    }
}