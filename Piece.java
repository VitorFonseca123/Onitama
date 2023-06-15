
package onitama;


public class Piece {
    private Color color;
    boolean Master;

    public Piece(Color color, boolean isMaster) {
        this.color = color;
        this.Master = isMaster;
    }

    public Color getColor() {
        return color;
    }
    
    public boolean isMaster(){
        return this.Master;
    }
    
}
