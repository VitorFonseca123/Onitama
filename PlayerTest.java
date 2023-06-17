package onitama;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    private Player player;
    private Card[] cards;
    private Card TableCard;

    @Before
    public void setup() {
        Position[] Tiger = {new Position(-2, 0), new Position(1, 0)};
        Position[] Dragon = {new Position(1, -2), new Position(1, 2), new Position(1, -1),  new Position(1, 1)};
        cards = new Card[] {
                new Card("Tiger", Color.BLUE, Tiger),
                new Card("Dragon", Color.RED, Dragon)
        };
        player = new Player("Player 1", Color.RED, cards);
        Position[] errada = {new Position(0, 0), new Position(0, 0)};
        TableCard = new Card("Errada",Color.RED, errada);
    }
    @Test
    public void testConstructor1() {
        String name = "John";
        Color pieceColor = Color.RED;
        Card[] cards = new Card[]{
                new Card("Tiger",Color.BLUE ,new Position[]{}),
                new Card("Dragon",Color.RED ,new Position[]{})};

        Player player2 = new Player(name, pieceColor, cards);

        Assert.assertEquals(name, player2.getName());
        Assert.assertEquals(pieceColor, player2.getPieceColor());
        Assert.assertEquals(cards[0], player2.getCards()[0]);
        Assert.assertEquals(cards[1], player2.getCards()[1]);
    }
    @Test
    public void testConstructor2() {
        String name = "John";
        Color pieceColor = Color.RED;
        Card card1 = new Card("Tiger", Color.BLUE, new Position[]{});
        Card card2 = new Card("Dragon", Color.RED, new Position[]{});

        Player player2 = new Player(name, pieceColor, card1, card2);

        Assert.assertEquals(name, player2.getName());
        Assert.assertEquals(pieceColor, player2.getPieceColor());
        Assert.assertEquals(card1, player2.getCards()[0]);
        Assert.assertEquals(card2, player2.getCards()[1]);
    }
    @Test
    public void testGetName() {
        Assert.assertEquals("Player 1", player.getName());
    }
    @Test
    public void testGetPieceColor() {
        Assert.assertEquals(Color.RED, player.getPieceColor());
    }

    @Test
    public void testGetCards() {
        Card[] expectedCards = {cards[0], cards[1]};
        Assert.assertArrayEquals(expectedCards, player.getCards());
    }
    @Test
    public void testSwapCard() throws InvalidCardException {
        player.swapCard(cards[0], TableCard);

        Card[] expectedCards = {TableCard, cards[1]};
        Assert.assertArrayEquals(expectedCards, player.getCards());
    }
    @Test
    public void testSwapCardWithSameCards()throws InvalidCardException {

        Assert.assertThrows(InvalidCardException.class, () -> player.swapCard(cards[0], cards[0]));

        Card[] expectedCards = {cards[0], cards[1]};
        Assert.assertArrayEquals(expectedCards, player.getCards());
    }
    @Test
    public void testSwapCardWithCardsInHand()throws InvalidCardException {
        Assert.assertThrows(InvalidCardException.class, () -> player.swapCard(cards[0], cards[1]));

        Card[] expectedCards = {cards[0], cards[1]};
        Assert.assertArrayEquals(expectedCards, player.getCards());
    }
    @Test
    public void testSwapCardWithHandContainsNewCard()throws InvalidCardException {

        Assert.assertThrows(InvalidCardException.class, () -> player.swapCard(TableCard, TableCard));

        Card[] expectedCards = {cards[0], cards[1]};
        Assert.assertArrayEquals(expectedCards, player.getCards());
    }




}