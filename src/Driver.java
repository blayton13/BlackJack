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
        Hand player = new Hand();

        int playerWins=0;   //stores total number of player wins
        int cpuWins=0;      //stores total number of dealer wins
        int contPlay=0;     //stores option of user to continue playing
        int hitStay = 1;    //stores option of user wanting to hit or stay

        do{
            player.clear();
            cpu.clear();
            myDeck.shuffle();
            hitStay=1;
            while(player.getTotal()<21 && hitStay==1){
                player.add(myDeck.deal());
                System.out.println(player.toString());
                System.out.println("Your total is currently " + player.getTotal());
                if(player.getTotal()<21) {
                    System.out.println("\nHit=1 or stay=0?");
                    hitStay = console.nextInt();
                    console.nextLine();
                }
            }


            while(cpu.getTotal()<17) cpu.add(myDeck.deal());
            System.out.println("CPU's hand:\n"+cpu.toString());
            //System.out.println("CPU's total is  "+cpu.getTotal());

            System.out.println("\nShow totals:");
            System.out.println("Player's total = " + player.getTotal() + " with " + player.cardsInHand() + " cards.");
            System.out.println("CPU's total = " + cpu.getTotal() + " with " + cpu.cardsInHand() + " cards.");

            if(cpu.getTotal()<=21 && (cpu.getTotal()>player.getTotal() || player.getTotal()>21)){
                System.out.println("\n**********\nCPU Wins\n**********\n");
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

            System.out.println("Would you like to continue playing? 0=yes 1=no");
            contPlay=console.nextInt();
        }while(contPlay==0);

        System.out.println("\n********** End of Game Stats ************\n***** Player Wins = " + playerWins + "\n***** CPU wins = " + cpuWins + "\n******************************************");


    }
}
