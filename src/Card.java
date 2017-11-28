
/**
 * Write a description of class Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Card
{
    private char face;
    private char suit;
    private int value;
    
    public Card(){
        face='x';
        suit='x';
        value=-1;
    }
    
    public Card(char f,char s,int v){
        face=f;
        suit=s;
        value=v;
    }

    public int getValue(){
        return value;
    }

    public char getFace(){
        return face;
    }

    public String toString(){
        return "Face: " +face+"\tSuit: "+suit+"\tValue: "+value;
    }
}
