import Package_StoreGame.Items;
import Package_StoreGame.User;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //Declare stuff needed
            Items Apple = new Items("Apple");

            Boolean Flag_1 = false;


        //Get the username
            System.out.println("Hello new Player, please enter your name below");
            Scanner Scan_1 = new Scanner(System.in);
            String input_1 = Scan_1.nextLine();

            User User_1 = new User(input_1);

        while(Flag_1 == false) {
            //Output Msg
                System.out.println("-------------------------------------------------");
                System.out.println("Welcome to the Apple game, " + User_1.getName() + "!");
                System.out.println(" ");
                System.out.println("1 = Purchase Apples");
                System.out.println("2 = Sell Apples");
                System.out.println("3 = Exit Game");
                System.out.println(" ");
                System.out.println("You currently have " + User_1.getInventory_Apple() + " apples!");
                System.out.println("-------------------------------------------------");
                System.out.println(" ");
                System.out.println("Please enter your next action");

            //Prompt User
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();

            //Take a look at the input
                if (input == 1) {
                    System.out.println("How many Apples would you like to purchase?");
                    Scanner Input_Purchase = new Scanner(System.in);
                    int Input_2 = Input_Purchase.nextInt();

                    User_1.setInventory_Apple(User_1.getInventory_Apple() + Input_2);

                } else if (input == 2) {
                    System.out.println("How many Apples would you like to sell?");
                    Scanner Input_Sell = new Scanner(System.in);
                    int Input_3 = Input_Sell.nextInt();

                    User_1.setInventory_Apple(User_1.getInventory_Apple() - Input_3);

                } else if (input == 3) {
                    Flag_1 = true;
                    System.out.println("Exiting the Apple game");
                    System.out.println("Thanks for playing, " + User_1.getName() + "!");
                }else{
                    System.out.println("[[The entered value is not a valid input!]]");
                }
        }
    }
}
