
/**
 * Write a description of class Cryptobox here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cryptobox
{
    // instance variables - replace the example below with your own
    Glyph[][] box;//0 is top, left
    boolean  color;//true is red, false is blue
    boolean robotInZone;
    public Cryptobox(boolean color){
        this.color = color;
        box = new Glyph[4][3];
        robotInZone = false;
    }
    
    public void scoreGlyph(Glyph g, int col){
        
    }
    
    public int checkRows(){
        
        
        return 0;
    }
}
