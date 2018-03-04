
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
    private boolean  color;//true is red, false is blue
    private boolean robotInZone;
    private boolean isFull;
    private Glyph w = new Glyph(1);
    private Glyph b = new Glyph(0);
    private int rowCount1 = 3;
    private int rowCount2 = 3;
    private int rowCount3 = 3;
    private final Glyph[][] cipher1 = new Glyph[][]{{w, b, w}, {b, w, b}, {w, b, w}, {b, w, b}};
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
        if(col == 1){
            box[rowCount1][0] =  g;
            rowCount1--;
        }
        if(col == 2){
            box[rowCount2][1] =  g;
            rowCount2--;
        }
        if(col == 3){
            box[rowCount3][2] =  g;
            rowCount3--;
        }
    }
    public int checkRows(){
        int counter = 0;
        for(int i = 0; i < 4; i++){
            if(box[i][0] != null && box[i][1] != null && box[i][2] != null){
                counter++;
            }
        }
        return counter;
    }
    public int checkColumns(){
        int counter = 0;
        for(int i = 0; i < 3; i++){
            if(box[0][i] != null && box[1][i] != null && box[2][i] != null && box[3][i] != null){
                counter++;
            }
        }
        return counter;
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
