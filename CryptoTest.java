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
        try{
            bot = CreateTeams.createTeams().get(2).getRobot();
        }catch(IOException e){
            e.printStackTrace();
        }
        Cryptobox x = new Cryptobox(true, g);
        System.out.println(bot.getAutoCrypto());
        System.out.println(bot.getAutoKey());
        Relic r = new Relic(true, x);
        Glyph w = new Glyph(1);
        Glyph b = new Glyph(0);
        x.getAutoPoints(bot);
        System.out.println(x.isBoxEmpty());
        int i = 0;
        String boi = ""+x.whichCipherWorkingOn();
        while(!x.isFull){
            x.selfScoreGlyph(bot);
            System.out.print(i);
            i++;
            
        }
        System.out.println();

        /*x.scoreGlyph(b,1);
        x.scoreGlyph(w,1);
        x.scoreGlyph(w,1);
        x.scoreGlyph(b,1);
        x.scoreGlyph(w,2);
        x.scoreGlyph(b,2);
        x.scoreGlyph(b,2);
        x.scoreGlyph(w,2);
        x.scoreGlyph(b,3);
        x.scoreGlyph(w,3);
        x.scoreGlyph(w,3);
        x.scoreGlyph(b,3);*/

        System.out.println(x.printCiph());
        System.out.println(x.checkCipher());
        System.out.println(x.whichCiph());
        System.out.println(r.canBeScored(0));
        System.out.println(x.getTelePoints());
        System.out.println(x.partOfCipher());
        System.out.println(x.canScore(1));
        System.out.println(x.cipherWorkingOn());
        System.out.println(g.getCryptoKey());
        System.out.println(boi);
        

    }
}
