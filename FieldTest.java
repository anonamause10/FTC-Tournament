import java.util.*;
import java.io.*;
/**
 * Write a description of class FieldTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FieldTest
{
    public static void main(String[]args){
        List<Team> teams = new ArrayList<Team>();
        try{
            teams = CreateTeams.createTeams();
        }catch(IOException e){
            //no handle lel
        }
        MatchListGenerator m = new MatchListGenerator(teams);
        List<Team[]> matches = new ArrayList<Team[]>();
        while(!m.allTeamsDone(5)){
            matches = m.generateMatches(5);

        }
        String[] matchLog = new String[matches.size()];
        String results = "";
        int count = 0;
        for(Team[] t: matches){
            String boiz = "";
            for(int i = 0; i<4; i++){
                boiz+=(t[i].toString())+"\n";
            }
            results+=boiz;
            Field f = new Field(t[0], t[1], t[2], t[3]);
            f.autoPlay();
            f.setAutoStatus();
            f.telePlay();
            f.setTeleStatus();
            results+=(f.getRedScore()+":"+f.getBlueScore())+"\n";
            matchLog[count] = boiz+f.toString();
            count++;
        }

        Scanner s = new Scanner(System.in);
        boolean going = true;
        while(going){
            System.out.println(results);
            int x = s.nextInt();
            System.out.print("\u000C");
            System.out.println(matchLog[x-1]);
            if(s.nextLine().equals("back")){
                System.out.println("\u000C");
            }else if(s.nextLine().equals("quit")){
                going = false;
            }
        }
    }
}
