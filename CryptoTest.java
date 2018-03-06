
/**
 * Write a description of class CryptoTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CryptoTest
{
    public static void main(String[]args){
        Cryptobox x = new Cryptobox(true);
        Relic r = new Relic(true, x);
        Glyph w = new Glyph(1);
        Glyph b = new Glyph(0);
        x.scoreGlyph(b,1);
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
        x.scoreGlyph(b,3);
        System.out.println(x.printCiph());
        System.out.println(x.checkCipher());
        System.out.println(x.whichCiph());
        System.out.println(r.canBeScored(0));
    }
}
