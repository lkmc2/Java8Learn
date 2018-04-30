package Chapter02.ChooseColorAndWeightInApple;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/4/30.
 * 使用Lambda挑选出符合条件的对象（行为参数化，把方法当成一种参数）
 */

public class ChooseObjWithLambda {

    /**
     * 断言接口
     *
     * @param <T> 参数类型
     */
    public interface Predicate<T> {
        /**
         * 测试参数是否符合规则
         *
         * @param t 参数
         * @return 参数是否符合规则
         */
        boolean test(T t);
    }

    /**
     * 过滤出符合要求的对象列表
     *
     * @param list 对象列表
     * @param p    断言
     * @return 符合要求的对象列表
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, Apple.GREEN, 170);

        // 过滤出红色苹果（使用Lambda）
        List<Apple> redApples = filter(appleList, (Apple apple) -> Apple.RED.equals(apple.getColor()));
        System.out.println("-----红苹果列表-----");
        // 打印红苹果列表
        printInfoInList(redApples);


        // 生成1到10的Integer型列表
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // 过滤偶数列表
        List<Integer> evenNumbers = filter(integerList, (Integer i) -> i % 2 == 0);
        System.out.println("-----偶数列表-----");
        // 打印偶数列表
        printInfoInList(evenNumbers);
    }
}
