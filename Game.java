package onitama;

public interface Game {
     
    Color getSpotColor(Position position);
    Piece getPiece(Position position);
    Card getTableCard();
    Player getRedPlayer();
    Player getBluePlayer();
    void makeMove(Piece piece, Card card, Position position) throws IncorrectTurnOrderException, IllegalMovementException, InvalidCardException, InvalidPieceException;
    boolean checkVictory(Color color);
    //void printBoard();
}
