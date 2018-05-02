package Chapter05.FindAndMatch;

import Chapter04.Entity.Dish;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lkmc2 on 2018/5/2.
 * Stream AnyMatch匹配任意一个即为真
 */

public class StreamAnyMatch {

    public static void main(String[] args) {
        // 菜单列表
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH)
        );

        // 如果菜单中有任意一道菜是素菜，则条件成立
        if (menu.stream().anyMatch(Dish::isVegetarian)) {
            System.out.println("这个菜单对素食主义者真是友好");
        }

        /*
        运行结果：这个菜单对素食主义者真是友好
         */
    }

}
