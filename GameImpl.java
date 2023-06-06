
package onitama;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameImpl implements Game {
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
        if (TableCard.getColor() == Color.BLUE) Turn = true; else Turn = false;
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
        //this.deck = allCards.subList(0, 5).toArray(new Card[5]);
        this.deck = newDeck;
        distributeCards();
        if (TableCard.getColor() == Color.BLUE) Turn = true; else Turn = false;
        board = new Board();
    }

    public Board getBoard() {
        return board;
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
    public void checkVictory(Color color){//mudar pra boolean

    }
    public void printBoard(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                Piece p = board.getSpot()[i][j].getPiece();
                if (p != null) {

                    if((p.getColor()).equals(Color.BLUE) && p.isMaster()) System.out.print("|MB|");
                    if((p.getColor()).equals(Color.BLUE) && !p.isMaster()) System.out.print("|B|");
                    if((p.getColor()).equals(Color.RED) && p.isMaster()) System.out.print("|MR|");
                    if((p.getColor()).equals(Color.RED) && !p.isMaster()) System.out.print("|R|");

                } else System.out.print("|0|");



            }
            System.out.println("");
        }
    }
}
