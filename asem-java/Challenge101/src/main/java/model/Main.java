package model;

import java.math.BigInteger;
import java.util.regex.Pattern;

public class Main {
    private final int minN = (int) Math.sqrt(10203040506070809L); //101010101
    private final int maxN = (int) Math.sqrt(19293949596979899L); //138902662
    private Pattern pattern = Pattern.compile("1[0-9]2[0-9]3[0-9]4[0-9]5[0-9]6[0-9]7[0-9]8[0-9]9[0-9]0");

    public static void main(String[] args) {
        new Main().job();
    }

    private void job() {
        for (int n = maxN; n > minN; n--) {
            if (isOKSquare(n * 10)) {
                System.out.println(n + " " + BigInteger.valueOf((n*10) * (n*10)).toString());
                return;
            }
        }
        // solution: 138901917
    }

    private boolean isOKSquare(long n) {
        BigInteger bi = BigInteger.valueOf(n * n);
        return pattern.matcher(bi.toString()).matches();
    }
}
