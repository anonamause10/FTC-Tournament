
/**
 * Write a description of class Jewel here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Jewel implements GameElement
{
    private String color;
    private int pointValue;
    private boolean knockedOff;
    public Jewel(String color){
        this.color = color;
        knockedOff = false;
    }
    public int getPointValue(){
       return pointValue; 
    }
    public boolean canBeScored(int time){
        if(time<=30){
            return true;
        }
        return false;
    }
    public void knockOff(){
        knockedOff = true;
    }
    public boolean isKnockedOff(){
        return knockedOff;
    }
    public String toString(){
        String str = "";
        str+= "The "+color+" jewel is";
        if(!knockedOff){
            str+=" not ";
        }
        str+= "knocked off\n";
        return str;
    }
}
