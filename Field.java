
/**
 * Write a description of class Field here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Field
{
    // instance variables - replace the example below with your own
    public GlyphPit pit;
    public Cryptobox rRCrypto;
    public Cryptobox bRCrypto;
    public Cryptobox rOCrypto;
    public Cryptobox bOCrypto;
    public JewelBoard rRJewelBoard;
    public JewelBoard bRJewelBoard;
    public JewelBoard rOJewelBoard;
    public JewelBoard bOJewelBoard;
    public Relic rRRelic;
    public Relic bRRelic;
    public Relic rORelic;
    public Relic bORelic;
    public BalanceBoard rRBoard;
    public BalanceBoard bRBoard;
    public BalanceBoard rOBoard;
    public BalanceBoard bOBoard;
    public Robot rRBot;
    public Robot bRBot;
    public Robot rOBot;
    public Robot bOBot;
    
    public Field(Robot rR, Robot bR, Robot rO, Robot bO){
        pit = new GlyphPit();
        rRCrypto = new Cryptobox(true);
        bRCrypto = new Cryptobox(false);
        bOCrypto = new Cryptobox(false);
        rOCrypto = new Cryptobox(true);
        rRJewelBoard = new JewelBoard(true); 
        bRJewelBoard = new JewelBoard(false); 
        rOJewelBoard = new JewelBoard(true); 
        bOJewelBoard = new JewelBoard(false);
        rRRelic = new Relic(true);
        bRRelic = new Relic(false);
        rORelic = new Relic(true);
        bORelic = new Relic(false);
        rRBoard = new BalanceBoard(true);
        bRBoard = new BalanceBoard(false);
        rOBoard = new BalanceBoard(true);
        bOBoard = new BalanceBoard(false);
        rRBot = rR;
        bRBot = bR;
        rOBot = rO;
        bOBot = bO;
    }
    
    
}
