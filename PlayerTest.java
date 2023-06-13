package onitama;



//import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {
    private Player player;
    private Card[] cards;
    private Card TableCard;

    @BeforeEach
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
    public void testConstructor() {
        String name = "John";
        Color pieceColor = Color.RED;
        Card card1 = new Card("Tiger", Color.BLUE, new Position[]{});
        Card card2 = new Card("Dragon", Color.RED, new Position[]{});

        Player player2 = new Player(name, pieceColor, card1, card2);

       assertEquals(name, player2.getName());
       assertEquals(pieceColor, player2.getPieceColor());
       assertEquals(card1, player2.getCards()[0]);
       assertEquals(card2, player2.getCards()[1]);
    }
    @Test
    public void testGetName() {
        Assertions.assertEquals("Player 1", player.getName());
    }
    @Test
    public void testGetPieceColor() {
        Assertions.assertEquals(Color.RED, player.getPieceColor());
    }

    @Test
    public void testGetCards() {
        Card[] expectedCards = {cards[0], cards[1]};
        Assertions.assertArrayEquals(expectedCards, player.getCards());
    }
    @Test
    public void testSwapCard() throws InvalidCardException {
        player.swapCard(cards[0], TableCard);

        Card[] expectedCards = {TableCard, cards[1]};
        Assertions.assertArrayEquals(expectedCards, player.getCards());
    }
    @Test
    public void testSwapCardWithSameCards()throws InvalidCardException {

        // Verifica se uma exceção InvalidCardException é lançada ao tentar realizar a troca com a carta inválida
        assertThrows(InvalidCardException.class, () -> player.swapCard(cards[0], cards[0]));

        // Verifica se as cartas do jogador permaneceram inalteradas após a tentativa de troca com uma carta inválida
        Card[] expectedCards = {cards[0], cards[1]};
        Assertions.assertArrayEquals(expectedCards, player.getCards());
    }
    @Test
    public void testSwapCardWithCardsInHand()throws InvalidCardException {

        // Verifica se uma exceção InvalidCardException é lançada ao tentar realizar a troca com a carta inválida
        assertThrows(InvalidCardException.class, () -> player.swapCard(cards[0], cards[1]));

        // Verifica se as cartas do jogador permaneceram inalteradas após a tentativa de troca com uma carta inválida
        Card[] expectedCards = {cards[0], cards[1]};
        Assertions.assertArrayEquals(expectedCards, player.getCards());
    }
    @Test
    public void testSwapCardWithHandContainsNewCard()throws InvalidCardException {

        // Verifica se uma exceção InvalidCardException é lançada ao tentar realizar a troca com a carta inválida
        assertThrows(InvalidCardException.class, () -> player.swapCard(TableCard, TableCard));

        // Verifica se as cartas do jogador permaneceram inalteradas após a tentativa de troca com uma carta inválida
        Card[] expectedCards = {cards[0], cards[1]};
        Assertions.assertArrayEquals(expectedCards, player.getCards());
    }




}