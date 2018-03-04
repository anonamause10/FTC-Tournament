
/**
 * Write a description of class Cryptobox here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class Cryptobox
{
    // instance variables - replace the example below with your own
    Glyph[][] box;//0 is top, left
    boolean  color;//true is red, false is blue
    boolean robotInZone;
    boolean isFull;
    Glyph w = new Glyph(1);
    Glyph b = new Glyph(0);
    private final Glyph[][] cipher1 = new Glyph[][]{{w, b, w},{b, w, b}, {w, b, w}, {b, w, b}};
    private final Glyph[][] cipher2 = new Glyph[][]{{b, w, b}, {w, b, w}, {b, w, b}, {w, b, w}};
    private final Glyph[][] cipher3 = new Glyph[][]{{b, w, b}, {w, b, w}, {w, b, w}, {b, w, b}};
    private final Glyph[][] cipher4 = new Glyph[][]{{w, b, w}, {b, w, b}, {b, w, b}, {w, b, w}};
    private final Glyph[][] cipher5 = new Glyph[][]{{b, w, w}, {b, b, w}, {w, b, b}, {w, w, b}};
    private final Glyph[][] cipher6 = new Glyph[][]{{w, b, b}, {w, w, b}, {b, w, w}, {b, b, w}};
    public Cryptobox(boolean color){
        this.color = color;
        box = new Glyph[4][3];
        robotInZone = false;
        isFull = false;
    }
    
    public void scoreGlyph(Glyph g, int col){

    }
    
    public int checkRows(){
        return 0;
    }
    public boolean checkCipher(){
        if (!isFull){
        return false;
        }
        if(Arrays.deepEquals(box, cipher1) || Arrays.deepEquals(box, cipher2) || Arrays.deepEquals(box, cipher3) ||
        Arrays.deepEquals(box, cipher4) || Arrays.deepEquals(box, cipher5) || Arrays.deepEquals(box, cipher6)){
         return true;   
        }
        return false;
    }
}
