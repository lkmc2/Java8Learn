package Chapter05.Reduce;

import Chapter04.Entity.Dish;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lkmc2 on 2018/5/2.
 * 使用Map和Reduce计算一共有多少道菜
 */

public class CountTotalDishes {

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

        // 求出一共有多少道菜
        int count = menu.stream()
                .map(d -> 1)
                .reduce(0, (a, b) -> a + b);
        System.out.println(count);

        /*
        运行结果：9
         */

        // 使用count()方法直接获取流的个数
        long streamCount = menu.stream().count();
        System.out.println(streamCount);

        /*
        运行结果：9
         */
    }

}
