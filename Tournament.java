import java.io.*;
import java.util.*;

public class Tournament
{
    private List<Team> teamList;
    private Field[] fieldArray;
    private AwardCeremony homuraDidNothingWrong;
    public Tournament(List<Team> t, int f){
        teamList = t;
        fieldArray = new Field[f];
        for(int s = 0; s < f; s++){
            fieldArray[s] = new Field();
        }
        homuraDidNothingWrong = new AwardCeremony(CreateTeams.teamArray(teamList));
    }
    public Field getField(int i){
        return fieldArray[i];
    }
    public List<Team> getTeams(){
        return teamList;
    }
}

