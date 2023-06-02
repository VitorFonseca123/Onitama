package onitama;


public class Board {
    private static Spot[][] spot;

    public Board() {
        spot = new Spot[5][5];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if(row == 0 && col==2){
                    //setar cor central?
                }else if(row==4 && col==2){
                    //setar cor central?
                }else{
                    //setar normal
                }
                spot[row][col] = new Spot(new Position(row, col));
            }
        }
    }

    public static Spot[][] getSpot() {
        return spot;
    }
    
    
    
    
}
