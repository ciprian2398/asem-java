public class Apple {
    private String apron;
    private String color;
    private double weight;

    public Apple(String apron, String color, double weight) {
        this.apron = apron;
        this.color = color;
        this.weight = weight;
    }

    public String getApron() {
        return apron;
    }

    public void setApron(String apron) {
        this.apron = apron;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "apron='" + apron + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
