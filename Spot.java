package onitama;

/**
 *
 * @author vitor
 */
public class Spot {
    private Piece piece;
    private Position pos;
    private Color color;

    public Spot(Position pos) {
        this.pos = pos;
    }

    public Spot(Piece piece, Position pos) {
        this.piece = piece;
        this.pos = pos;
    }

    public Spot(Piece piece, Position pos, Color color) {
        this.piece = piece;
        this.pos = pos;
        this.color = color;
    }

    public Piece getPiece() {
        return piece;
    }

    public Position getPos() {
        return pos;
    }

    public Color getColor() {
        return color;
    }
    
   
    protected void occupySpot​(Piece piece){
        
        
    }
    protected void releaseSpot(){
        piece = null;
        color = null;
    }
    
}
