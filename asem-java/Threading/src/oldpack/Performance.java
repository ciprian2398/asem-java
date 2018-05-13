package oldpack;

public class Performance {
    static long startMiliseconds;

    public static void start(){
        startMiliseconds = System.currentTimeMillis();
    }

    public static void stop(){
        long stop = System.currentTimeMillis();
        System.out.println("Total Miliseconds: " + (stop - startMiliseconds));
    }
}
