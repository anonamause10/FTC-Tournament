
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
    private Glyph w = new Glyph(1);
    private Glyph b = new Glyph(0);
    private int glyphs;
    private int rowCount1 = 3;
    private int rowCount2 = 3;
    private int rowCount3 = 3;
    private int autoScore = 0;
    private int teleScore = 0;
    private final Glyph[][] cipher1 = new Glyph[][]{{w, b, w}, {b, w, b}, {w, b, w}, {b, w, b}};
    private final Glyph[][] cipher2 = new Glyph[][]{{b, w, b}, {w, b, w}, {b, w, b}, {w, b, w}};
    private final Glyph[][] cipher3 = new Glyph[][]{{b, w, b}, {w, b, w}, {w, b, w}, {b, w, b}};
    private final Glyph[][] cipher4 = new Glyph[][]{{w, b, w}, {b, w, b}, {b, w, b}, {w, b, w}};
    private final Glyph[][] cipher5 = new Glyph[][]{{b, w, w}, {b, b, w}, {w, b, b}, {w, w, b}};
    private final Glyph[][] cipher6 = new Glyph[][]{{w, b, b}, {w, w, b}, {b, w, w}, {b, b, w}};
    private GlyphPit pit;
    public Cryptobox(boolean color, GlyphPit g){
        this.color = color;
        box = new Glyph[4][3];
        robotInZone = false;
        isFull = false;
        pit = g;
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
    }

    public void selfScoreGlyphs(Robot r){
        
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

    public boolean isCipherEmpty(){
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
        
        if(isCipherEmpty()){
            return false;
        }

        
        return c1||c2||c3||c4||c5||c6;
    }  
    
    public String cipherWorkingOn(){
        String str = "";
        if(isCipherEmpty()){
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
    
    public boolean partOfCipher1(){
        if(isCipherEmpty()){
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
        if(isCipherEmpty()){
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
        if(isCipherEmpty()){
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
        if(isCipherEmpty()){
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
        if(isCipherEmpty()){
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
        if(isCipherEmpty()){
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
