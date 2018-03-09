import java.io.*;
import java.util.*;
/**
 * Write a description of class CreateTeams here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CreateTeams
{
    public static List<Team> createTeams()throws IOException{
        List<Team> teams = new ArrayList();
        Scanner s = new Scanner(new File("Team.txt"));
        Team temp;
        List<Robot> bots = CreateRobot.createBots(); 
        int i = 0;
        while(s.hasNextLine()){
            temp = new Team(bots.get(i), 
            s.nextLine(), 
            s.nextInt(),
            s.nextDouble(), s.nextDouble(), s.nextDouble(), s.nextDouble(), 
            s.nextDouble(), s.nextDouble(), s.nextDouble(), s.nextDouble(), 
            s.nextDouble(), s.nextDouble(), s.nextBoolean());
            teams.add(temp);
            i++;
            s.nextLine();
        }
        return teams;
    }
    
    public static Team[] teamArray(List<Team> boiz){
     
        Team[] teams = boiz.toArray(new Team[boiz.size()]);
        return teams;
    }
}
