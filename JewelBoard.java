
/**
 * Write a description of class JewelBoard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JewelBoard implements GameElement
{
    private Jewel red = new Jewel("red");
    private Jewel blue = new Jewel("blue");
    private boolean side;//true is red, false is blue
    private boolean order; //true is red left, false is red right
    private int point;
    public JewelBoard(boolean order){
        this.order = order;    
    }

    public void knockOffLeftJewel(){
        if(order){
            red.knockOff();
        }else{
            blue.knockOff();
        }
    }

    public void knockOffRightJewel(){
        if(order){
            blue.knockOff();
        }else{
            red.knockOff();
        }
    }

    public void knockOffCorrectJewel(Robot r){
        if(r.getTeamColor()){//red bot
            if(order){//red on left
                this.knockOffRightJewel();
            }else{//blue on left
                this.knockOffLeftJewel();
            }
        }else{//blue bot
            if(order){//red on left
                this.knockOffLeftJewel();
            }else{//blue on left
                this.knockOffRightJewel();
            }
        }
        point += 30;
    }

    public void knockOffWrongJewel(Robot r){
        if(r.getTeamColor()){//red bot
            if(order){//red on left
                this.knockOffLeftJewel();
            }else{//blue on left
                this.knockOffRightJewel();
            }
        }else{//blue bot
            if(order){//red on left
                this.knockOffRightJewel();
            }else{//blue on left
                this.knockOffLeftJewel();
            }
        }
        point-=30;
    }

    public void knockOff(Robot r){
        if(r.getAutoJewel()){
            this.knockOffCorrectJewel(r);
        }else{
            this.knockOffWrongJewel(r);
        }
    }

    public int getPointValue(int time){
        if(time<=30){
            return point;
        }
        return 0;
    }

    public boolean canBeScored(int time){
        if(time<=30){
            return true;
        }
        return false;
    }

    public String toString(){
        String str = "";
        String color = "";
        if(side){
            color = "red";
        }else{
            color = "blue";
        }
        str += "This board is on the " + color +" side\n";

        if(order){
            str += "The red jewel is on the left\n";
        }else{
            str += "The blue jewel is on the left\n";
        }

        str += red.toString();
        str += blue.toString();
        return str;
    }
}
