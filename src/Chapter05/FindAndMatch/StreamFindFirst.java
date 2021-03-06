package Chapter05.FindAndMatch;

import Chapter04.Entity.Dish;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lkmc2 on 2018/5/2.
 * Stream findFirst只获取查找到的第一个元素
 */

public class StreamFindFirst {

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

        // 获取查找到的第一个素菜，并打印
        menu.stream()
                .filter(Dish::isVegetarian)
                .findFirst()
                .ifPresent(System.out::println);

        /*
        运行结果：french fries
         */
    }

}
