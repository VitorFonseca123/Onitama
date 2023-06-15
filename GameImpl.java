
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
    //private Piece[] RedPieces;
    //private Piece[] BluePieces;
  
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
        if(allCards.size() < 5) throw new IllegalArgumentException("Deck possuí menos que 5 cartas");
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
    public void makeMove(Card card, Position cardMove, Position currentPos) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException{
        int col = currentPos.getCol();
        int row = currentPos.getRow();
        Piece temp = board.getSpot()[row][col].getPiece();
        if (temp == null) {
            throw new InvalidPieceException("Não há peça para mover");
        }
        boolean moveValid = false;
        for (Position i : card.getPosition()) {
            col = currentPos.getCol() + i.getCol();
            row = currentPos.getRow() + i.getRow();
            if (col == cardMove.getCol() && row == cardMove.getRow()) {
                moveValid = true;
            }
        }
        if (!moveValid) {
            throw new IllegalMovementException("Movimento não descrito na carta utilizada");
        }
        if (cardMove.getRow() >= 5 || cardMove.getCol() >= 5) {
            throw new IllegalMovementException("Movimento para fora do tabuleiro");
        }
        if (Turn) {
            if (temp.getColor().equals(Color.RED)) {
                throw new IncorrectTurnOrderException("Movendo peça vermelha no turno do azul");
            }
            if (BluePlayer.getCards()[0].equals(card) || BluePlayer.getCards()[1].equals(card)){
            } else {
                throw new InvalidCardException("Utilizando uma carta que não está na mão do Jogador");
            }
            BluePlayer.swapCard(card, TableCard);
            TableCard = card;
            Turn = false;
        } else {
            if (temp.getColor().equals(Color.BLUE)) {
                throw new IncorrectTurnOrderException("Movendo peça azul no turno do vermelho");
            }
            if (RedPlayer.getCards()[0].equals(card) || RedPlayer.getCards()[1].equals(card)){
            } else {
                throw new InvalidCardException("Utilizando uma carta que não está na mão do Jogador");
            }
            RedPlayer.swapCard(card, TableCard);
            TableCard = card;
            Turn = true;
        }
        row = cardMove.getRow();
        col = cardMove.getCol();
        board.getSpot()[row][col].occupySpot​(board.getSpot()[currentPos.getRow()][currentPos.getCol()].getPiece());
        board.getSpot()[currentPos.getRow()] [currentPos.getCol()].releaseSpot();
    }
    public void checkVictory(Color color){//mudar pra boolean

    }
    public void printBoard(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                Piece p = board.getSpot()[i][j].getPiece();
                if (p != null) {

                    if((p.getColor()).equals(Color.BLUE) && p.isMaster()) System.out.print("|MB|");
                    if((p.getColor()).equals(Color.BLUE) && !p.isMaster()) System.out.print("|PB|");
                    if((p.getColor()).equals(Color.RED) && p.isMaster()) System.out.print("|MR|");
                    if((p.getColor()).equals(Color.RED) && !p.isMaster()) System.out.print("|PR|");

                } else System.out.print("|00|");



            }
            System.out.println("");
        }
    }
}
