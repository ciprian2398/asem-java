import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Apple> apples = new ArrayList<>();

        apples.add(new Apple("Gold..","green",32.256));
        apples.add(new Apple("Gold..","red",23.23));
        apples.add(new Apple("Gold..","yellow",782.56));
        apples.add(new Apple("Gold..","green",312.2));

        List<Apple> specialApples = apples.stream()
                        .filter(new WeightFilterPredicate(30,400))
                        .collect(Collectors.toList());

        specialApples.forEach(System.out::println);

    }
}
