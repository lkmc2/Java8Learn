package Chapter03.StepToSimplifySortMethod;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.Comparator;
import java.util.List;

import static Chapter01.ChooseColorAndWeightInApple.Apple.GREEN;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/5/1.
 * 使用匿名内部类进行排序
 */

public class UseAnonymousClass02 {

    public static void main(String[] args) {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, GREEN, 170);

        System.out.println("-----使用匿名内部类进行重量排序-----");
        appleList.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });
        // 打印排序后的苹果列表
        printInfoInList(appleList);

        /*
        运行结果：
        -----使用匿名内部类进行重量排序-----
        Apple{color='red', weight=58}
        Apple{color='red', weight=94}
        Apple{color='green', weight=123}
        Apple{color='red', weight=131}
        Apple{color='red', weight=132}
        Apple{color='red', weight=142}
        Apple{color='green', weight=179}
        Apple{color='green', weight=196}
        Apple{color='red', weight=204}
        Apple{color='red', weight=265}
         */
    }

}
