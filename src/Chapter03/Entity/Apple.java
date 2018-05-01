package Chapter03.Entity;

/**
 * Created by lkmc2 on 2018/5/1.
 * 苹果实体类
 */

public class Apple extends Fruit {

    public Apple(Integer weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Apple: " + super.toString();
    }
}
