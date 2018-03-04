
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
        Glyph w = new Glyph(1);
        Glyph b = new Glyph(0);
        x.scoreGlyph(w,1);
        x.scoreGlyph(b,1);
        x.scoreGlyph(w,1);
        x.scoreGlyph(b,1);
        x.scoreGlyph(b,2);
        x.scoreGlyph(w,2);
        x.scoreGlyph(b,2);
        x.scoreGlyph(w,2);
        x.scoreGlyph(w,3);
        x.scoreGlyph(b,3);
        x.scoreGlyph(w,3);
        x.scoreGlyph(b,3);
        System.out.println(x.printCiph());
        System.out.println(x.checkCipher());
    }
}
