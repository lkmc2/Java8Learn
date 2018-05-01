package Chapter04.Entity;

/**
 * Created by lkmc2 on 2018/5/1.
 * 菜肴实体类
 */

public class Dish {

    private final String name; // 菜肴名
    private final boolean vegetarian; // 是否素食
    private final int calories; // 卡路里
    private final Type type;


    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public enum Type {
        MEAT, FISH, OTHER
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return name;
    }
}
