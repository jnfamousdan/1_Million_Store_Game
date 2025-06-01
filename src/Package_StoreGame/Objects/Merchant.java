package Package_StoreGame.Objects;

import java.util.Random;

public class Merchant {
    private String name;
    private int Apple_Inventory;
    private int Price;
    private Random randomNumberGenerator = new Random();
    private int applyQuantityCeiling;

    public Merchant(String name) {
        this.name = name;
        this.Apple_Inventory = randomNumberGenerator.nextInt(10_000);
        this.Price = randomNumberGenerator.nextInt(100);
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getApple_Inventory() {
        return Apple_Inventory;
    }

    public int getPrice() {
        return Price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setApple_Inventory(int apple_Inventory) {
        Apple_Inventory = apple_Inventory;
    }

    public void setPrice(int price) {
        Price = price;
    }

    // Custom Methods
    public void resetInventoryForNextDay(User user){
        applyQuantityCeiling = user.getBalance() / 2;
        if (applyQuantityCeiling < 10_000) applyQuantityCeiling = 10_000;

        Apple_Inventory = randomNumberGenerator.nextInt(applyQuantityCeiling - 1) + 1;
        Price = randomNumberGenerator.nextInt(100 - 1) + 1;
    }
}
