package Package_StoreGame;

public class User {
    private String name;
    private int Inventory_Apple;
    private int Balance;

    Items Apple = new Items("Apple");

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getInventory_Apple() {
        return Inventory_Apple;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInventory_Apple(int inventory_Apple) {
        Inventory_Apple = inventory_Apple;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    public int getBalance() {
        return Balance;
    }
}
