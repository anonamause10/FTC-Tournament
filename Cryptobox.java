
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
    private final Glyph[4][3] cipher1 new Glyph{{1, 0, 1},{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
    private final Glyph[4][3] cipher2 new Glyph{{0, 1, 0}, {1, 0, 1}, {0, 1, 0}, {1, 0, 1}};
    private final Glyph[4][3] cipher3 new Glyph{{0, 1, 0}, {1, 0, 1}, {1, 0, 1}, {0, 1, 0}};
    private final Glyph[4][3] cipher4 new Glyph{{1, 0, 1}, {0, 1, 0}, {0, 1, 0}, {1, 0, 1}};
    private final Glyph[4][3] cipher5 new Glyph{{0, 1, 1}, {0, 0, 1}, {1, 0, 0}, {1, 1, 0}};
    private final Glyph[4][3] cipher6 new Glyph{{1, 0, 0}, {1, 1, 0}, {0. 1, 1}, {0, 0, 1}};
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
        if(Arrays.deepEquals(box, cipher1) || (Arrays.deepEquals(box, cipher2) || (Arrays.deepEquals(box, cipher3) ||
        (Arrays.deepEquals(box, cipher4) || (Arrays.deepEquals(box, cipher5) || (Arrays.deepEquals(box, cipher6)){
         return true   
        }
        return false;
    }
}
