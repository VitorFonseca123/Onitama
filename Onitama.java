
package onitama;

public class Onitama {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GameImpl game = new GameImpl();

       System.out.println("TableCard: "+game.getTableCard().getName());
        System.out.println("\n");
        System.out.println("cartas do jogador vermelho");
        for(int i=0;i<2;i++) System.out.println(game.getRedPlayer().getCards()[i].getName());
        //System.out.println("\n");
        System.out.println("cartas do jogador azul");
        for(int i=0;i<2;i++) System.out.println(game.getBluePlayer().getCards()[i].getName());
        game.printBoard();

        Position[] Tiger = {new Position(-2, 0), new Position(1, 0)};
        Position[] Dragon = {new Position(1, -2), new Position(1, 2), new Position(1, -1),  new Position(1, 1)};
        Position[] Frogg = {new Position(1, 1), new Position(-1, -1), new Position(-2, 0)};

        Card[] cards = new Card[]{
                new Card("Tiger",Color.BLUE ,Tiger),
                new Card("Dragon",Color.RED ,Dragon),
                new Card("Frogg",Color.RED ,Frogg),};
        //GameImpl g = new GameImpl("vermelho", "azul", cards);
        game.getRedPlayer().swapCard(cards[1], game.getTableCard());//é pra gerar exceção


    }
    
}
