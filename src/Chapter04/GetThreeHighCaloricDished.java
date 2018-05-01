package Chapter04;

import Chapter04.Entity.Dish;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by lkmc2 on 2018/5/1.
 * 使用Stream获取三道高卡路里的菜
 */

public class GetThreeHighCaloricDished {

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

        // 获取三道高卡路里的菜放到列表中
        List<String> threeHighCaloricDishNames =
                menu.stream()
                    .filter(d -> d.getCalories() > 300)
                    .map(Dish::getName)
                    .limit(3)
                    .collect(toList());

        // 打印列表内容
        System.out.println(threeHighCaloricDishNames);

        /*
        运行结果：
        [pork, beef, chicken]
         */
    }

}
