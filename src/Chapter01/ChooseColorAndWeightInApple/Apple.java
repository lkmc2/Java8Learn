package Chapter01.ChooseColorAndWeightInApple;

/**
 * Created by lkmc2 on 2018/4/25.
 * 苹果实体类
 */

public class Apple {
    public static final String GREEN = "green";
    public static final String RED = "red";
    public static final String GROWN = "grown";

    private String color;
    private Integer weight;
    private String country;

    public Apple() {
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(Integer weight, String country) {
        this.weight = weight;
        this.country = country;
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

    public static boolean isGreen(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", country='" + country + '\'' +
                '}';
    }
}
