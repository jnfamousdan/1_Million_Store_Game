package Package_StoreGame.core;

import java.util.Random;
import java.util.Scanner;

import Package_StoreGame.Objects.Merchant;
import Package_StoreGame.Objects.User;

public class Handler {

    public static User getPlayerName(Scanner scanner){
        return Service.getPlayerName(scanner);
    }
    public static void printDayMessage(int day, Merchant merchant, User mainPlayer){
        Service.printDayMessage(day, merchant, mainPlayer);
    }

    public static boolean doesPlayerHaveMoreThan1Mill(User mainPlayer){
        return Service.doesPlayerHaveMoreThan1Mill(mainPlayer);
    }

    public static void purchaseApples(Scanner scanner, User mainPlayer, Merchant merchant){
        Service.purchaseApples(scanner, mainPlayer, merchant);
    }

    public static void sellApples(Scanner scanner, User mainPlayer, Merchant merchant){
        Service.sellApples(scanner, mainPlayer, merchant);
    }
}
