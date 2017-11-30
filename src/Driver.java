/**
 * This class is the driver for the game of Black Jack 21. The user plays against the dealer who is named 'CPU'. The
 * player is dealt a card and it is placed in their hand. As long as they choose to and their total is less than 21,
 * they can take a hit, or another card. When the user is done with their turn, the cpu/dealer hits while less that 17.
 * Whoever has the higher value and is less than or equal to 21 wins. If the player and dealer tie, it is a push and no
 * wins are awarded. The user can play as many times as they wish. When the user decides they are done, the total wins
 * for the dealer and player are displayed.
 *
 * @author Blayton Thomas
 * @version 11/28/17
 */

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Deck myDeck = new Deck();
        myDeck.shuffle();
        Hand cpu = new Hand();      //dealer's hand, used to store dealer's cards
        Hand player = new Hand();   //player's hand, used to store player's cards

        int playerWins=0;   //stores total number of player wins
        int cpuWins=0;      //stores total number of dealer wins
        int contPlay=0;     //stores option of user to continue playing
        int hitStay = 1;    //stores option of user wanting to hit or stay

        System.out.println("---Welcome to Black Jack!---\n");

        do{
            player.clear();     //clears both hands for a new game of blackjack
            cpu.clear();
            myDeck.shuffle();   //shuffles deck of cards so that the game isn't predictable
            hitStay=1;
            player.add(myDeck.getTopCard());
            cpu.add(myDeck.getTopCard());
            while((player.getTotal()<21 && hitStay==1 || cpu.getTotal()<17 && hitStay==0) && (player.getTotal()<21 && cpu.getTotal()<21)){
                //deals player his first card
                System.out.println("Your hand:");
                if(hitStay==1) player.add(myDeck.getTopCard());
                System.out.println(player.toString());
                System.out.println("Your total is currently " + player.getTotal());
                //only lets the player hit or stay if total is less than 21
                if(cpu.getTotal()<17){
                    System.out.println("\nDealer's turn (press enter)");
                    cpu.add(myDeck.getTopCard());
                    console.nextLine();
                }
                else{
                    System.out.println("\nDealer is staying (press enter)\n");
                    console.nextLine();
                }
                System.out.println("Dealer's hand:\n"+cpu.toString());
                System.out.println("Dealer's total = "+cpu.getTotal());
                if(player.getTotal()<21) {
                    System.out.println("\nHit=1 or stay=0?");
                    hitStay = console.nextInt();
                    console.nextLine();
                }

            }

            //displays totals of player and dealer hands
            System.out.println("\nShow totals:");
            System.out.println("Player's total = " + player.getTotal() + " with " + player.cardsInHand() + " cards.");
            System.out.println("Dealer's total = " + cpu.getTotal() + " with " + cpu.cardsInHand() + " cards.");

            //if, else if statements to determine the outcome of the blackjack game
            if(cpu.getTotal()<=21 && (cpu.getTotal()>player.getTotal() || player.getTotal()>21)){
                System.out.println("\n**********\nDealer Wins\n**********\n");
                cpuWins++;
            }
            else if(player.getTotal()<=21 && (player.getTotal()>cpu.getTotal() || cpu.getTotal()>21)){
                System.out.println("\n**********\nYou win!\n**********\n");
                playerWins++;
            }
            else if(player.getTotal()>21 && cpu.getTotal()>21){
                System.out.println("\n**********\nBoth bust\n**********\n");
            }
            else System.out.println("\n**********\nPush (tie)\n**********\n");

            //asks the user if they would like to continue playing black jack
            System.out.println("Would you like to continue playing? 0=yes 1=no");
            contPlay=console.nextInt();
            console.nextLine();
        }while(contPlay==0);

        System.out.println("\n********** End of Game Stats ************\n***** Player Wins = " + playerWins + "\n***** Dealer wins = " + cpuWins + "\n******************************************");


    }
}
