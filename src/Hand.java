import java.util.*;

public class Hand {

    private ArrayList<Card> cardsList;

    public Hand(){
        cardsList = new ArrayList<Card>();
    }

    public void clear(){
        cardsList=new ArrayList<Card>();
    }

    public void add(Card card){
        cardsList.add(card);
    }

    public String showHand(){
        StringBuilder sb = new StringBuilder();
        for(int x=0;x<cardsList.size();x++){
            sb.append(cardsList.get(x)+ " - ");
        }
        return sb.toString();
    }

    public int cardsInHand(){
        return cardsList.size();
    }

    public int getTotal(){
        int total = 0;
        for(int x=0;x<cardsList.size();x++){
            total+=cardsList.get(x).getValue();
        }
        return total;
    }

}
