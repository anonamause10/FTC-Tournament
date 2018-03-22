import java.util.*;
/**
 * Write a description of class MatchGenerator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MatchListGenerator
{
    private List<Team[]> matches;
    private List<Team> teams;
    public MatchListGenerator(List<Team> t){
        teams = t;
        matches = new ArrayList<Team[]>();
    }

    public List<Team[]> generateMatches(int numPlays){
        for(Team t:teams)t.resetMatches();
        matches = new ArrayList<Team[]>();
        int n = (((numPlays*teams.size())%4)==0) ? ((numPlays*teams.size())/4) : (((numPlays*teams.size())/4)+1);
        for(int i = 0; i<n; i++){
            List<Team> nDone = setE(teams);
            List<Team> done = new ArrayList<Team>();
            for(int o = 0; o<nDone.size(); o++){
                if(nDone.get(o).getMatchesPlayed()>=numPlays){
                    done.add(nDone.remove(o));
                    o--;
                }
            }
            Team[] boiz = new Team[4];

            for(int k = 0; k< 4; k++){
                System.out.println(i+""+k);
                Team t = new Team();
                try{
                    t = nDone.remove((int)(Math.random()*nDone.size()));
                }catch(IndexOutOfBoundsException e){
                    t = done.remove((int)(Math.random()*done.size()));
                }

                t.incMatches();
                boiz[k] = t;
            }
            matches.add(boiz);

        }
        
        return matches;
    }

    public boolean allTeamsDone(int numPlays){
        for(Team t:teams){
            if(t.getMatchesPlayed()<numPlays){
                return false;
            }
        }
        
        return true;
    }
    
    public static List<Team> setE(List<Team> s){
        List<Team> te = new ArrayList<Team>();
        for(int i = s.size()-1; i>=0; i--){
            te.add(s.get(i));
        }
        return te;
    }
}
