package Chapter01.ChooseColorAndWeightInApple;

import java.util.ArrayList;
import java.util.List;
// 静态引入工具类中的方法
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/4/26.
 * 使用方法引用获取符合条件的苹果列表
 */

public class ChooseAppleMethodreference {

    /**
     * 断言接口
     * @param <T> 参数类型
     */
    public interface Predicate<T> {
        /**
         * 测试参数是否符合规则
         * @param t 参数
         * @return 参数是否符合规则
         */
        boolean test(T t);
    }

    /**
     * 过滤出符合要求的苹果列表
     * @param stock 苹果库存
     * @param p 断言
     * @return 符合要求的苹果列表
     */
    public static List<Apple> filterApples(List<Apple> stock, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : stock) {
            // 判断苹果是否符合要求
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, Apple.GREEN, 170);

        System.out.println("-----绿苹果列表-----");
        // 过滤列表中的绿苹果并打印（方法引用）
        printInfoInList(filterApples(appleList, Apple::isGreen));

        System.out.println("-----质量大于150g苹果列表-----");
        //过滤出列表中质量大于150g的水果并打印（方法引用）
        printInfoInList(filterApples(appleList, Apple::isHeavyApple));

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
