
/**
 * Write a description of class BalanceBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BalanceBoard implements GameElement
{
    private boolean hasRobot;
    private boolean side;//true is red
    public boolean canBeScored(int time){
        return time<= 30||time>= 120;
    }
    
    public int getPointValue(){
        return 20;
    }
    
    public String toString(){
        String str = "";
        String has = "";
        String col = "";
        if(side){
            col = "red";
        }else{
            col = "blue";
        }
        if(hasRobot){
            has = "has";
        }else{
            has = "does not have";
        }
        
        str += "This board is on the "+col+" side, and "+has+" a robot on it";
        
        return str;
    }
}
