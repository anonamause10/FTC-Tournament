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
        Field f = new Field(teams.get(0),teams.get(1),teams.get(2),teams.get(3));
        f.autoPlay();
        f.telePlay();
        
    }
}
