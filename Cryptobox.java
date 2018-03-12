
/**
 * Write a description of class Cryptobox here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Arrays;
public class Cryptobox
{
    // instance variables - replace the example below with your own
    Glyph[][] box;//0 is top, left
    private boolean  color;//true is red, false is blue
    private boolean robotInZone;
    private boolean isFull;
    private final Glyph w = new Glyph(1);
    private final Glyph b = new Glyph(0);
    private int glyphs;
    private int colOn;
    private int rowCount1;
    private int rowCount2;
    private int rowCount3;
    private int[] row = {rowCount1, rowCount2, rowCount3};
    private int autoScore = 0;
    private int teleScore = 0;
    private final Glyph[][] cipher1 = new Glyph[][]{{w, b, w}, {b, w, b}, {w, b, w}, {b, w, b}};
    private final Glyph[][] cipher2 = new Glyph[][]{{b, w, b}, {w, b, w}, {b, w, b}, {w, b, w}};
    private final Glyph[][] cipher3 = new Glyph[][]{{b, w, b}, {w, b, w}, {w, b, w}, {b, w, b}};
    private final Glyph[][] cipher4 = new Glyph[][]{{w, b, w}, {b, w, b}, {b, w, b}, {w, b, w}};
    private final Glyph[][] cipher5 = new Glyph[][]{{b, w, w}, {b, b, w}, {w, b, b}, {w, w, b}};
    private final Glyph[][] cipher6 = new Glyph[][]{{w, b, b}, {w, w, b}, {b, w, w}, {b, b, w}};
    private final Glyph[][][] ciphers = new Glyph[][][]{cipher1, cipher2, cipher3, cipher4, cipher5, cipher6};
    private GlyphPit pit;
    public Cryptobox(boolean color, GlyphPit g){
        this.color = color;
        box = new Glyph[4][3];
        robotInZone = false;
        isFull = false;
        pit = g;
        colOn = 1;
        rowCount1 = 3;
        rowCount2 = 3;
        rowCount3 = 3;
    }

    public int getAutoPoints(Robot r, int n){//1 is left 3 is right
        int score = 0;
        if(r.getAutoCrypto()){
            score += 15;
            glyphs++;
        }
        if(r.getAutoKey()){
            score += 30;
            scoreGlyph(pit.getRandGlyph(),n);
        }
        if(r.getAutoGlyphs()){
            for(int i = 0; i<r.numAutoGlyphs()-1; i++){
                score+=15;
                scoreGlyph(pit.getRandGlyph(),n);
                glyphs++;
                if(!canScore(n)){
                    n++;
                }
                if(n>=3){
                    n = 1;
                }
            }
        }
        autoScore = score;
        return score;
    }

    public int getTelePoints(){
        int glyphs = 0;
        for(int r = 0; r < 4; r++){
            for(int c = 0; c < 3; c++){
                if(box[r][c] != null){
                    glyphs++;
                    this.glyphs+=glyphs;
                }
            }
        }
        int score = (glyphs * 2) + (this.checkColumns() * 20) + (this.checkRows() * 10);
        if(this.checkCipher()){
            score += 30;
        }
        return score;
    }

    public void updateRows(){
        row[0] = rowCount1;
        row[1] = rowCount2;
        row[2] = rowCount3;
    }
    
    public void updateCols(){
        if(!(canScore(colOn))){
            colOn++;
            if(colOn>3){
                colOn = 1;
            }
        }
    }
    
    public void scoreGlyph(Glyph g, int col){
        if(col == 1){
            box[rowCount1][0] =  g;
            rowCount1--;
        }
        if(col == 2){
            box[rowCount2][1] =  g;
            rowCount2--;
        }
        if(col == 3){
            box[rowCount3][2] =  g;
            rowCount3--;
        }
        updateRows();
        updateCols();
    }

    public void autoFirstGlyph(Robot r){
        if(r.getAutoCrypto()){
            if(r.getAutoKey()){
                scoreGlyph(pit.getRandGlyph(), pit.getCryptoKey());
            }
            scoreGlyph(pit.getRandGlyph(), (int)(Math.random() * 3 + 2));
        }
    }

    public void selfScoreGlyph(Robot r){
        
        
        if(r.getGoForCipher()){
            int wC = whichCipherWorkingOn()-1;
            if(wC>-1){ 
                if(ciphers[wC][row[colOn-1]][colOn-1].equals(w)){
                    scoreGlyph(pit.getWhiteGlyph(), colOn);
                }else if(ciphers[wC][row[colOn-1]][colOn-1].equals(b)){
                    scoreGlyph(pit.getBrownGlyph(), colOn);
                }
            }else{
                if(wC==-2){//empty cipher
                    if(ciphers[r.getTargetCipher()-1][row[colOn-1]][colOn-1].equals(w)){
                        scoreGlyph(pit.getWhiteGlyph(), colOn);
                    }else if(ciphers[r.getTargetCipher()-1][row[colOn-1]][colOn-1].equals(b)){
                        scoreGlyph(pit.getBrownGlyph(), colOn);
                    }
                }else{
                    if(ciphers[r.getTargetCipher()-1][row[colOn-1]][colOn-1].equals(w)){
                        scoreGlyph(pit.getWhiteGlyph(), colOn);
                    }else if(ciphers[r.getTargetCipher()-1][row[colOn-1]][colOn-1].equals(b)){
                        scoreGlyph(pit.getBrownGlyph(), colOn);
                    }
                }
            }
        }else{
            scoreGlyph(pit.getRandGlyph(),colOn);
        }
    } 

    public int checkRows(){
        int counter = 0;
        for(int i = 0; i < 4; i++){
            if(box[i][0] != null && box[i][1] != null && box[i][2] != null){
                counter++;
            }
        }
        return counter;
    }

    public int checkColumns(){
        int counter = 0;
        for(int i = 0; i < 3; i++){
            if(box[0][i] != null && box[1][i] != null && box[2][i] != null && box[3][i] != null){
                counter++;
            }
        }
        return counter;
    }

    public boolean canScore(int col/**1-3*/){
        int[] boxCount = {rowCount1, rowCount2, rowCount3};
        if(boxCount[col-1] ==-1){
            return false;
        }

        return true;
    }

    public boolean checkCipher(){
        isFull = this.checkColumns()==3&&this.checkRows()==4;
        if (!isFull){
            return false;
        }
        return checkCipher1()||checkCipher2()||checkCipher3()||checkCipher4()||
        checkCipher5()||checkCipher6();

    }

    public String whichCiph(){
        if(!isFull){
            return "Not full";
        }

        if(checkCipher1()||checkCipher2()){
            return "Frog Cipher";
        }

        if(checkCipher3()||checkCipher4()){
            return "Bird Cipher";
        }

        if(checkCipher5()||checkCipher6()){
            return "Snake Cipher";
        }

        return "No Cipher";
    }

    public String printCiph(){
        String str = "";
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                if(box[i][j]==null){
                    str += -1;
                }else{
                    str += box[i][j].toStr();
                }
            }
            str+="\n";
        }

        return str;
    }

    private boolean checkCipher1(){
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                if(!box[i][j].equals(cipher1[i][j])){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkCipher2(){
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                if(!box[i][j].equals(cipher2[i][j])){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkCipher3(){
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                if(!box[i][j].equals(cipher3[i][j])){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkCipher4(){
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                if(!box[i][j].equals(cipher4[i][j])){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkCipher5(){
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                if(!box[i][j].equals(cipher5[i][j])){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkCipher6(){
        for(int i = 0; i < box.length; i++){
            for(int j = 0; j < box[i].length; j++){
                if(!box[i][j].equals(cipher6[i][j])){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBoxEmpty(){
        int countNull = 0;
        for(int i = 0; i<4; i++){
            for(int k = 0; k<3; k++){
                if(box[i][k] == null){
                    countNull ++;
                }
            }
        }
        if(countNull==12){
            return true;
        }
        return false;
    }

    public boolean partOfCipher(){

        boolean c1 = partOfCipher1();
        boolean c2 = partOfCipher2();
        boolean c3 = partOfCipher3();
        boolean c4 = partOfCipher4();
        boolean c5 = partOfCipher5();
        boolean c6 = partOfCipher6();

        if(isBoxEmpty()){
            return false;
        }

        return c1||c2||c3||c4||c5||c6;
    }  

    public String cipherWorkingOn(){
        String str = "";
        if(isBoxEmpty()){
            return "Empty Cryptobox";
        }
        if(glyphs>6){
            if(partOfCipher1()||partOfCipher2()){
                return "Frog Cryptobox";
            }
            if(partOfCipher3()||partOfCipher4()){
                return "Bird Cryptobox";
            }
            if(partOfCipher5()||partOfCipher6()){
                return "Snake Cryptobox";
            }
        }
        return "Working on Cryptobox";
    }

    public int whichCipherWorkingOn(){//-1 is empty, 0 is no cipher
        if(isBoxEmpty()){
            return -1;
        }
        
            if(partOfCipher1()){
                return 1;
            }
            if(partOfCipher2()){
                return 2;
            }
            if(partOfCipher3()){
                return 3;
            }
            if(partOfCipher4()){
                return 4;
            }
            if(partOfCipher5()){
                return 5;
            }
            if(partOfCipher6()){
                return 6;
            }
        

        return 0;
    }

    public boolean partOfCipher1(){
        if(isBoxEmpty()){
            return false;
        }

        boolean c = true;
        for(int i = 0; i<4; i++){
            for(int k = 0; k<3; k++){
                if(box[i][k]!=null&&!box[i][k].equals(cipher1[i][k])){
                    c= false;
                }
            }
        }
        return c;
    }

    public boolean partOfCipher2(){
        if(isBoxEmpty()){
            return false;
        }

        boolean c = true;
        for(int i = 0; i<4; i++){
            for(int k = 0; k<3; k++){
                if(box[i][k]!=null&&!box[i][k].equals(cipher2[i][k])){
                    c= false;
                }
            }
        }
        return c;
    }

    public boolean partOfCipher3(){
        if(isBoxEmpty()){
            return false;
        }

        boolean c = true;
        for(int i = 0; i<4; i++){
            for(int k = 0; k<3; k++){
                if(box[i][k]!=null&&!box[i][k].equals(cipher3[i][k])){
                    c= false;
                }
            }
        }
        return c;
    }

    public boolean partOfCipher4(){
        if(isBoxEmpty()){
            return false;
        }

        boolean c = true;
        for(int i = 0; i<4; i++){
            for(int k = 0; k<3; k++){
                if(box[i][k]!=null&&!box[i][k].equals(cipher4[i][k])){
                    c= false;
                }
            }
        }
        return c;
    }

    public boolean partOfCipher5(){
        if(isBoxEmpty()){
            return false;
        }

        boolean c = true;
        for(int i = 0; i<4; i++){
            for(int k = 0; k<3; k++){
                if(box[i][k]!=null&&!box[i][k].equals(cipher5[i][k])){
                    c= false;
                }
            }
        }
        return c;
    }

    public boolean partOfCipher6(){
        if(isBoxEmpty()){
            return false;
        }

        boolean c = true;
        for(int i = 0; i<4; i++){
            for(int k = 0; k<3; k++){
                if(box[i][k]!=null&&!box[i][k].equals(cipher6[i][k])){
                    c= false;
                }
            }
        }
        return c;
    }
}