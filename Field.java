
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
    public Field(){
        pit = new GlyphPit();
        rRCrypto = new Cryptobox(true, pit);
        bRCrypto = new Cryptobox(false, pit);
        bOCrypto = new Cryptobox(false, pit);
        rOCrypto = new Cryptobox(true, pit);
        rRJewelBoard = new JewelBoard(); 
        bRJewelBoard = new JewelBoard(); 
        rOJewelBoard = new JewelBoard(); 
        bOJewelBoard = new JewelBoard();
        rRRelic = new Relic(true, rRCrypto);
        bRRelic = new Relic(false, bRCrypto);
        rORelic = new Relic(true, rOCrypto);
        bORelic = new Relic(false, bOCrypto);
        rRBoard = new BalanceBoard(true);
        bRBoard = new BalanceBoard(false);
        rOBoard = new BalanceBoard(true);
        bOBoard = new BalanceBoard(false);
    }
    public Field(Robot rR, Robot bR, Robot rO, Robot bO){
        pit = new GlyphPit();
        rRCrypto = new Cryptobox(true, pit);
        bRCrypto = new Cryptobox(false, pit);
        bOCrypto = new Cryptobox(false, pit);
        rOCrypto = new Cryptobox(true, pit);
        rRJewelBoard = new JewelBoard(); 
        bRJewelBoard = new JewelBoard(); 
        rOJewelBoard = new JewelBoard(); 
        bOJewelBoard = new JewelBoard();
        rRRelic = new Relic(true, rRCrypto);
        bRRelic = new Relic(false, bRCrypto);
        rORelic = new Relic(true, rOCrypto);
        bORelic = new Relic(false, bOCrypto);
        rRBoard = new BalanceBoard(true);
        bRBoard = new BalanceBoard(false);
        rOBoard = new BalanceBoard(true);
        bOBoard = new BalanceBoard(false);
        rRBot = rR;
        bRBot = bR;
        rOBot = rO;
        bOBot = bO;
    }
    public void setRedRelic(Robot r){
        rRBot = r;
    }
    public void setRedOther(Robot r){
        rOBot = r;
    }
    public void setBlueRelic(Robot r){
        bRBot = r;
    }
    public void setBlueOther(Robot r){
        bRBot = r;
    }
    public void reset(){
        pit = new GlyphPit();
        rRCrypto = new Cryptobox(true, pit);
        bRCrypto = new Cryptobox(false, pit);
        bOCrypto = new Cryptobox(false, pit);
        rOCrypto = new Cryptobox(true, pit);
        rRJewelBoard = new JewelBoard(); 
        bRJewelBoard = new JewelBoard(); 
        rOJewelBoard = new JewelBoard(); 
        bOJewelBoard = new JewelBoard();
        rRRelic = new Relic(true, rRCrypto);
        bRRelic = new Relic(false, bRCrypto);
        rORelic = new Relic(true, rOCrypto);
        bORelic = new Relic(false, bOCrypto);
        rRBoard = new BalanceBoard(true);
        bRBoard = new BalanceBoard(false);
        rOBoard = new BalanceBoard(true);
        bOBoard = new BalanceBoard(false);
    }
    public void autoPlay(){
        
        
    }
}
