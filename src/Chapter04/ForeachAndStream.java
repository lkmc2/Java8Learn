package Chapter04;

import Chapter04.Entity.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by lkmc2 on 2018/5/1.
 * Foreach和Stream的对比
 */

public class ForeachAndStream {

    // 使用foreach获取所有的菜名
    private static void getItemsNameWithForeach(List<Dish> menu) {
        List<String> foreachNames = new ArrayList<>();
        for (Dish d : menu) {
            foreachNames.add(d.getName());
        }
        System.out.println(foreachNames);
    }

    // 使用Iterator获取所有菜名（foreach的实现原理）
    private static void getItemsNameWithIterator(List<Dish> menu) {
        List<String> iteratorNames = new ArrayList<>();
        Iterator<Dish> iterator = menu.iterator();
        while (iterator.hasNext()) {
            Dish d = iterator.next();
            iteratorNames.add(d.getName());
        }
        System.out.println(iteratorNames);
    }

    // 使用Stream获取所有菜名
    private static void getItemsNameWithStream(List<Dish> menu) {
        List<String> streamNames = menu.stream()
                .map(Dish::getName)
                .collect(toList());
        System.out.println(streamNames);
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

        // 使用foreach获取所有的菜名
        getItemsNameWithForeach(menu);

        // 使用Iterator获取所有菜名（foreach的实现原理）
        getItemsNameWithIterator(menu);

        // 使用Stream获取所有菜名
        getItemsNameWithStream(menu);

        /*
        运行结果：
        [pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon]
        [pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon]
        [pork, beef, chicken, french fries, rice, season fruit, pizza, prawns, salmon]
         */
    }

}
