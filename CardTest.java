package onitama;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    Position[] positions = {new Position(-2, 0), new Position(1, 0)};
    Card card = new Card("Tiger", Color.BLUE, positions);
    @Test
    public void testConstructor() {

        String name = "Dragon";
        Color color = Color.BLUE;
        Position[] positions = {new Position(-2, 0), new Position(1, 0)};

        Card card = new Card(name, color, positions);

        Assertions.assertEquals(name, card.getName());
        Assertions.assertEquals(color, card.getColor());
        Assertions.assertArrayEquals(positions, card.getPosition());
    }
    @Test
    public void testGetName() {
        assertEquals("Tiger", card.getName());
    }
    @Test
    public void testGetColor() {
        assertEquals(Color.BLUE, card.getColor());
    }
    @Test
    public void testGetPosition() {

        assertArrayEquals(positions, card.getPosition());
    }
    @Test
    public void testCreateCards() {

        Card[] cards = Card.createCards();
        assertEquals(5, cards.length);
        Card cardVerif = null;
        assertNotNull(cards);
        for (Card card:cards) {
            assertNotEquals(cardVerif, card);
            cardVerif = card;

        }
    }
}
