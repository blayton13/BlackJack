/**
 * This class holds a Card and the values normally associated with cards. These include face, suit, and value of the
 * card. These fields are made accessible through accessor methods in the class. Cards should only be created through
 * the Deck class when a new deck is created.
 *
 * @author Blayton Thomas
 * @version 11/28/17
 */

public class Card
{
    private char face;  //face of the card
    private char suit;  //suit of the card
    private int value;  //value the card has

    /**
     * Default constructor for Card class
     * sets  fields to default values that aren't real cards
     */
    public Card(){
        face='x';
        suit='x';
        value=-1;
    }

    /**
     * Overloaded constructor for Card class. takes in face, suit, and value as parameters to be stored in fields
     *
     * @param f face of card
     * @param s suit of card
     * @param v value of card
     */
    public Card(char f,char s,int v){
        face=f;
        suit=s;
        value=v;
    }

    /**
     * Accessor method for value
     * @return value of card
     */
    public int getValue(){
        return value;
    }

    /**
     * Accessor method for face
     * @return face of card
     */
    public char getFace(){
        return this.face;
    }

    /**
     * Accessor method for suit
     * @return suit of card
     */
    public char getSuit(){
        return this.suit;
    }

    /**
     * Compare to method to determine if a card's value is greater than another.
     * @param other Card reference to compare the give Card to
     * @return returns 1 if greater, -1 if lesser, 0 if equal.
     */
    public int compareTo(Card other){
        if(this.getValue()>other.getValue()) return 1;
        else if(this.getValue()<other.getValue()) return -1;
        else return 0;
    }

    /**
     * Takes suit character and returns string representing the normal card suits. Makes toString easier to read
     * @return String representing suit
     */
    public String stringSuit(){
        switch (suit) {
            case 'D':
                return "Diamonds";
            case 'S':
                return "Spades";
            case 'C':
                return "Clubs";
            case 'H':
                return "Hearts";
        }
        return "error (suit not recognized)";
    }

    /**
     * Takes face character and returns string representing the normal card faces. Makes toString easier to read
     * @return String representing face
     */
    public String stringFace(){
        switch (face) {
            case 'K':
                return "King";
            case 'Q':
                return "Queen";
            case 'A':
                return "Ace";
            case 'J':
                return "Jack";
        }
        return String.valueOf(value);
    }

    /**
     * Returns textual representation of Card.
     * @return textual representation of Card.
     */
    public String toString(){
        return this.stringFace() + " " + this.stringSuit();
    }
}
