import Package_StoreGame.Store;
import Package_StoreGame.User;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //########################################################################################################
        //  Pre-Logic Stuff : Variables and User Name Prompt
        //--------------------------------------------------------------------------------------------------------
        //Declare stuff needed
        boolean Flag_1 = false; //Flag is used in the while section
        boolean Flag_2 = false; // Used when Purchasing/Selling
        boolean Flag_3 = false; // Used to determine if we need to repeat the day.

        int Day = 0;
        String Day_Message;

        Store Merchant = new Store("Teh Merchant");
        Random R = new Random();
        int Price_Apple_Low = 1;
        int Price_Apple_High = 100;
        int QTY_Apple_Low = 0;
        int QTY_Apple_High = 10_000;

        //Get the username
        SkipLines(100);

        System.out.println("--------------------------------------------------------");
        System.out.println("Hello new Player, please enter your name below");
        System.out.println(" ");
        System.out.println("Also, to win the game, you must reach 1 million dollars");
        System.out.println("--------------------------------------------------------");

        SkipLines(7);

        Scanner Scan_1 = new Scanner(System.in);
        String input_1 = Scan_1.nextLine();

        User User_1 = new User(input_1);
        User_1.setBalance(100);
        User_1.setInventory_Apple(0);

        //########################################################################################################
        //  Main Section - Every time a day passes, the merchant will come across a store with random pricing/apple count
        //  The user's goal is to gain the biggest profits and reach 1 million dollars!
        //--------------------------------------------------------------------------------------------------------
        while(!Flag_1) {
            //Day Counter
            Day = Day + 1;

            if(Day == 1){
                Day_Message = "Welcome to the Apple Game, "+ User_1.getName() + "! It is the first day of your journey.";
            }else{
                Day_Message = "Apple Gainz Day Number: " + Day;
            }
            // Get the Store's Apple pricing today and qty
            QTY_Apple_High = User_1.getBalance() /2 ;
            if (QTY_Apple_High <10_000) QTY_Apple_High = 10_000;

            Merchant.setApple_Inventory(R.nextInt(QTY_Apple_High- QTY_Apple_Low) + QTY_Apple_Low);
            Merchant.setPrice(R.nextInt(Price_Apple_High-Price_Apple_Low) + Price_Apple_Low);

            // Day_Message Portion
            while(!Flag_3) {
                SkipLines(100);

                System.out.println("-------------------------------------------------");
                System.out.println(Day_Message);
                System.out.println(" ");

                //Output the Merchant's Attributes
                System.out.println(Merchant.getName() + "'s total apples are " + Merchant.getApple_Inventory());
                System.out.println("The price of the Apple today is $" + Merchant.getPrice());

                //  Finish the remainder of the message with the User's Input/Details
                System.out.println(" ");
                System.out.println("Enter a value below to represent your action:");
                System.out.println("1 = Purchase Apples");
                System.out.println("2 = Sell Apples");
                System.out.println("3 = Next Day");
                System.out.println("4 = Exit Game");
                System.out.println(" ");
                System.out.println("You currently have " + User_1.getInventory_Apple() + " apples!");
                System.out.println("Your current balance is $" + User_1.getBalance());
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("Please enter your next action");

                //Prompt User
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();

                //Take a look at the input
                if (input == 1) {   //This is the Purchase Option
                    String Msg_1 = "Merchant or you cannot afford that... Please try another value.";
                    String Msg_2 = "How many Apples would you like to purchase? Enter 0 to return...";
                    boolean Can_Purchase = true;

                    while(!Flag_2) {
                        SkipLines(100);
                        System.out.println("-------------------------------------------------");
                        System.out.println(Merchant.getName() + " has " + Merchant.getApple_Inventory() + " apples.");
                        System.out.println("The current price is " + Merchant.getPrice());
                        System.out.println(" ");
                        System.out.println("Your balance is: $" + User_1.getBalance());
                        System.out.println("Apple balance is: " + User_1.getInventory_Apple());
                        System.out.println(" ");

                        int Max_Purchase;
                        if(Merchant.getApple_Inventory() < (User_1.getBalance() / Merchant.getPrice())){
                            Max_Purchase = Merchant.getApple_Inventory();
                        }else{
                            Max_Purchase = User_1.getBalance() / Merchant.getPrice();
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
                            Flag_2 = true;
                        }else if( Input_2 > Merchant.getApple_Inventory()) {    //if the entered qty is higher than what the merchant has, cant
                            Can_Purchase = false;
                        }else if(User_1.getBalance() - (Input_2 * Merchant.getPrice()) < 0){    //if the user balance will result to become low, cant
                            Can_Purchase = false;
                        }else{  //At this point, we can process the transaction
                            Merchant.setApple_Inventory(Merchant.getApple_Inventory() - Input_2);
                            User_1.setInventory_Apple(User_1.getInventory_Apple() + Input_2);

                            User_1.setBalance(User_1.getBalance() - (Input_2 * (Merchant.getPrice())));
                        }
                    }
                    Flag_2 = false;

                } else if (input == 2) {    //This is the sell option
                    String Msg_1 = "Merchant or you cannot afford that... Please try another value.";
                    String Msg_2 = "How many Apples would you like to sell? Enter 0 to return...";
                    boolean Can_Purchase = true;

                    while(!Flag_2) {
                        SkipLines(100);
                        System.out.println("-------------------------------------------------");
                        System.out.println(Merchant.getName() + " has " + Merchant.getApple_Inventory() + " apples.");
                        System.out.println("The current price is $" + Merchant.getPrice());
                        System.out.println(" ");
                        System.out.println("Your balance is: $" + User_1.getBalance());
                        System.out.println("Apple balance is: " + User_1.getInventory_Apple());
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
                            Flag_2 = true;
                        }else if( Input_2 > User_1.getInventory_Apple()) {    //if the entered qty is higher than what the user has, cant
                            Can_Purchase = false;
                        }else{  //At this point, we can process the transaction
                            Merchant.setApple_Inventory(Merchant.getApple_Inventory() + Input_2);
                            User_1.setInventory_Apple(User_1.getInventory_Apple() - Input_2);

                            User_1.setBalance(User_1.getBalance() + (Input_2 * (Merchant.getPrice())));
                        }
                    }
                    Flag_2 = false;

                } else if (input == 3) {
                    System.out.println("Proceeding to the next day...");
                    Flag_3 = true;
                } else if (input == 4) {
                    Flag_1 = true;
                    Flag_3 = true;
                    System.out.println("Exiting the Apple game");
                    System.out.println("Thanks for playing, " + User_1.getName() + "!");
                } else {
                    System.out.println("[[The entered value is not a valid input!]]");
                }
            }
            Flag_3 = false;
            //Check to see if the User has more than 1 million bucks, if so - end game!
            if(User_1.getBalance() >= 1_000_000){
                Flag_1 = true;
                SkipLines(100);
                System.out.println("-------------------------------------------------");
                System.out.println("Congrats! You have beaten the game by having more than 1 mill!");
                System.out.println(" ");
                System.out.println(" ");
                System.out.println("Ending balance is $" + User_1.getBalance());
                System.out.println("Ending Apple count is "+ User_1.getInventory_Apple());
                System.out.println(" ");
                System.out.println("Exiting the Apple game");
                System.out.println("Thanks for playing, " + User_1.getName() + "!");
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public static void SkipLines(int j){
        for(int i=1; i<=j;i++){
            System.out.println(" ");
        }
    }
}
