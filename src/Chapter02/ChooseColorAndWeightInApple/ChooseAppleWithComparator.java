package Chapter02.ChooseColorAndWeightInApple;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.Comparator;
import java.util.List;

import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/4/30.
 * 使用Comparator获取符合条件的苹果
 */

public class ChooseAppleWithComparator {

    // 使用匿名内部类Comparator排序
    public static void compareWithAnonymousClass(List<Apple> appleList) {
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        System.out.println("-----匿名内部类Comparator排序-----");
        // 打印排序后的列表
        printInfoInList(appleList);
    }

    // 使用Lambda Comparator排序
    public static void compareWithLambda(List<Apple> appleList) {
//        appleList.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
        // 类型可推导时可省略参数类型
        appleList.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));

        System.out.println("-----Lambda Comparator排序-----");
        // 打印排序后的列表
        printInfoInList(appleList);
    }

    // 使用Comparator.comparing 方法引用排序
    public static void compareWithMethodreference(List<Apple> appleList) {
        // 类型可推导时可省略参数类型
        appleList.sort(Comparator.comparing(Apple::getWeight));

        System.out.println("-----Comparator.comparing 方法引用排序-----");
        // 打印排序后的列表
        printInfoInList(appleList);
    }

    public static void main(String[] args) {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, Apple.GREEN, 170);

        // 使用匿名内部类Comparator排序
        compareWithAnonymousClass(appleList);

        // 使用Lambda Comparator排序
        compareWithLambda(appleList);

        // 使用Comparator.comparing 方法引用排序
        compareWithMethodreference(appleList);
    }

}
