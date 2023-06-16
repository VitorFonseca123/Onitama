package onitama;
import java.io.Serializable;


public enum Color implements Serializable, Comparable<Color>{
    RED,
    BLUE,
    NONE;
    public static final Color Blue = Color.BLUE;
    public static final Color Red = Color.RED;
    public static final Color None = Color.NONE;

}
