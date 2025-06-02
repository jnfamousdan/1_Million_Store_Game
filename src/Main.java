import Package_StoreGame.Objects.Merchant;
import Package_StoreGame.Objects.User;
import Package_StoreGame.core.Handler;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        //GLOBAL VARIABLES FOR THIS MAIN CLASS
        Scanner scanner = new Scanner(System.in);
        boolean isTrading = false; // Used when Purchasing/Selling
        boolean doRepeatNextDay = false; // Used to determine if we need to repeat the day.
        int day = 0;
        
        User mainPlayer = Handler.getPlayerName(scanner);
        Merchant merchant = new Merchant("Teh merchant");

        //########################################################################################################
        //  Main Section - Every time a day passes, the merchant will come across a store with random pricing/apple count
        //  The user's goal is to gain the biggest profits and reach 1 million dollars!
        //--------------------------------------------------------------------------------------------------------

        while(!Handler.doesPlayerHaveMoreThan1Mill(mainPlayer)) {
            // Next Day!
            merchant.resetInventoryForNextDay(mainPlayer);
            day ++;
            
            // Day_Message Portion
            while(!doRepeatNextDay) {
                Handler.printDayMessage(day, merchant, mainPlayer);
                //Prompt User
                switch(scanner.nextInt()){
                    case 1:
                        Handler.purchaseApples(scanner, mainPlayer, merchant);
                        break;
                    case 2:
                        Handler.sellApples(scanner, mainPlayer, merchant);
                        break;
                    case 3: // Proceed to the next day
                        System.out.println("Proceeding to the next day...");
                        doRepeatNextDay = true;
                        break;
                    case 4: // Exit the game
                        System.out.println("Exiting the Apple game");
                        System.out.println("Thanks for playing, " + mainPlayer.getName() + "!");
                        System.exit(0);
                    default:
                        System.out.println("[[The entered value is not a valid input!]]");
                        System.exit(0);
                }
            }
            doRepeatNextDay = false;
        }
    }

    public static void SkipLines(int j){
        for(int i=1; i<=j;i++){
            System.out.println(" ");
        }
    }
}
