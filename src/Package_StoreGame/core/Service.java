package Package_StoreGame.core;

import java.util.Scanner;

import Package_StoreGame.Objects.Merchant;
import Package_StoreGame.Objects.User;

public class Service {
    public static User getPlayerName(Scanner scanner){
        SkipLines(100);

        System.out.println("--------------------------------------------------------");
        System.out.println("Hello new Player, please enter your name below");
        System.out.println(" ");
        System.out.println("Also, to win the game, you must reach 1 million dollars");
        System.out.println("--------------------------------------------------------");
        
        SkipLines(1);
        String name = scanner.nextLine();
        return new User(name);
    }

    public static void printDayMessage(int day, Merchant merchant, User mainPlayer){

        String Day_Message = day == 1 ? 
        "Welcome to the Apple Game, "+ mainPlayer.getName() + "! It is the first day of your journey." : 
        "Apple Gainz day Number: " + day;

        SkipLines(100);

        System.out.println("-------------------------------------------------");
        System.out.println(Day_Message);
        System.out.println(" ");

        //Output the Merchant's Attributes
        System.out.println(merchant.getName() + "'s total apples are " + merchant.getApple_Inventory());
        System.out.println("The price of the Apple today is $" + merchant.getPrice());

        //  Finish the remainder of the message with the User's Input/Details
        System.out.println(" ");
        System.out.println("Enter a value below to represent your action:");
        System.out.println("1 = Purchase Apples");
        System.out.println("2 = Sell Apples");
        System.out.println("3 = Next day");
        System.out.println("4 = Exit Game");
        System.out.println(" ");
        System.out.println("You currently have " + mainPlayer.getInventory_Apple() + " apples!");
        System.out.println("Your current balance is $" + mainPlayer.getBalance());
        System.out.println("-------------------------------------------------");
        System.out.println(" ");
        System.out.println("Please enter your next action");
    }

    public static boolean doesPlayerHaveMoreThan1Mill(User mainPlayer){
        if(mainPlayer.getBalance() >= 1_000_000){
            SkipLines(100);
            System.out.println("-------------------------------------------------");
            System.out.println("Congrats! You have beaten the game by having more than 1 mill!");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Ending balance is $" + mainPlayer.getBalance());
            System.out.println("Ending Apple count is "+ mainPlayer.getInventory_Apple());
            System.out.println(" ");
            System.out.println("Exiting the Apple game");
            System.out.println("Thanks for playing, " + mainPlayer.getName() + "!");
            System.out.println("-------------------------------------------------");
            return true;
        }
        return false;
    }
    private static void SkipLines(int j){
        for(int i=1; i<=j;i++){
            System.out.println(" ");
        }
    }
}