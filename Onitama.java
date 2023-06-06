
package onitama;

public class Onitama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameImpl game = new GameImpl();
        for(int i=0;i<game.deck.length;i++){
            System.out.println(game.deck[i].getName());
        }
       /* System.out.println("TableCard: "+game.getTableCard().getName());
        System.out.println("cartas do jogador vermelho");
        for(int i=0;i<2;i++) System.out.println(game.getRedPlayer().getCards()[i].getName());
        System.out.println("\n");*/

       /* game.getRedPlayer().swapCard(game.getRedPlayer().getCards()[0], game.getTableCard());
        System.out.println("TableCard: "+game.getTableCard().getName());*/
        /*System.out.println("cartas do jogador azul");
        for(int i=0;i<2;i++) System.out.println(game.getBluePlayer().getCards()[i].getName());
        System.out.println("t");*/


    }
    
}
