package onitama;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Card {
    private String name;
    private Color color;
    private Position[] position;
    
    private static final int TOTAL_CARDS = 8;
    private static final int CARDS_IN_GAME = 5;
    
    public Card(String name, Color color, Position[] position) {
        this.name = name;
        this.color = color;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public Position[] getPosition() {
        return position;
    }
    
     public static Card[] createCards() {
         
         Position[] Tiger = {new Position(-2, 0), new Position(1, 0)};
         Position[] Dragon = {new Position(1, -2), new Position(1, 2), new Position(1, -1),  new Position(1, 1)};
         Position[] Frog = {new Position(1, 1), new Position(-1, -1), new Position(-2, 0)};
         Position[] Rabbit = {new Position(-1, -1), new Position(-1, 1), new Position(2, 0)};
         Position[] Crab = {new Position(-1, 0), new Position(2, 0), new Position(-2, 0)};
         Position[] Elephant = {new Position(-1, 0), new Position(1, 0), new Position(-1, -1), new Position(-1, 1)};
         Position[] Goose = {new Position(0, -1), new Position(-1, -1), new Position(0, 1),  new Position(1, 1)};
         Position[] Rooster = {new Position(0, -1), new Position(1, -1), new Position(0, 1),  new Position(-1, 1)};
         
         Card[] cards = new Card[]{
             new Card("Tiger",Color.BLUE ,Tiger),
             new Card("Dragon",Color.RED ,Dragon),

             new Card("Frog",Color.RED ,Frog),

             new Card("Rabbit", Color.BLUE, Rabbit),
             new Card("Crab", Color.BLUE, Crab),
             new Card("Elephant", Color.RED, Elephant),
             new Card("Goose", Color.BLUE, Goose),
             new Card("Rooster", Color.RED, Rooster),
         };
         List<Card> allCards = Arrays.asList(cards);
         Collections.shuffle(allCards);
         //allCards.toArray(cards);
         
         return  allCards.subList(0, CARDS_IN_GAME).toArray(new Card[CARDS_IN_GAME]);
     }
    
}
