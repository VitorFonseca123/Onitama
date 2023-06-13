
package onitama;


public class Piece {
    private Color color;
    boolean isMaster;

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
