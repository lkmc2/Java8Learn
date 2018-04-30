package Chapter02.ChooseColorAndWeightInApple;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.ArrayList;
import java.util.List;

import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/4/30.
 * 使用策略模式选出符合条件的苹果
 */

public class ChooseAppleWithStrategyPattern {

    // 挑选苹果策略接口
    public interface ApplePredicate {
        boolean test(Apple apple);
    }

    // 挑选质量大于150g苹果策略
    public static class AppleHeavyWeightPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return apple.getWeight() > 150;
        }
    }

    // 挑选绿苹果策略
    public static class AppleGreenColorPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return Apple.GREEN.equals(apple.getColor());
        }
    }

    // 挑选质量大于150g的红苹果策略
    public static class AppleRedAndHeavyPredicate implements ApplePredicate {
        @Override
        public boolean test(Apple apple) {
            return Apple.RED.equals(apple.getColor())
                    && apple.getWeight() > 150;
        }
    }

    /**
     * 过滤出符合要求的苹果列表
     * @param stock 苹果库存
     * @param p 断言
     * @return 符合要求的苹果列表
     */
    public static List<Apple> filterApples(List<Apple> stock, ApplePredicate p) {
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
        // 过滤列表中的绿苹果并打印（策略模式）
        printInfoInList(filterApples(appleList, new AppleGreenColorPredicate()));

        System.out.println("-----质量大于150g苹果列表-----");
        //过滤出列表中质量大于150g的水果并打印（策略模式）
        printInfoInList(filterApples(appleList,  new AppleHeavyWeightPredicate()));

        System.out.println("-----质量大于150g的红色苹果列表-----");
        //过滤出列表中质量大于150g的红色水果并打印（策略模式）
        printInfoInList(filterApples(appleList,  new AppleRedAndHeavyPredicate()));

        /*
        运行结果：
            -----绿苹果列表-----
            Apple{color='green', weight=123}
            Apple{color='green', weight=27}
            Apple{color='green', weight=268}
            Apple{color='green', weight=191}
            Apple{color='green', weight=243}
            Apple{color='green', weight=146}
            Apple{color='green', weight=164}
            -----质量大于150g苹果列表-----
            Apple{color='red', weight=242}
            Apple{color='green', weight=268}
            Apple{color='green', weight=191}
            Apple{color='green', weight=243}
            Apple{color='red', weight=186}
            Apple{color='red', weight=247}
            Apple{color='green', weight=164}
            -----质量大于150g的红色苹果列表-----
            Apple{color='red', weight=242}
            Apple{color='red', weight=186}
            Apple{color='red', weight=247}
         */
    }
}
