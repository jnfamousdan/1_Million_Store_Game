package Package_StoreGame;

public class Items {
    private String name;
    private double Last_Price;
    private int QTY;
    private int Day_Bought;

    //methods
    public void Purchase(int Value_1){
        this.QTY = this.QTY + Value_1;
        System.out.println("Purchased "+ Value_1 + " " + this.name + "(s)!");
        System.out.println("Total number of " + this.name + " is " + this.QTY);
    }
    public void Sell(int Value_2){
        this.QTY = this.QTY - Value_2;
        System.out.println("Sold " + Value_2 + " " + this.name + "(s)!");
        System.out.println("Total number of " + this.name + " is " + this.QTY);
    }


    //Constructor
    public Items(String name) {
        this.name = name;
    }

    //Set/Get
    public void setLast_Price(double last_Price) {
        Last_Price = last_Price;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public void setDay_Bought(int day_Bought) {
        Day_Bought = day_Bought;
    }

    public double getLast_Price() {
        return Last_Price;
    }

    public int getQTY() {
        return QTY;
    }

    public int getDay_Bought() {
        return Day_Bought;
    }
}
