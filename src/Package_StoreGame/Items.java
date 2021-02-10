package Package_StoreGame;

public class Items {
    private String name;
    private int Last_Price;
    private int QTY;

    //methods


    //Constructor
    public Items(String name) {
        this.name = name;
    }

    //Set/Get
    public void setLast_Price(int last_Price) {
        Last_Price = last_Price;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }



    public double getLast_Price() {
        return Last_Price;
    }

    public int getQTY() {
        return QTY;
    }
}
