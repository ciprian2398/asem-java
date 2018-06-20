package model;

import java.util.regex.Pattern;

public class Main {
    private final int minN = (int) Math.sqrt(1020304050607080900L);
    private final int maxN = (int) Math.sqrt(1929394959697989990L);
    private Pattern pattern = Pattern.compile("1[0-9]2[0-9]3[0-9]4[0-9]5[0-9]6[0-9]7[0-9]8[0-9]9[0-9]0");

    public static void main(String[] args) {
        new Main().job();
    }

    private void job() {
        long maxRound10 = maxN + (10 - (maxN % 10));
        for (long n = maxRound10; n > minN; n -= 10)
            if (isOKSquare(n)) {
                System.out.println(n + " " + n * n);
                return;
            }
    }

    private boolean isOKSquare(long n) {
        return pattern.matcher(String.valueOf(n * n)).matches();
    }
}
