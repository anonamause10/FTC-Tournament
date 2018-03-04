
/**
 * Write a description of class Glyph here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Glyph implements GameElement
{
   
    private boolean scored;
    private int color; //1 is white, 0 is brown


    public Glyph(int color/**true is white*/)

    {
        // initialise instance variables
        scored = false;
        this.color = color;
    }

    public void Score(){
        scored = !scored;
    }
    
    public int getPointValue(int time){
        int x = 0;
        if(time<= 30){
            return 15;
        }
        return 2;
    }
    
    public int getColor(){
      return color; 
    }
    
    public boolean canBeScored(int time){
        return true;
    }
    
    public String toString(){
        String str = "";
        String col;
        if(color == 1){
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
    
    public boolean equals(Glyph g){
        return color == g.getColor();
    }
    
    public String toStr(){
        String str = " ";
        str+=color;
        return str;
    }
}
