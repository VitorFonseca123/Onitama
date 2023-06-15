
package onitama;

public class Onitama {


    public static void main(String[] args) {
        Position[] Tiger = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
        Position[] Dragon = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
        Position[] Frog = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
        Position[] Rabbit = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
        Position[] Crab = {new Position(-1, 0), new Position(1, 0), new Position(0, 1), new Position(0, -1)};
        Card [] cartasTeste = new Card[] {
            new Card("Tiger",Color.BLUE ,Tiger),
            new Card("Dragon",Color.BLUE ,Dragon),
            new Card("Frog",Color.BLUE ,Frog),
            new Card("Rabbit", Color.BLUE, Rabbit),
            new Card("Crab", Color.BLUE, Crab)
        };
        GameImpl joguinho = new GameImpl("Henrique","L", cartasTeste);

        joguinho.printBoard();
        System.out.println();
        joguinho.makeMove(joguinho.getBluePlayer().getCards()[0], new Position(1,0), new Position(0,4));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getBluePlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getRedPlayer().getCards()[0], new Position(-1,0), new Position(4, 4));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getRedPlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getBluePlayer().getCards()[0], new Position(1,0), new Position(0,2));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getBluePlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getRedPlayer().getCards()[0], new Position(-1,0), new Position(3, 4));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getRedPlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getBluePlayer().getCards()[0], new Position(1,0), new Position(1,4));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getBluePlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getRedPlayer().getCards()[0], new Position(-1,0), new Position(4, 3));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getRedPlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getBluePlayer().getCards()[0], new Position(1,0), new Position(2,4));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getBluePlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getRedPlayer().getCards()[0], new Position(-1,0), new Position(3, 3));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getRedPlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getBluePlayer().getCards()[0], new Position(1,0), new Position(3,4));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getBluePlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getRedPlayer().getCards()[0], new Position(-1,0), new Position(2, 3));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getRedPlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getBluePlayer().getCards()[0], new Position(0,-1), new Position(4,4));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getBluePlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getRedPlayer().getCards()[0], new Position(-1,0), new Position(1, 3));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getRedPlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getBluePlayer().getCards()[0], new Position(1,0), new Position(0,0));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getBluePlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getRedPlayer().getCards()[0], new Position(0,-1), new Position(0, 3));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getRedPlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getBluePlayer().getCards()[0], new Position(1,0), new Position(1,0));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getBluePlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getRedPlayer().getCards()[0], new Position(-1,0), new Position(4, 2));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getRedPlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getBluePlayer().getCards()[0], new Position(-1,0), new Position(4,3));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getBluePlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getRedPlayer().getCards()[0], new Position(-1,0), new Position(4, 0));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getRedPlayer().getPieceColor()));

        joguinho.makeMove(joguinho.getBluePlayer().getCards()[0], new Position(0,-1), new Position(3,3));
        joguinho.printBoard();
        System.out.println(joguinho.checkVictory(joguinho.getBluePlayer().getPieceColor()));
    }


}
