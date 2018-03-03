public class AwardCeremony{
    private Team thinkWin;
    private Team inspire1Win;
    private Team inspire2Win;
    private Team inspire3Win;
    private Team connectWin;
    private Team designWin;
    private Team innovateWin;
    private Team motivateWin;
    private Team controlWin;
    public AwardCeremony(){
        thinkWin = new Team();
        inspire1Win = new Team();
        inspire2Win = new Team();
        inspire3Win = new Team();
        connectWin = new Team();
        designWin = new Team();
    }
    public AwardCeremony(Team[] t){
        thinkWin = getThink(t);
        inspire1Win = getInspire(t)[0];
        inspire2Win = getInspire(t)[1];
        inspire3Win = getInspire(t)[2];
        connectWin = getConnect(t);
        designWin = getDesign(t);
    }
    public static Team getThink(Team[] t){
        int index = 0;
        double score = 0;
        for (int i = 0; i < t.length; i++){
            if(t[i].getThinkScore() > score){
                index = i;
                score = t[i].getThinkScore();
            }
        }
        return t[index];
    }
    public static Team []getInspire(Team[] t){
        
        boolean sorted = false;
        Team[]temp = t;
        while(!sorted){
            boolean c = true;
            for(int i = 0; i<t.length-1; i++){
                if(temp[i].getInspireScore()<temp[i+1].getInspireScore()){
                    Team x = temp[i];
                    temp[i] = temp[i+1];
                    temp[i+1] = x;
                    c = false;
                }
            }
            sorted = c;
        }
        Team[] r = new Team[3];
        for(int i = 0; i<3; i++){
            r[i] = temp[i];
        }
        return r;
    }
    public static Team getConnect(Team[] t){
        int index = 0;
        double score = 0;
        for (int i = 0; i < t.length; i++){
            if(t[i].getConnectScore() > score){
                index = i;
                score = t[i].getConnectScore();
            }
        }
        return t[index];
    }
    public static Team getDesign(Team[] t){
        int index = 0;
        double score = 0;
        for (int i = 0; i < t.length; i++){
            if(t[i].getDesignScore() > score){
                index = i;
                score = t[i].getDesignScore();
            }
        }
        return t[index];
    }
    public static Team getInnovate(Team[] t){
        int index = 0;
        double score = 0;
        for (int i = 0; i < t.length; i++){
            if(t[i].getInnovateScore() > score){
                index = i;
                score = t[i].getThinkScore();
            }
        }
        return t[index];
    }
    public static Team getMotivate(Team[] t){
        int index = 0;
        double score = 0;
        for (int i = 0; i < t.length; i++){
            if(t[i].getMotivateScore() > score){
                index = i;
                score = t[i].getThinkScore();
            }
        }
        return t[index];
    }
    public static Team getControl(Team[] t){
        int index = 0;
        double score = 0;
        for (int i = 0; i < t.length; i++){
            if(t[i].getControlScore() > score){
                index = i;
                score = t[i].getThinkScore();
            }
        }
        return t[index];
    }
    public String toString(){
        String str = "";
        str+= "Connect Award winner is:\n";
        str+= connectWin.toString()+"\n";
        str+= "Design Award winner is:\n";
        str+= designWin.toString()+"\n";
        str+= "Think Award winner is:\n";
        str+= thinkWin.toString()+"\n";
        str+= "Inovate Award winner is:\n";
        str+= innovateWin.toString() +"\n";
        str+= "Motivate Award winner is:\n";
        str+= motivateWin.toString() +"\n";
        str+= "Control Award winner is: \n";
        str+= controlWin.toString() +"\n";
        str+= "Inspire Award 3rd winner is:\n";
        str+= inspire3Win.toString()+"\n";
        str+= "Inspire Award 2nd winner is:\n";
        str+= inspire2Win.toString()+"\n";
        str+= "Inspire Award 1st winner is:\n";
        str+= inspire1Win.toString()+"\n";
        
        return str;
    }
}
