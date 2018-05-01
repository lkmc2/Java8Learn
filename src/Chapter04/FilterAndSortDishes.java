package Chapter04;

import Chapter04.Entity.Dish;

import java.util.*;

import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Created by lkmc2 on 2018/5/1.
 * 使用Stream过滤并根据卡路里排序菜肴后获取菜名
 */

public class FilterAndSortDishes {

    // 使用java7过滤卡路里低于400，并且根据卡路里排序的菜肴名列表
    public static List<String> filterByJava7(List<Dish> menu) {
        List<Dish> lowCaloricDishes = new ArrayList<>();
        for (Dish d : menu) {
            if (d.getCalories() < 400) {
                lowCaloricDishes.add(d);
            }
        }
        Collections.sort(lowCaloricDishes, new Comparator<Dish>() {
            @Override
            public int compare(Dish d1, Dish d2) {
                return Integer.compare(d1.getCalories(), d2.getCalories());
            }
        });
        List<String> lowCaloricDishesName = new ArrayList<>();
        for (Dish d : lowCaloricDishes) {
            lowCaloricDishesName.add(d.getName());
        }
        return lowCaloricDishesName;
    }

    // 使用java8 Stream过滤卡路里低于400，并且根据卡路里排序的菜肴名列表（与使用java7等效）
    public static List<String> filterByJava8Stream(List<Dish> menu) {
        return menu.stream()
                .filter(d -> d.getCalories() < 400)
                .sorted(comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(toList());
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
        // 使用java7过滤卡路里低于400，并且根据卡路里排序的菜肴名列表
        List<String> lowDishedNameByJava7 = filterByJava7(menu);
        System.out.println("-------使用java7过滤并排序----------");
        // 打印列表内容
        printInfoInList(lowDishedNameByJava7);

        // 使用java8 Stream过滤卡路里低于400，并且根据卡路里排序的菜肴名列表
        List<String> lowDishedNameByJava8 = filterByJava8Stream(menu);
        System.out.println("-------使用java8 Stream过滤并排序----------");
        // 打印列表内容
        printInfoInList(lowDishedNameByJava8);

        /*
        运行结果：
        -------使用java7过滤并排序----------
        season fruit
        prawns
        rice
        -------使用java8 Stream过滤并排序----------
        season fruit
        prawns
        rice
         */
    }

}
