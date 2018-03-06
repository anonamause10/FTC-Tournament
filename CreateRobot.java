import java.util.*;
import java.io.*;
/**
 * Write a description of class CreateRobot here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CreateRobot
{
    public static List<Robot> createBots()throws IOException{
        List<Robot>bots = new ArrayList<Robot>();
        Scanner s = new Scanner(new File("Robot.txt"));
        Robot temp;
        while(s.hasNextLine()){
            temp = new Robot(s.nextLine(), s.nextInt(), s.nextBoolean(), 
                s.nextInt(), s.nextInt(), 
                s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), 
                s.nextInt(), s.nextBoolean(), s.nextInt(), s.nextInt(), s.nextInt(), 
                s.nextInt(), s.nextInt(), s.nextInt());
            bots.add(temp);
            s.nextLine();
        }
        return bots;
    }

}
