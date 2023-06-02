
package onitama;

/**
 *
 * @author vitor
 */
public class Piece {
    private Color color;
    boolean isMaster;
    boolean isAlive;

    public Piece(Color color, boolean isMaster) {
        this.color = color;
        this.isMaster = isMaster;
    }

    public Color getColor() {
        return color;
    }
    
    boolean isMaster(){
        return this.isMaster;
    }
    
}
