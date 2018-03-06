
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
        }
        if(r.getAutoKey()){
            score += 30;
            scoreGlyph(pit.getRandGlyph(),n);
        }
        if(r.getAutoGlyphs()){
            for(int i = 0; i<r.numAutoGlyphs()-1; i++){
                score+=15;
                if(!canScore(n)){
                    n++;
                }
                if(n>=3){
                    n = 1;
                }
            }
        }
        return 0;
    }

    public int getTelePoints(){
        int glyphs = 0;
        for(int r = 0; r < 4; r++){
            for(int c = 0; c < 3; c++){
                if(box[r][c] != null){
                    glyphs++;
                }
            }
        }
        int score = (glyphs * 2) + (this.checkColumns() * 15) + (this.checkRows() * 10);
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

    public boolean canScore(int col/**1-2*/){
        int[] boxCount = {rowCount1, rowCount2, rowCount3};
        if(boxCount[col-1] ==0){
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

}
