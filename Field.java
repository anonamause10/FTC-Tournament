
/**
 * Write a description of class Field here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Field
{
    // instance variables - replace the example below with your own
    private GlyphPit pit;
    private Cryptobox rRCrypto;
    private Cryptobox bRCrypto;
    private Cryptobox rOCrypto;
    private Cryptobox bOCrypto;
    private JewelBoard rRJewelBoard;
    private JewelBoard bRJewelBoard;
    private JewelBoard rOJewelBoard;
    private JewelBoard bOJewelBoard;
    private Relic rRRelic;
    private Relic bRRelic;
    private Relic rORelic;
    private Relic bORelic;
    private BalanceBoard rRBoard;
    private BalanceBoard bRBoard;
    private BalanceBoard rOBoard;
    private BalanceBoard bOBoard;
    private Robot rRBot;
    private Robot bRBot;
    private Robot rOBot;
    private Robot bOBot;
    private Team rRTeam;
    private Team bRTeam;
    private Team rOTeam;
    private Team bOTeam;
    private int redScore;
    private int blueScore;
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
        redScore = 0;
        blueScore = 0;
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
        redScore = 0;
        blueScore = 0;
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
        redScore = 0;
        blueScore = 0;
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
        redScore+=rRBot.getScore() + rOBot.getScore();
        rRBot.resetScore(); rOBot.resetScore();
        blueScore+=bRBot.getScore() + bOBot.getScore();
        bRBot.resetScore(); bOBot.resetScore();

    }

    public void telePlay(){
        boolean rRRelReady = false;
        boolean rORelReady = false;
        boolean bRRelReady = false;
        boolean bORelReady = false;
        int rRTargetTime = 0;
        int rOTargetTime = 0;
        int bRTargetTime = 0;
        int bOTargetTime = 0;

        for(int i = 0; i < 120; i++){
            if(i == rRTargetTime){
                if(!rRCrypto.selfScoreGlyph(rRBot)){

                    if(rRRelReady){
                        if(!rRRelic.score(rRBot)){
                            rRTargetTime += rRBot.getAvgTimePerRelic()/2;

                        }else{
                            rRRelReady=false;
                        }
                    }

                    if(rRRelic.canBeScored(i)){
                        rRTargetTime+=rRBot.getAvgTimePerRelic();
                        rRRelReady = true;
                    }
                }else{
                    rRTargetTime+=rRBot.getTimeTillNextGlyph();
                }
            }
            if(i == rOTargetTime){
                if(!rOCrypto.selfScoreGlyph(rOBot)){

                    if(rORelReady){
                        if(!rORelic.score(rOBot)){
                            rOTargetTime += rOBot.getAvgTimePerRelic()/2;

                        }else{
                            rORelReady=false;
                        }
                    }

                    if(rORelic.canBeScored(i)){
                        rOTargetTime+=rOBot.getAvgTimePerRelic();
                        rORelReady = true;
                    }
                }else{
                    rOTargetTime+=rOBot.getTimeTillNextGlyph();
                }
            }
            if(i == bRTargetTime){
                if(!bRCrypto.selfScoreGlyph(bRBot)){

                    if(bRRelReady){
                        if(!bRRelic.score(bRBot)){
                            bRTargetTime += bRBot.getAvgTimePerRelic()/2;

                        }else{
                            bRRelReady=false;
                        }
                    }

                    if(bRRelic.canBeScored(i)){
                        bRTargetTime+=bRBot.getAvgTimePerRelic();
                        bRRelReady = true;
                    }
                }else{
                    bRTargetTime+=bRBot.getTimeTillNextGlyph();
                }
            }
            if(i == bOTargetTime){
                if(!bOCrypto.selfScoreGlyph(rOBot)){

                    if(bORelReady){
                        if(!bORelic.score(rOBot)){
                            bOTargetTime += rOBot.getAvgTimePerRelic()/2;

                        }else{
                            bORelReady=false;
                        }
                    }

                    if(bORelic.canBeScored(i)){
                        bOTargetTime+=bOBot.getAvgTimePerRelic();
                        bORelReady = true;
                    }
                }else{
                    bOTargetTime+=bOBot.getTimeTillNextGlyph();
                }
            }
        }
        redScore+=rRCrypto.getTelePoints()+rOCrypto.getTelePoints()+
        rRRelic.getPointValue(120)+rORelic.getPointValue(120);
        blueScore+=bRCrypto.getTelePoints()+bOCrypto.getTelePoints()+
        bRRelic.getPointValue(120)+bORelic.getPointValue(120);
    }
    
    public int getRedScore(){
        return redScore;
    }
    
    public int getBlueScore(){
        return blueScore;
    }
}
