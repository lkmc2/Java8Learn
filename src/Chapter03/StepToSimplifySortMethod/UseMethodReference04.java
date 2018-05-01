package Chapter03.StepToSimplifySortMethod;

import Chapter01.ChooseColorAndWeightInApple.Apple;
import java.util.List;

import static Chapter01.ChooseColorAndWeightInApple.Apple.GREEN;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;
import static java.util.Comparator.comparing;

/**
 * Created by lkmc2 on 2018/5/1.
 * 使用方法引用进行排序
 */

public class UseMethodReference04 {

    public static void main(String[] args) {
        //        Apple apple = new Apple(GREEN, 170);
        // 生成苹果列表
        List<Apple> appleList = generateObjToList(Apple.class, GREEN, 170);

        System.out.println("-----使用方法引用进行重量排序-----");
        appleList.sort(comparing(Apple::getWeight));
        // 打印排序后的苹果列表
        printInfoInList(appleList);

        /*
        运行结果：
        -----使用方法引用进行重量排序-----
        Apple{color='red', weight=13}
        Apple{color='green', weight=28}
        Apple{color='red', weight=45}
        Apple{color='green', weight=60}
        Apple{color='red', weight=212}
        Apple{color='green', weight=231}
        Apple{color='red', weight=237}
        Apple{color='red', weight=260}
        Apple{color='green', weight=288}
        Apple{color='red', weight=290}
         */
    }

}
