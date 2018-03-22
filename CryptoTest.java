import java.io.*;
import java.util.*;
/**
 * Write a description of class CryptoTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CryptoTest
{
    public static void main(String[]args){
        GlyphPit g = new GlyphPit();
        Robot bot = new Robot();
        List<Team> l= new ArrayList<Team>();
        
        try{
            l = CreateTeams.createTeams();
        }catch(IOException e){
            e.printStackTrace();
        }
        
        bot = l.get(0).getRobot();

        Cryptobox x = new Cryptobox(true, g); 
        System.out.println(bot.getAutoCrypto());
        System.out.println(bot.getAutoKey());
        Relic r = new Relic(true, x);
        Glyph w = new Glyph(1);
        Glyph b = new Glyph(0);
        int y = x.getAutoPoints(bot);
        x.postAutoUpdate();
        System.out.println(x.isBoxEmpty());
        int i = 0;
        String boi = ""+x.whichCipherWorkingOn();
        System.out.println(x.printCiph());
        System.out.println("Drivers pick up ur controllers");
        while(!x.isFull){
            if(i ==1){
                x.postAutoUpdate();
            }
            x.selfScoreGlyph(bot);
            System.out.println(x.printCiph());
            i++;

        }
        System.out.println();


        System.out.println(x.checkCipher());
        System.out.println(x.whichCiph());
        System.out.println(r.canBeScored(0));
        System.out.println(x.getTelePoints());
        System.out.println(x.partOfCipher());
        System.out.println(x.canScore(1));
        System.out.println(x.cipherWorkingOn());
        System.out.println(g.getCryptoKey());
        System.out.println(boi);
        System.out.println(bot.numAutoGlyphs());
        System.out.println(y);
        System.out.println(l.size());
        MatchListGenerator m = new MatchListGenerator(l);
        List<Team[]> t = new ArrayList<Team[]>();
        while(!m.allTeamsDone(5)){
            t = m.generateMatches(5);
            
        }
        for(int z = 0; z< t.size(); z++){
            System.out.println("Match "+z);
            for(int k = 0; k< t.get(z).length; k++){
                System.out.println(t.get(z)[k].toString());
            }
        }
        for(int oiu = 0; oiu<l.size(); oiu++){
            System.out.println(l.get(oiu).getMatchesPlayed()+l.get(oiu).toString());
        }
    }
}
