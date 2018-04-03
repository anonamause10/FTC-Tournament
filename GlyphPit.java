import java.util.*;
/**
 * Write a description of class GlyphPit here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GlyphPit
{
    private List<Glyph> whites;
    private List<Glyph> browns;
    private int cryptoKey; //l left 3 right
    public GlyphPit(){
        Glyph w = new Glyph(1);
        Glyph b = new Glyph(0);
        whites = new ArrayList<Glyph>();
        browns = new ArrayList<Glyph>();
        cryptoKey = (int)(Math.random() * 3.0 + 1.0);
        for(int i = 0; i<24; i++){
            whites.add(w);
            
        }
        
        for(int i = 0; i<24; i++){
            browns.add(b);
        }
        
    }
    
    public Glyph getRandGlyph(){
        Glyph g;       
        int x = (int)(Math.random()*(whites.size()+browns.size()));
        g = (x<whites.size()) ? whites.remove(x) : browns.remove(x-whites.size());
        return g;
    }
    
    public Glyph getWhiteGlyph(){
        try{
            return whites.remove(0);
        }catch(IndexOutOfBoundsException e){}

        return null;
    }
    
    public Glyph getBrownGlyph(){
        try{
            return browns.remove(0);
        }catch(IndexOutOfBoundsException e){}

        return null;
    }
     
    public int getCryptoKey(){
        return cryptoKey;
    }
}
