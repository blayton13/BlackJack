/**
 * This class holds a hand. It is used for both the player and dealer in the black jack program. A hand contains an
 * arraylist of cards. This allows easy adding and removal of cards. Cards can be added, and the hand can be cleared.
 * This class also provides the calculation for the total value in the game of Black Jack and accounts for Ace cards
 * ability to be worth 1 or 11 points.
 *
 * @author Blayton Thomas
 * @version 11/28/17
 */

import java.util.*;

public class Hand {

    private ArrayList<Card> cardsList;

    /**
     * Default Constructor for Hand. Initializes the ArrayList to allow user to add Cards.
     */
    public Hand(){
        cardsList = new ArrayList<Card>();
    }

    /**
     * Clears all the Cards from the Hand to make it empty
     */
    public void clear(){
        cardsList.clear();
    }

    /**
     * Takes a Card address as parameter and adds it to the hand.
     * @param card Card to add to the hand
     */
    public void add(Card card){
        cardsList.add(card);
    }

    /**
     * Returns the total number of cards that the hand holds
     * @return total cards in hand
     */
    public int cardsInHand(){
        return cardsList.size();
    }

    /**
     * Calculates and returns the total value of the hand in the game of Black Jack. This also accounts for aces
     * ability to be 1 or 11
     *
     * @return value of hand in blackjack
     */
    public int getTotal(){
        int total = 0;  //integer to hold total value of all cards in hand
        int aces = 0;   //total aces to allow subtraction of needed
        for(int x=0;x<cardsList.size();x++){
            if(cardsList.get(x).getFace()=='A') aces++;
            total+=cardsList.get(x).getValue();
        }
        /*if the hand contains aces, and the total value is over 21, the program will decrease total until less than 21
        or number of aces runs out*/
        while(total>21 && aces>0){
            total-=10;
            aces--;
        }
        return total;
    }

    /**
     * To String method provides textual representation of hand
     * @return textual representation of hand
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int x=0;x<cardsList.size();x++){
            sb.append(cardsList.get(x));
            if(x<cardsList.size()-1) sb.append(" - ");
        }
        return sb.toString();
    }

}
