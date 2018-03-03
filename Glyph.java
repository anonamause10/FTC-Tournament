
/**
 * Write a description of class Glyph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Glyph implements GameElement
{
   
    private boolean scored;
    private boolean color; //true is white, false is brown
    /**
     * Constructor for objects of class Glyph
     */
    public Glyph(boolean color/**true is white*/)
    {
        // initialise instance variables
        scored = false;
        this.color = color;
    }

    public void Score(){
        scored = !scored;
    }
    
    public int getPointValue(){
        return 2;
    }
    
    public boolean getColor(){
      return color; 
    }
    
    public boolean canBeScored(int time){
        return true;
    }
    
    public String toString(){
        String str = "";
        String col;
        if(color){
            col = "white";
        }else{
            col = "brown";
        }
        str += "This "+ col+" glyph is ";
        if(!scored){
            str += "not ";
        }
        str +="scored\n";
        return str;
    }
}
