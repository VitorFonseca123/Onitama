package onitama;


import org.junit.Assert;
import org.junit.Test;

public class CardTest {
    Position[] positions = {new Position(-2, 0), new Position(1, 0)};
    Card card = new Card("Tiger", Color.BLUE, positions);
    @Test
    public void testConstructor() {

        String name = "Dragon";
        Color color = Color.BLUE;
        Position[] positions = {new Position(-2, 0), new Position(1, 0)};

        Card card = new Card(name, color, positions);

        Assert.assertEquals(name, card.getName());
        Assert.assertEquals(color, card.getColor());
        Assert.assertArrayEquals(positions, card.getPosition());
    }
    @Test
    public void testGetName() {
        Assert.assertEquals("Tiger", card.getName());
    }
    @Test
    public void testGetColor() {
        Assert.assertEquals(Color.BLUE, card.getColor());
    }
    @Test
    public void testGetPosition() {

        Assert.assertArrayEquals(positions, card.getPosition());
    }
    @Test
    public void testCreateCards() {

        Card[] cards = Card.createCards();
        Assert.assertEquals(5, cards.length);
        Card cardVerif = null;
        Assert.assertNotNull(cards);
        for (Card card:cards) {
            Assert.assertNotEquals(cardVerif, card);
            cardVerif = card;

        }
    }
}
