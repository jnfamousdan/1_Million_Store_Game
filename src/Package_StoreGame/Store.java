package Package_StoreGame;

public class Store {
    private String name;
    private int Apple_Inventory;
    private int Price;

    public Store(String name) {
        this.name = name;
    }

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

}
