public class Team{
    private Robot robot;
    private String teamName;
    private int teamNumber;
    private double designLevel;
    private double presentationLevel;
    private double pitLevel;
    private double graciousProfessionalismLevel;
    private double outreachLevel;
    private double engineeringNotebookLevel;
    private double innovateLevel;
    private double motivateLevel;
    private double controlLevel;
    private double relationsSkill;
    private boolean isRookie;
    private int qP;
    private int rP;
    private int ranking;
    private int matchesPlayed;
    public Team(){
        robot = new Robot();
        teamName =  "";
        teamNumber = 1111;
        designLevel = 0;
        presentationLevel = 0;
        pitLevel = 0;
        graciousProfessionalismLevel = 0;
        outreachLevel = 0;
        engineeringNotebookLevel = 0;
        innovateLevel = 0;
        motivateLevel = 0;
        controlLevel = 0;
        relationsSkill = 0;
        isRookie = false;
        qP = 0;
        rP = 0;
        ranking = 0;
        matchesPlayed = 0;
    }

    public Team(Robot r, String tN, int teamN, double dL, double pL, double pitL, 
    double gPL, double oL, double eNL, double iL, double mL, double cL, double rS, 
    boolean iR){
        robot = r;
        teamName =  tN;
        teamNumber = teamN;
        designLevel = dL;
        presentationLevel = pL;
        pitLevel = pitL;
        graciousProfessionalismLevel = gPL;
        outreachLevel = oL;
        engineeringNotebookLevel = eNL;
        innovateLevel = iL;
        motivateLevel = mL;
        controlLevel = cL;
        relationsSkill = rS;
        isRookie = iR;
        qP = 0;
        rP = 0;
        ranking = 0;
        matchesPlayed = 0;
    }

    public double getRelationsSkill(){
        return relationsSkill;
    }

    public double getInspireScore(){
        return (presentationLevel * 2) + pitLevel + (graciousProfessionalismLevel * 5) +
        (outreachLevel * 3) + (designLevel * 3) + (engineeringNotebookLevel * 2);
    }

    public double getDesignScore(){
        return designLevel + this.getJudgeScore() * 0.2;
    }

    public double getThinkScore(){
        return engineeringNotebookLevel + this.getJudgeScore() * 0.2;
    }

    public double getConnectScore(){
        return outreachLevel + this.getJudgeScore() * 0.2;
    }

    public double getInnovateScore(){
        return innovateLevel + this.getJudgeScore() * 0.2;   
    }

    public double getMotivateScore(){
        return motivateLevel + this.getJudgeScore() * 0.2;
    }

    public double getControlScore(){
        return controlLevel + this.getJudgeScore() * 0.2;
    }

    public double getJudgeScore(){
        return (presentationLevel*2) + pitLevel;
    }

    public int getQP(){
        return qP;
    }

    public int getRP(){
        return rP;
    }

    public int getRanking(){
        return ranking;
    }

    public void setRank(int n){
        ranking = n;
    }

    public void setQP(int n){
        qP = n;
    }

    public void setRP(int n){
        rP = n;
    }
    
    public int getMatchesPlayed(){
        return matchesPlayed;
    }
    
    public void incMatches(){
        matchesPlayed++;
    }
    
    public void resetMatches(){
        matchesPlayed = 0;
    }
    
    public Robot getRobot(){
        return robot;
    }
    
    public String toString(){
        String str = "Team ";
        str += teamNumber;
        str+= ": " + teamName;

        return str;
    }
    
    public int getTeamNumber(){
        return teamNumber;
    }
}


