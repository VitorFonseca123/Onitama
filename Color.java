package onitama;
import java.io.Serializable;

/**
 *
 * @author vitor
 */
public enum Color implements Serializable, Comparable<Color>{
    RED,
    BLUE,
    NONE;
    
   // Constantes BLUE, RED e NONE
    public static final Color Blue = Color.BLUE;
    public static final Color Red = Color.RED;
    public static final Color None = Color.NONE;
    
    static Color ValueOf(String name){
        if(name==null){
            throw new NullPointerException("Name não deve ser nulo");
        }
         for (Color color : Color.values()) {
              if (color.name().equalsIgnoreCase(name)) {
                return color;
            }
         }
        
          throw new IllegalArgumentException("Nenhum enum com o nome " + Color.class.getName() + "." + name);
    }

}
