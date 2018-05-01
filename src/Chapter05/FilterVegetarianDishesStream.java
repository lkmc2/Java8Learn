package Chapter05;

import Chapter04.Entity.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by lkmc2 on 2018/5/1.
 * 使用Stream流过滤素菜
 */

public class FilterVegetarianDishesStream {

    // 使用foreach过滤素菜
    private static void filterVegetarianDishesWithForeach(List<Dish> menu) {
        List<Dish> vegetarianDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.isVegetarian()) {
                vegetarianDishes.add(d);
            }
        }
        System.out.println(vegetarianDishes);
    }

    // 使用Stream流过滤素菜
    private static void filterVegetarianDishesWithStream(List<Dish> menu) {
        List<Dish> vegetarianDishes = menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        System.out.println(vegetarianDishes);
    }

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

        // 使用foreach过滤素菜
        filterVegetarianDishesWithForeach(menu);

        // 使用Stream流过滤素菜
        filterVegetarianDishesWithStream(menu);

        /*
        运行结果：
        [french fries, rice, season fruit, pizza]
        [french fries, rice, season fruit, pizza]
         */
    }

}
