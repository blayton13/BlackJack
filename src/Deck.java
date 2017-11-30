/**
 * This class holds a deck. The default constructor populates a 52 card deck with the proper card numbers, faces, and suits. There are methods that allow the user to access and mutate the
 * deck including the ability to shuffle and getTopCard.
 *
 * @author Blayton Thomas
 * @version 11/28/17
 */

import java.util.*;

public class Deck
{
    private ArrayList<Card> deck;       //arraylist to store cards of deck, easy to manipulate
    private int topValue;               //

    /**
     * Default constructor. Populates a 52 card deck with the correct cards.
     */
    public Deck(){
        deck = new ArrayList<Card>(52);
        for(int i = 0; i<52;i++){
            deck.add(new Card(this.getFace(i),this.getSuit(i),this.getValue(i)));
        }
        int topValue = deck.get(0).getValue();
    }

    /**
     * This method shuffles the Arraylist deck in order to get a less predictable getTopCard
     */
    public void shuffle(){
        Random rand = new Random();
        int cardOneLocation;
        int cardTwoLocation;
        Card temp;
        for(int x=0; x<1000; x++){
            cardOneLocation=rand.nextInt(51)+1;
            cardTwoLocation=rand.nextInt(51)+1;
            temp = deck.get(cardOneLocation);
            deck.set(cardOneLocation,deck.get(cardTwoLocation));
            deck.set(cardTwoLocation,temp);
        }
        topValue=deck.get(0).getValue();
    }

    /**
     * The getTopCard method returns a card that comes off the top of the deck. When a card is taken from the top, it is placed at the bottom
     *
     * @return Card from the top of the deck
     */
    public Card getTopCard(){
        Card temp = deck.get(0);
        deck.remove(0);
        deck.add(temp);
        topValue=deck.get(0).getValue();
        return temp;
    }

    /**
     * The getFace method is a private method used in the population of the deck of cards. It ensures that there
     * are a correct number of each face in the deck.
     *
     * @param num sequence of card that determines face
     * @return character representing the face value whether it be a number of letter
     */
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

    /**
     * The getSuit method is a private method used in the population of the deck of cards. It ensures that there
     * are a correct number of each suit in the deck.
     *
     * @param num sequence of card that determines suit
     * @return character representing the suit
     */
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

    /**
     * The getValue returns the value of the card. Number cards return their value, face cards are worth 10, ace is
     * defualt to 11, but is accounted for 1 in the Hand class
     *
     * @param number sequence of the card in deck
     * @return value the the card has
     */
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

    /**
     * To String method, provides textual representation of the object
     *
     * @return textual representation of the deck of cards.
     */
    public String toString(){
        StringBuilder sb = new StringBuilder("");
        for(int x=0;x<deck.size();x++){
            sb.append(deck.get(x).toString()+"\n");
        }
        return sb.toString();
    }
}
