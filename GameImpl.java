
package onitama;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameImpl {
    private final String redPlayer;
    private final String bluePlayer;
    public Card[] deck;
    private  Board board;
    private  Card TableCard;
    private Player RedPlayer;
    private Player BluePlayer;
    private boolean Turn; //false=red,true = blue;
    private Piece[] RedPieces;
    private Piece[] BluePieces;
  
    public GameImpl() {
        this.redPlayer = "";
        this.bluePlayer = ""; //deixar sem nada ou construir com nome vazio?
        this.deck = Card.createCards();
        distributeCards();
        //if (TableCard.getColor() == Color.BLUE) Turn = true; else Turn = false;
        board = new Board();
    }
    public GameImpl(String redPlayer, String bluePlayer) {
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
        this.deck = Card.createCards();
        distributeCards();
        if (TableCard.getColor() == Color.BLUE) Turn = true; else Turn = false;
        board = new Board();
    }
    public GameImpl(String redPlayer, String bluePlayer, Card[] newDeck) {
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
        List<Card> allCards = Arrays.asList(newDeck);
        Collections.shuffle(allCards);
        this.deck = allCards.subList(0, 5).toArray(new Card[5]);
        distributeCards();
        if (TableCard.getColor() == Color.BLUE) Turn = true; else Turn = false;
        board = new Board();
    }
    private void distributeCards(){
        Card[] redPlayerCards = drawCardsFromDeck(2);
        RedPlayer = new Player(this.redPlayer, Color.Red, redPlayerCards);

        Card[] bluePlayerCards = drawCardsFromDeck(2);
        BluePlayer = new Player(this.bluePlayer, Color.Blue, bluePlayerCards);

       List<Card> draw = Arrays.asList(deck);
        this.TableCard = draw.get(0);
    }
    private Card[] drawCardsFromDeck(int numCards) {
        List<Card> draw = new ArrayList<>(Arrays.asList(deck));
        List<Card> subList = draw.subList(0, numCards);
        Card[] cardArray = subList.toArray(new Card[subList.size()]);
        draw.removeAll(subList);
        deck = draw.toArray(new Card[draw.size()]);
        return cardArray;
    }
    
    public Color getSpotColor(Position position){
       
        Spot[][] spot = board.getSpot();
        return spot[position.getRow()][position.getCol()].getColor();
    }
    
    public Piece getPiece(Position position){
        Spot[][] spot = board.getSpot();
        return spot[position.getRow()][position.getCol()].getPiece();
    }
    public Card getTableCard() {
        return TableCard;
    }

    public Player getRedPlayer(){
        return this.RedPlayer;
    }
    public Player getBluePlayer(){
        return this.BluePlayer;
    }
   public void makeMove(Piece piece, Card card, Position position) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException{

    }
    /*public boolean checkVictory(Color color){

    }*/
}
