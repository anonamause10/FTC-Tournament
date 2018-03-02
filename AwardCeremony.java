public class AwardCeremony{
    private Team thinkWin;
    private Team inspireWin;
    private Team connectWin;
    private Team designWin;
    public AwardCeremony(){
        thinkWin = new Team();
        inspireWin = new Team();
        connectWin = new Team();
        designWin = new Team();
    }
    public AwardCeremony(Team[] t){
        thinkWin = getThink(t);
        inspireWin = getInspire(t);
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
    public static Team getInspire(Team[] t){
        int index = 0;
        double score = 0;
        for (int i = 0; i < t.length; i++){
            if(t[i].getInspireScore() > score){
                index = i;
                score = t[i].getInspireScore();
            }
        }
        return t[index];
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
    public String toString(){
        return "";
    }
}