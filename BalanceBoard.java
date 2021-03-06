
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
    public BalanceBoard(boolean side){
        this.side = side;
        hasRobot = false;
    }
    
    public boolean canBeScored(int time){
        return time>= 120;
    }
    
    public int getPointValue(int time){
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
