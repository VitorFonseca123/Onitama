
package onitama;

public class Onitama {


    public static void main(String[] args) {
        GameImpl game = new GameImpl();

       System.out.println("TableCard: "+game.getTableCard().getName());
        System.out.println("cartas do jogador vermelho");
        for(int i=0;i<2;i++) System.out.println(game.getRedPlayer().getCards()[i].getName());
        //System.out.println("\n");
        System.out.println("cartas do jogador azul");
        for(int i=0;i<2;i++) System.out.println(game.getBluePlayer().getCards()[i].getName());
        game.printBoard();
        System.out.println("");

        game.makeMove(game.getRedPlayer().getCards()[0], game.getRedPlayer().getCards()[0].getPosition()[0], new Position(4, 3));
        game.printBoard();


    }
    
}
