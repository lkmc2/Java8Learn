package Chapter05;

import Chapter04.Entity.Dish;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lkmc2 on 2018/5/2.
 * Stream AllMatch全部匹配才为真
 */

public class StreamAllMatch {

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

        // 判断是否所有菜的卡路里都小于1000
        boolean isHealthy = menu.stream()
                .allMatch(d -> d.getCalories() < 1000);
        System.out.println(isHealthy);
        /*
        运行结果：true
         */
    }

}
