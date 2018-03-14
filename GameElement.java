/**
 * Write a description of interface GameElement here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface GameElement
{
    int getPointValue(int time);
    boolean canBeScored(int time);
    String toString();
}
