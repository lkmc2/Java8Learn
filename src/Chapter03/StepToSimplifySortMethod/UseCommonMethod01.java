package Chapter03.StepToSimplifySortMethod;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.Comparator;
import java.util.List;

import static Chapter01.ChooseColorAndWeightInApple.Apple.GREEN;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/5/1.
 * 使用普通方法进行排序（实现Comparator接口）
 */

public class UseCommonMethod01 {

    // 定义一个实现了Comparator接口的类
    public static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }

    public static void main(String[] args) {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, GREEN, 170);

        System.out.println("-----使用普通方法进行重量排序-----");
        appleList.sort(new AppleComparator());
        // 打印排序后的苹果列表
        printInfoInList(appleList);

        /*
        运行结果：
        -----使用普通方法进行重量排序-----
        Apple{color='green', weight=103}
        Apple{color='red', weight=130}
        Apple{color='red', weight=132}
        Apple{color='green', weight=133}
        Apple{color='red', weight=176}
        Apple{color='green', weight=209}
        Apple{color='green', weight=234}
        Apple{color='green', weight=245}
        Apple{color='green', weight=246}
        Apple{color='red', weight=274}
         */
    }

}
