import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        Deck myDeck = new Deck();
        myDeck.shuffle();
        System.out.println(myDeck);
        Hand Hal = new Hand();
        Hand player = new Hand();
        int hit = 1;
        int exit = 0;
        int halWins = 0;
        int playerWins = 0;
        int keepPlaying = 0;

        System.out.println("Player's Hand\n\n----------");

        while(exit<=3 && keepPlaying==0){

            player.clear();
            Hal.clear();

            Card temp1 = myDeck.deal();
            System.out.println(temp1);
            Card temp2 = myDeck.deal();
            player.add(temp1);
            player.add(temp2);

            player.showHand();
            System.out.println("Hit=1 or stay=0?");
            hit = console.nextInt();

            while(hit==1 && player.getTotal()<21){
                Card temp = myDeck.deal();
                player.add(temp);
                player.showHand();
                if(player.getTotal()<21){
                    System.out.println("Hit=1 or stay=0?");
                    hit = console.nextInt();
                }
            }

            System.out.println();
            System.out.println("Hal's Hand\n\n----------");

            while(Hal.getTotal()<17){
                Card temp = myDeck.deal();
                Hal.add(temp);

            }
            Hal.showHand();

            System.out.println("\nShow totals:");
            System.out.println("Player's total = " + player.getTotal() + " with " + player.cardsInHand() + " cards.");
            System.out.println("Hal's total = " + Hal.getTotal() + " with " + Hal.cardsInHand() + " cards.");

            if(Hal.getTotal()<=21 && (Hal.getTotal()>=player.getTotal() || player.getTotal()>21)){
                System.out.println("\n**********\nHal Wins\n**********\n");
                halWins++;
            }
            if(player.getTotal()<=21 && (player.getTotal()>Hal.getTotal() || Hal.getTotal()>21)){
                System.out.println("\n**********\nYou win!\n**********\n");
                playerWins++;
            }
            if(player.getTotal()>21 && Hal.getTotal()>21){
                System.out.println("\n**********\nBoth bust\n**********\n");
            }

            System.out.println();
            if(exit!=3){
                System.out.println("Would you like to continue? (0=yes 1=no)");
                keepPlaying = console.nextInt();
            }
            exit++;
        }

        System.out.println("\n********** End of Game Stats ************\n***** Player Wins = " + playerWins + "\n***** Hal wins = " + halWins + "\n******************************************");


    }
}
