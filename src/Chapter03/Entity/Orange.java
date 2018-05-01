package Chapter03.Entity;

/**
 * Created by lkmc2 on 2018/5/1.
 * 橘子实体类
 */

public class Orange extends Fruit {

    public Orange(Integer weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Orange: " + super.toString();
    }
}
