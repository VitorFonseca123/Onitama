
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

    }


}
