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
    
    public GlyphPit(){
        Glyph w = new Glyph(1);
        Glyph b = new Glyph(0);
        whites = new ArrayList<Glyph>();
        browns = new ArrayList<Glyph>();
        for(int i = 0; i<24; i++){
            whites.add(w);
            
        }
        
        for(int i = 0; i<24; i++){
            browns.add(b);
        }
        
    }
    
    public Glyph getRandGlyph(){
        Glyph g;
        
        boolean x = (int)(Math.random()*2)<1;
        if(x){
            g = whites.remove(0);
        }else{
            g = browns.remove(0);
        }
        return g;
    }
    
    public Glyph getWhiteGlyph(){
        return whites.remove(0);
    }
    
    public Glyph getBrownGlyph(){
        return browns.remove(0);
    }
}
