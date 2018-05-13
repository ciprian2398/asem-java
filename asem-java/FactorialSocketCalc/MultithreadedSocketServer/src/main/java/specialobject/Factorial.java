package specialobject;

import java.io.Serializable;
import java.math.BigInteger;

public class Factorial implements Serializable {
    private BigInteger from;
    private BigInteger to;

    public BigInteger getFrom() {
        return from;
    }

    public BigInteger getTo() {
        return to;
    }

    public Factorial(BigInteger from, BigInteger to) {
        this.from = from;
        this.to = to;
    }

    public BigInteger getResult() {
        BigInteger result = BigInteger.ONE;
        for (BigInteger bi = from;
             bi.compareTo(to) <= 0;
             bi = bi.add(BigInteger.ONE)) {
            result = result.multiply(bi);
        }
        return result;
    }
}
