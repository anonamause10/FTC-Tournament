
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
    public Team rRTeam;
    public Team bRTeam;
    public Team rOTeam;
    public Team bOTeam;
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

    public Field(Team rR, Team bR, Team rO, Team bO){
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
        rRBot = rR.getRobot();
        bRBot = bR.getRobot();
        rOBot = rO.getRobot();
        bOBot = bO.getRobot();
        rRTeam = rR;
        bRTeam = bR;
        rOTeam = rO;
        bOTeam = bO;
    }

    public void setRedRelic(Team t){
        rRTeam = t;
        rRBot = t.getRobot();
    }

    public void setRedOther(Team t){
        rOTeam = t;
        rOBot = t.getRobot();
    }

    public void setBlueRelic(Team t){
        bRTeam = t;
        bRBot = t.getRobot();
    }

    public void setBlueOther(Team t){
        bRTeam = t;
        bRBot = t.getRobot();
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
        rRJewelBoard.knockOff(rRBot);
        rOJewelBoard.knockOff(rOBot);
        bRJewelBoard.knockOff(bRBot);
        bOJewelBoard.knockOff(bOBot);
        if(rRJewelBoard.getPointValue(5)<0){
            bRBot.incScore(30);
        }else{
            rRBot.incScore(rRJewelBoard.getPointValue(5));
        }
        if(bRJewelBoard.getPointValue(5)<0){
            rRBot.incScore(30);
        }else{
            bRBot.incScore(rRJewelBoard.getPointValue(5));
        }
        if(rOJewelBoard.getPointValue(5)<0){
            bOBot.incScore(30);
        }else{
            rOBot.incScore(rRJewelBoard.getPointValue(5));
        }
        if(bOJewelBoard.getPointValue(5)<0){
            rOBot.incScore(30);
        }else{
            bOBot.incScore(rRJewelBoard.getPointValue(5));
        }
        rRBot.incScore(rRCrypto.getAutoPoints(rRBot));
        rOBot.incScore(rRCrypto.getAutoPoints(rOBot));
        bRBot.incScore(rRCrypto.getAutoPoints(bRBot));
        bOBot.incScore(rRCrypto.getAutoPoints(bOBot));
    }
    
    public void telePlay(){
        for(int i = 0; i < 120; i++){
            if(i%rRBot.getAvgTimePerGlyph()==0){
                rRCrypto.selfScoreGlyph(rRBot);
            }
            if(i%bRBot.getAvgTimePerGlyph()==0){
                bRCrypto.selfScoreGlyph(bRBot);
            }
            if(i%rOBot.getAvgTimePerGlyph()==0){
                rOCrypto.selfScoreGlyph(rOBot);
            }
            if(i%bOBot.getAvgTimePerGlyph()==0){
                bOCrypto.selfScoreGlyph(bOBot);
            }
            
            
        }
    }
}
