package onitama;


public class Board {
    private Spot[][] spot;

    public Board() {
        spot = new Spot[5][5];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if(row == 0){
                    if(col==2)spot[row][col] = new Spot(new Piece(Color.BLUE, false),new Position(row, col), Color.BLUE);
                    else spot[row][col] = new Spot(new Piece(Color.BLUE, false),new Position(row, col));
                }else if(row==4){
                    if(col==2)spot[row][col] = new Spot(new Piece(Color.RED, false),new Position(row, col), Color.RED);
                    else spot[row][col] = new Spot(new Piece(Color.RED, false),new Position(row, col));
                }else{
                    spot[row][col] = new Spot(new Position(row, col));
                }

            }
        }
    }

    public Spot[][] getSpot() {
        return spot;
    }
    
    
    
    
}
