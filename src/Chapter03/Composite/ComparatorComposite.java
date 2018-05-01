package Chapter03.Composite;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static Chapter01.ChooseColorAndWeightInApple.Apple.GREEN;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;
import static java.util.Comparator.comparing;

/**
 * Created by lkmc2 on 2018/5/1.
 * 使用比较器复合
 */

public class ComparatorComposite {

    // 根据苹果重量生成正序比较器（重量从小到大）
    static Comparator<Apple> comparator = comparing(Apple::getWeight);

    // 根据苹果重量生成逆序比较器（重量从大到小）
    static Comparator<Apple> comparatorReversed = comparing(Apple::getWeight).reversed();

    // 进行逆序比较
    private static void compareReversed() {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, GREEN, 170);

        System.out.println("-----使用正序比较器（重量从小到大）进行重量排序-----");
        appleList.sort(comparator);
        // 打印排序后的苹果列表
        printInfoInList(appleList);

        System.out.println("-----使用逆序比较器（重量从大到小）进行重量排序-----");
        // 使用逆序比较器
        appleList.sort(comparatorReversed);
        // 直接在sort方法中写逆序比较器（效果与使用逆序比较器一致）
        appleList.sort(comparing(Apple::getWeight).reversed());
        // 打印排序后的苹果列表
        printInfoInList(appleList);

        /*
        运行结果：
        -----使用正序比较器（重量从小到大）进行重量排序-----
        Apple{color='green', weight=10, country='null'}
        Apple{color='red', weight=63, country='null'}
        Apple{color='green', weight=88, country='null'}
        Apple{color='green', weight=92, country='null'}
        Apple{color='red', weight=137, country='null'}
        Apple{color='red', weight=140, country='null'}
        Apple{color='green', weight=147, country='null'}
        Apple{color='green', weight=205, country='null'}
        Apple{color='green', weight=257, country='null'}
        Apple{color='green', weight=295, country='null'}
        -----使用逆序比较器（重量从大到小）进行重量排序-----
        Apple{color='green', weight=295, country='null'}
        Apple{color='green', weight=257, country='null'}
        Apple{color='green', weight=205, country='null'}
        Apple{color='green', weight=147, country='null'}
        Apple{color='red', weight=140, country='null'}
        Apple{color='red', weight=137, country='null'}
        Apple{color='green', weight=92, country='null'}
        Apple{color='green', weight=88, country='null'}
        Apple{color='red', weight=63, country='null'}
        Apple{color='green', weight=10, country='null'}
         */
    }

    // 使用比较链
    private static void compareLinked() {
        // 生成苹果列表
        List<Apple> appleList = Arrays.asList(new Apple(234, "Japan"), new Apple(345, "China"), new Apple(234, "Canada"));

        System.out.println("-----使用比较器链进行重量与国家排序-----");
        appleList.sort(comparing(Apple::getWeight)
                        .reversed()
                        .thenComparing(Apple::getCountry));
        // 打印排序后的苹果列表
        printInfoInList(appleList);

        /*
        运行结果：
        -----使用比较器链进行重量与国家排序-----
        Apple{color='null', weight=345, country='China'}
        Apple{color='null', weight=234, country='Canada'}
        Apple{color='null', weight=234, country='Japan'}
        */
    }

    public static void main(String[] args) {
        compareReversed(); // 进行逆序比较
        compareLinked(); // 使用比较链
    }

}
