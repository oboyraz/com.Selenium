package utilities;

public class ReusableMethods {

    public static void delay(int second){

        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {

        }
    }
}
