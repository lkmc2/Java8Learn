package Chapter03;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.Arrays;
import java.util.List;

import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;
import static java.util.Comparator.comparing;

/**
 * Created by lkmc2 on 2018/4/30.
 * 方法引用详解
 */

public class MethodReference {

    /*
    Lambda及其等效方法引用的例子:
    1 (Apple a) -> a.getWeight()  等效于 Apple::getWeight
    2 () -> Thread.currentThread().dumpStack() 等效于 Thread.currentThread()::dumpStack
    3 (str, i) -> str.substring(i) 等效于 String::substring
    4 (String s) -> System.out.println(s) 等效于 System.out::println

    如何构建方法引用
    方法引用主要有三类。
    (1) 指向静态方法的方法引用（例如 Integer 的 parseInt 方法，写作 Integer::parseInt ）。
    (2) 指向任意类型实例方法的方法引用（例如String的length方法，写作String::length）。
    (3) 指向现有对象的实例方法的方法引用（假设你有一个局部变量expensiveTransaction
        用于存放 Transaction 类型的对象，它支持实例方法 getValue ，
        那么你就可以写 expensiveTransaction::getValue ）。
     */

    public static void main(String[] args) {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, Apple.GREEN, 170);
        // 对列表根据重量排序（方法引用）
        appleList.sort(comparing(Apple::getWeight));
        System.out.println("--------排序后的苹果列表--------");
        // 打印排序后的苹果列表
        printInfoInList(appleList);

        // 生成字符列表
        List<String> stringList = Arrays.asList("d", "c", "b", "a");
        // 使用字符串自带的compareToIgnoreCase进行比较（Lambda）
        stringList.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("--------排序后的字符串列表（Lambda）--------");
        // 打印排序后的字符串列表
        printInfoInList(stringList);

        // 使用字符串自带的compareToIgnoreCase进行比较（方法引用）
        stringList.sort(String::compareToIgnoreCase);
        System.out.println("--------排序后的字符串列表（方法引用）--------");
        // 打印排序后的字符串列表
        printInfoInList(stringList);

        /*
        运行结果：
        --------排序后的苹果列表--------
        Apple{color='red', weight=11}
        Apple{color='green', weight=41}
        Apple{color='green', weight=51}
        Apple{color='red', weight=52}
        Apple{color='red', weight=71}
        Apple{color='red', weight=158}
        Apple{color='red', weight=205}
        Apple{color='green', weight=224}
        Apple{color='green', weight=232}
        Apple{color='green', weight=264}
        --------排序后的字符串列表（Lambda）--------
        a
        b
        c
        d
        --------排序后的字符串列表（方法引用）--------
        a
        b
        c
        d
         */
    }

}
