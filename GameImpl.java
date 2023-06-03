
package onitama;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameImpl implements Game{
    private String redPlayer;
    private String bluePlayer;
    public static Card[] deck; //se eu deixar público posso acessar o deck de fora, mas é ideal?
    private Board board;
    public Card TableCard;
    private Player RedPlayer;
    private Player BluePlayer;
  
    public GameImpl() {
        this.redPlayer = "";
        this.bluePlayer = ""; //deixar sem nada ou construir com nome vazio?
        this.deck = Card.createCards();

        Card[] redPlayerCards = drawCardsFromDeck(2);
        RedPlayer = new Player(this.redPlayer, Color.Red, redPlayerCards);

        Card[] bluePlayerCards = drawCardsFromDeck(2);
        BluePlayer = new Player(this.bluePlayer, Color.Blue, bluePlayerCards);

        List<Card> draw = Arrays.asList(deck);
        this.TableCard = draw.get(0);

        board = new Board();
    }
    public GameImpl(String redPlayer, String bluePlayer) {
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
        this.deck = Card.createCards();

        Card[] redPlayerCards = drawCardsFromDeck(2);
        RedPlayer = new Player(this.redPlayer, Color.Red, redPlayerCards);

        Card[] bluePlayerCards = drawCardsFromDeck(2);
        BluePlayer = new Player(this.bluePlayer, Color.Blue, bluePlayerCards);

        List<Card> draw = Arrays.asList(deck);
        this.TableCard = draw.get(0);
        board = new Board();
    }
    public GameImpl(String redPlayer, String bluePlayer, Card[] newDeck) {
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
        List<Card> allCards = Arrays.asList(newDeck);
        Collections.shuffle(allCards);
        this.deck = allCards.subList(0, 5).toArray(new Card[5]);

        Card[] redPlayerCards = drawCardsFromDeck(2);
        RedPlayer = new Player(this.redPlayer, Color.Red, redPlayerCards);

        Card[] bluePlayerCards = drawCardsFromDeck(2);
        BluePlayer = new Player(this.bluePlayer, Color.Blue, bluePlayerCards);

        List<Card> draw = Arrays.asList(deck);
        this.TableCard = draw.get(0);
        board = new Board();
    }
    private Card[] drawCardsFromDeck(int numCards) {
        List<Card> draw = Arrays.asList(deck);
        List<Card> subList = draw.subList(0, numCards);
        Card[] cardArray = subList.toArray(new Card[0]);
        draw.removeAll(subList);
        deck = draw.toArray(new Card[0]);
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
    public void getTableCard(){ //mudar para tipo Card
        for(Card card: deck){
            //pensei em olhar as cartas do deck e as cartas nas mãos do player, mas eu n tenho o objeto dos players
        }
    }
    public Player getRedPlayer(){

    }
    public Player getBluePlayer(){

    }
    void makeMove(Piece piece, Card card, Position position) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException{

    }
    boolean checkVictory(Color color){

    }
}
