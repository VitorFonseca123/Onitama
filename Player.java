
package onitama;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player {
    private String name;
    private Color pieceColor;
    private Card[] cards;
    private Card card1;
    private Card card2;
    
    public Player(String name, Color pieceColor, Card[] cards) {
        this.name = name;
        this.pieceColor = pieceColor;
        this.cards = cards;
    }

    public Player(String name, Color pieceColor, Card card1, Card card2) {
        this.name = name;
        this.pieceColor = pieceColor;
        this.card1 = card1;
        this.card2 = card2;
    }

    public String getName() {
        return name;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public Card[] getCards() {
        return cards;
    }
    
    protected void swapCard(Card oldCard, Card newCard) throws InvalidCardException{
           List<Card> Hand = new ArrayList<>(Arrays.asList(cards));
           if(!Hand.contains(oldCard)) throw new InvalidCardException("OldCard não está na mão do jogador");
           if (!Hand.contains(newCard)) throw new InvalidCardException("NewCard já está na mão do jogador");

           //como eu sei a carta da mesa?

         /* if(Hand.contains(oldCard) && !Hand.contains(newCard)){
              
          }*/
    }
    
    
}
