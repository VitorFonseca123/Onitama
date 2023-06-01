package onitama;

/**
 *
 * @author vitor
 */
public class GameImp {
    private Player redPlayer;
    private Player bluePlayer;
    private Card tableCard;

    public GameImp(Player redPlayer, Player bluePlayer, Card tableCard) {
        this.redPlayer = redPlayer;
        this.bluePlayer = bluePlayer;
        this.tableCard = tableCard;
    }
    Color getSpotColor(Position position){
        Board board = new Board();
        Spot[][] spot = board.getSpot();
        return spot[position.getRow()][position.getCol()].getColor();
    }
        
    
    
}
