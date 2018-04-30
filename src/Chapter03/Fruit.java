package Chapter03;

/**
 * Created by lkmc2 on 2018/4/25.
 * 水果实体类
 */

public class Fruit {
    public static final String GREEN = "green";
    public static final String RED = "red";
    public static final String GROWN = "grown";

    private String color;
    private Integer weight;

    public Fruit() {
    }

    public Fruit(Integer weight) {
        this.weight = weight;
    }

    public Fruit(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public static boolean isGreen(Fruit apple) {
        return GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyFruit(Fruit apple) {
        return apple.getWeight() > 150;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
