import java.util.Random;

public class Random_Number {
    public static void main(String[]args){
        Random R = new Random();
        int low = 1;
        int high = 10;

        int result = R.nextInt(high-low) + low;
        System.out.println(result);
    }
}
