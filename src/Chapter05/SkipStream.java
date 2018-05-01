package Chapter05;

import Chapter04.Entity.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by lkmc2 on 2018/5/1.
 * 使用skip(n)丢弃Steam产生的前n个元素（如果流中元素不足n个，则返回一个空流）
 */

public class SkipStream {

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

        // 过滤卡路里高于300的菜，丢弃前两个元素
        List<Dish> dishes = menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println(dishes);

        /*
        运行结果：
        [chicken, french fries, rice, pizza, salmon]
         */
    }

}
