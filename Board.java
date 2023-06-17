package onitama;


public class Board {
    private Spot[][] spot;
    /**
     * Construtor que cria o tabuleiro inicial que será utilizado durante o jogo<br>
     * Tabuleiro inicial:<br>
     * &nbsp Tamanho: 5x5<br>
     * &nbsp Peças: Azuis em cima com mestre na posição (0,2)<br>
     * &nbsp Peças: Vermelhas em baixo com mestre na posição (4,2)<br>
     */
    public Board() {
        spot = new Spot[5][5];

        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {


                if(row == 0){
                    if(col==2)spot[row][col] = new Spot(new Piece(Color.BLUE, true),new Position(row, col), Color.BLUE);
                    else spot[row][col] = new Spot(new Piece(Color.BLUE, false),new Position(row, col));
                }else if(row==4) {
                    if (col == 2) spot[row][col] = new Spot(new Piece(Color.RED, true), new Position(row, col), Color.RED);
                    else spot[row][col] = new Spot(new Piece(Color.RED, false), new Position(row, col));
                }else{
                    spot[row][col] = new Spot(new Position(row, col));

                }



            }
        }
    }
    /**
     * Método que devolve o tabuleiro
     * @return Retorna uma matriz de spots que equivale ao tabuleiro
     */
    public Spot[][] getSpot() {
        return spot;
    }
    
    
    
    
}
