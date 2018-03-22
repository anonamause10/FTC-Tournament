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
        int n = (((numPlays*teams.size())%4)==0) ? ((numPlays*teams.size())/4) : (((numPlays*teams.size())/4)+1);
        for(int i = 0; i<n-1; i++){
            List<Team> temp = setE(teams);
            Team[] boiz = new Team[4];
            for(int k = 0; k< 4; k++){
                System.out.println(i);
                Team t = temp.remove((int)(Math.random()*temp.size()));

                while(t.getMatchesPlayed()>=numPlays){
                    /*if(i ==n-1&&k>((numPlays*teams.size())%4)){
                    temp.add(t);
                    break;
                    }*/
                    t = temp.remove((int)(Math.random()*temp.size()));
                }
                t.incMatches();
                boiz[k] = t;
            }
            matches.add(boiz);

        }
        List<Team> nDone = setE(teams);
        List<Team> done = new ArrayList<Team>();
        for(int o = 0; o<nDone.size(); o++){
            if(nDone.get(o).getMatchesPlayed()>=numPlays){
                done.add(nDone.remove(o));
                o--;
            }
        }
        List<Team> temp = setE(teams);
        Team[] boiz = new Team[4];
        for(int k = 0; k< 4; k++){
            System.out.println("ree");
            Team t = new Team();
            try{
                t = nDone.remove(0);
            }catch(IndexOutOfBoundsException e){
                
                t = done.remove((int)(Math.random()*done.size()));
            }
            
            
            t.incMatches();
            boiz[k] = t;
        }
        matches.add(boiz);

        return matches;
    }

    public static List<Team> setE(List<Team> s){
        List<Team> te = new ArrayList<Team>();
        for(int i = s.size()-1; i>=0; i--){
            te.add(s.get(i));
        }
        return te;
    }
}
