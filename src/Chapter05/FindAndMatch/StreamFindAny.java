package Chapter05.FindAndMatch;

import Chapter04.Entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by lkmc2 on 2018/5/2.
 * Stream findAny获取其中任意一个元素即停止
 */

public class StreamFindAny {

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

        // 获取任意一道素菜则停止继续查找，并打印获取的那一道素菜
        menu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(System.out::println);

        /*
        运行结果：french fries
         */
    }

}
