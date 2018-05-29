import java.util.function.Predicate;

public class WeightFilterPredicate implements Predicate<Apple> {
    private double minWeight;
    private double maxWeight;

    public WeightFilterPredicate(double minWeight, double maxWeight) {
        this.minWeight = minWeight;
        this.maxWeight = maxWeight;
    }

    @Override
    public boolean test(Apple apple) {
        if(apple.getWeight()>=minWeight &&
                apple.getWeight()<=maxWeight)return true;
        return false;
    }
}
