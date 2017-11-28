import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class Deck here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Deck
{
    private ArrayList<Card> deck;
    private int topValue;


    public Deck(){
        deck = new ArrayList<Card>(52);
        for(int i = 0; i<52;i++){
            deck.add(new Card(this.getFace(i),this.getSuit(i),this.getValue(i)));
        }
    }

    public void shuffle(){
        /*ArrayList<Card> tempList = new ArrayList<Card>();
        for(int x=0;x<deck.size()-1;x++){
            tempList.add(deck.get((int)(Math.random()*51+1)));
            deck.remove(x);
        }
        deck=tempList;*/
        Collections.shuffle(deck);
    }

    public Card deal(){
        Card temp = deck.get(0);
        deck.remove(0);
        deck.add(temp);
        return temp;
    }

    private char getFace(int num){
        char resutlt;
        switch (num%13){
            case 0: resutlt='2';break;
            case 1: resutlt='3';break;
            case 2: resutlt='4';break;
            case 3: resutlt='5';break;
            case 4: resutlt='6';break;
            case 5: resutlt='7';break;
            case 6: resutlt='8';break;
            case 7: resutlt='9';break;
            case 8: resutlt='T';break;
            case 9: resutlt='J';break;
            case 10: resutlt='Q';break;
            case 11: resutlt='K';break;
            case 12: resutlt='A';break;
            default: resutlt='x';break;
        }
        return resutlt;
    }

    private char getSuit(int num){
        char result;
        switch((num/13)%4){
            case 0: result = 'S'; break;
            case 1: result = 'H'; break;
            case 2: result = 'C'; break;
            case 3: result = 'D'; break;
            default: result = 'X'; break;
        }
        return result;
    }

    private int getValue(int number){
        int result = (number % 13) +2;
        if(result > 10){
            result = 10;
            if(number%13==12){
                result=11;
            }
        }
        return result;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(int x=0;x<deck.size();x++){
            sb.append(deck.get(x).toString()+"\n");
        }
        return sb.toString();
    }
}
