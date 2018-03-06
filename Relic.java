public class Relic implements GameElement{
    private boolean isStanding;
    private boolean side; //true is red
    private int scoreZone;
    private Cryptobox box;
    public Relic (boolean side, Cryptobox b){
        isStanding = false;
        scoreZone = 0;
        this.side = side;
        box = b;
    }

    public void setStanding(boolean b){
        isStanding = b;
    }

    public void setZone(int s){
        scoreZone = s;
    }

    public void setSide(boolean b, Cryptobox bo){
        side = b;
        box = bo;
    }

    public boolean canBeScored(int time){
        if(time >= 120||box.checkCipher()){
            return true;
        }
        return false;
    }

    public int getPointValue(int time){
        if(time>=120||box.checkCipher()){
            if (scoreZone == 1){
                if(isStanding){
                    return 25;
                }
                return 10;
            }
            if (scoreZone == 2){
                if(isStanding){
                    return 35;
                }
                return 20;
            }
            if (scoreZone == 3){
                if(isStanding){
                    return 55;
                }
                return 40;
            }
        }
        return 0;
    }

    public String toString(){
        String s = "This relic is on the ";
        if(side == true)
            s += "red alliance, ";
        else
            s+= "blue alliance, ";
        if(scoreZone == 0){
            s += "and is not scored.";
            return s;
        }
        else
            s += "is scored, in zone " + scoreZone + ", ";
        if(isStanding)
            s += "and is standing up";
        else
            s += "and is not standing up";
        return s;
    }
}