package Chapter03;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static Chapter01.ChooseColorAndWeightInApple.Apple.GREEN;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/5/1.
 * 谓词复合
 */

public class PredicateComposite {

    // 获取红苹果的断言
    static Predicate<Apple> redApple = (Apple a) -> Apple.RED.equals(a.getColor());

    // 对红苹果断言取反，获取非红苹果断言
    static Predicate<Apple> notRedApple = redApple.negate();

    // 对红苹果断言进行谓词复合，获取（150g以上的红苹果）或（只是绿苹果）
    static Predicate<Apple> redAndHeavyAppleOrGreen =
            redApple
            .and(a -> a.getWeight() > 150)
            .or(a -> GREEN.equals(a.getColor()));

    public static List<Apple> filterApple(List<Apple> appleList, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : appleList) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, GREEN, 170);

        System.out.println("-----获取红苹果-----");
        List<Apple> redAppleList = filterApple(appleList, redApple);
        // 打印苹果列表
        printInfoInList(redAppleList);

        System.out.println("-----获取非红苹果-----");
        List<Apple> notRedAppleList = filterApple(appleList, notRedApple);
        // 打印苹果列表
        printInfoInList(notRedAppleList);

        System.out.println("-----获取150g以上的红苹果或只是绿苹果-----");
        List<Apple> redAndHeavyAppleOrGreenList = filterApple(appleList, redAndHeavyAppleOrGreen);
        // 打印苹果列表
        printInfoInList(redAndHeavyAppleOrGreenList);



        /*
        运行结果：
        -----获取红苹果-----
        Apple{color='red', weight=132, country='null'}
        Apple{color='red', weight=253, country='null'}
        Apple{color='red', weight=228, country='null'}
        Apple{color='red', weight=33, country='null'}
        Apple{color='red', weight=272, country='null'}
        -----获取非红苹果-----
        Apple{color='green', weight=211, country='null'}
        Apple{color='green', weight=100, country='null'}
        Apple{color='green', weight=254, country='null'}
        Apple{color='green', weight=257, country='null'}
        Apple{color='green', weight=207, country='null'}
        -----获取150g以上的红苹果或只是绿苹果-----
        Apple{color='green', weight=211, country='null'}
        Apple{color='green', weight=100, country='null'}
        Apple{color='red', weight=253, country='null'}
        Apple{color='green', weight=254, country='null'}
        Apple{color='red', weight=228, country='null'}
        Apple{color='green', weight=257, country='null'}
        Apple{color='green', weight=207, country='null'}
        Apple{color='red', weight=272, country='null'}
         */
    }

}
