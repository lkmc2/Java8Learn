package Chapter01.ChooseColorAndWeightInApple;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

// 静态引入工具类中的方法
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/4/25.
 * 获取特定条件苹果的普通方式
 */

public class ChooseAppleCommon {

    public static final String GREEN = "green";
    public static final String RED = "red";

    /**
     * 从库存中获取绿色的苹果
     *
     * @param stock 库存
     * @return 绿色的苹果列表
     */
    public static List<Apple> filterGreenApples(List<Apple> stock) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : stock) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 从库存中获取质量超过150克的水果
     * @param stock 库存
     * @return 质量超过150克的水果列表
     */
    public static List<Apple> filterHeavyApples(List<Apple> stock) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : stock) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, GREEN, 170);

        System.out.println("-----绿苹果列表-----");
        // 过滤列表中的绿苹果并打印
        printInfoInList(filterGreenApples(Objects.requireNonNull(appleList)));

        System.out.println("-----质量大于150g苹果列表-----");
        //过滤出列表中质量大于150g的水果并打印
        printInfoInList(filterHeavyApples(appleList));

        /*
        运行结果：
            -----绿苹果列表-----
            Apple{color='green', weight=17}
            Apple{color='green', weight=141}
            Apple{color='green', weight=191}
            Apple{color='green', weight=199}
            -----质量大于150g苹果列表-----
            Apple{color='red', weight=164}
            Apple{color='red', weight=216}
            Apple{color='green', weight=191}
            Apple{color='green', weight=199}
         */
    }
}
