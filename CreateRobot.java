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
    public static Robot CreateRobot(String[]args) throws IOException{
        Scanner s = new Scanner(new File("Robot.txt"));
        
        Robot r = new Robot(s.next(), s.nextBoolean(), s.nextInt(), s.nextInt(), 
        s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), s.nextInt(), 
        s.nextInt(), s.nextBoolean(), s.nextInt(), s.nextInt(), s.nextInt(), 
        s.nextInt(), s.nextInt(), s.nextInt());
        
        System.out.println(r);
        int x = 0;
        return r;
    }
    
    
}
