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
                boolean Can_Purchase;
                String Msg_1;
                String Msg_2;
                switch(scanner.nextInt()){
                    case 1:
                        Msg_1 = "merchant or you cannot afford that... Please try another value.";
                        Msg_2 = "How many Apples would you like to purchase? Enter 0 to return...";
                        Can_Purchase = true;

                        while(!isTrading) {
                            SkipLines(100);
                            System.out.println("-------------------------------------------------");
                            System.out.println(merchant.getName() + " has " + merchant.getApple_Inventory() + " apples.");
                            System.out.println("The current price is " + merchant.getPrice());
                            System.out.println(" ");
                            System.out.println("Your balance is: $" + mainPlayer.getBalance());
                            System.out.println("Apple balance is: " + mainPlayer.getInventory_Apple());
                            System.out.println(" ");

                            int Max_Purchase;
                            if(merchant.getApple_Inventory() < (mainPlayer.getBalance() / merchant.getPrice())){
                                Max_Purchase = merchant.getApple_Inventory();
                            }else{
                                Max_Purchase = mainPlayer.getBalance() / merchant.getPrice();
                            }

                            System.out.println("You may purchase up to " + Max_Purchase);
                            System.out.println("-------------------------------------------------");
                            if(Can_Purchase){
                                System.out.println(Msg_2);
                            }else{
                                System.out.println(Msg_1);
                                Can_Purchase = true;
                            }
                            Scanner Input_Purchase = new Scanner(System.in);

                            int Input_2 = Input_Purchase.nextInt();

                            if(Input_2 == 0){   //if the input is zero, we can exit.
                                isTrading = true;
                            }else if( Input_2 > merchant.getApple_Inventory()) {    //if the entered qty is higher than what the merchant has, cant
                                Can_Purchase = false;
                            }else if(mainPlayer.getBalance() - (Input_2 * merchant.getPrice()) < 0){    //if the user balance will result to become low, cant
                                Can_Purchase = false;
                            }else{  //At this point, we can process the transaction
                                merchant.setApple_Inventory(merchant.getApple_Inventory() - Input_2);
                                mainPlayer.setInventory_Apple(mainPlayer.getInventory_Apple() + Input_2);

                                mainPlayer.setBalance(mainPlayer.getBalance() - (Input_2 * (merchant.getPrice())));
                            }
                        }
                        isTrading = false;
                        break;
                    case 2:
                        Msg_1 = "merchant or you cannot afford that... Please try another value.";
                        Msg_2 = "How many Apples would you like to sell? Enter 0 to return...";
                        Can_Purchase = true;

                        while(!isTrading) {
                            SkipLines(100);
                            System.out.println("-------------------------------------------------");
                            System.out.println(merchant.getName() + " has " + merchant.getApple_Inventory() + " apples.");
                            System.out.println("The current price is $" + merchant.getPrice());
                            System.out.println(" ");
                            System.out.println("Your balance is: $" + mainPlayer.getBalance());
                            System.out.println("Apple balance is: " + mainPlayer.getInventory_Apple());
                            System.out.println("-------------------------------------------------");
                            if(Can_Purchase){
                                System.out.println(Msg_2);
                            }else{
                                System.out.println(Msg_1);
                                Can_Purchase = true;
                            }
                            Scanner Input_Purchase = new Scanner(System.in);

                            int Input_2 = Input_Purchase.nextInt();

                            if(Input_2 == 0){   //if the input is zero, we can exit.
                                isTrading = true;
                            }else if( Input_2 > mainPlayer.getInventory_Apple()) {    //if the entered qty is higher than what the user has, cant
                                Can_Purchase = false;
                            }else{  //At this point, we can process the transaction
                                merchant.setApple_Inventory(merchant.getApple_Inventory() + Input_2);
                                mainPlayer.setInventory_Apple(mainPlayer.getInventory_Apple() - Input_2);

                                mainPlayer.setBalance(mainPlayer.getBalance() + (Input_2 * (merchant.getPrice())));
                            }
                        }
                        isTrading = false;
                        break;
                    case 3: // Proceed to the next day
                        System.out.println("Proceeding to the next day...");
                        doRepeatNextDay = true;
                        break;
                    case 4: // Exit the game
                        doExit = true;
                        doRepeatNextDay = true;
                        System.out.println("Exiting the Apple game");
                        System.out.println("Thanks for playing, " + mainPlayer.getName() + "!");
                        break;
                    default:
                        System.out.println("[[The entered value is not a valid input!]]");
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
