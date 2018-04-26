package Chapter01.ChooseColorAndWeightInApple;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
// 静态引入工具类中的方法
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.generateObjToList;
import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;


/**
 * Created by lkmc2 on 2018/4/26.
 * 使用Stream流方式过滤符合条件的苹果列表
 */

public class ChooseAppleWithStream {

    public static void main(String[] args) {
        // 生成苹果库存
        List<Apple> stock = generateObjToList(Apple.class, Apple.GREEN, 18);

        // 使用Stream过滤出150g以上的苹果列表（顺序处理）
        List<Apple> heavyApples = stock.stream()
                                        .filter((Apple a) -> a.getWeight() > 150)
                                        .collect(Collectors.toList());

        System.out.println("-----质量大于150g苹果列表-----");
        // 打印列表信息
        printInfoInList(heavyApples);


        // 使用Stream过滤出150g以上的苹果列表（并行处理）
        List<Apple> greenApples = stock.parallelStream()
                                        .filter((Apple a) -> Apple.GREEN.equals(a.getColor()))
                                        .collect(Collectors.toList());

        System.out.println("-----绿苹果列表-----");
        // 过滤列表中的绿苹果并打印
        printInfoInList(greenApples);
    }
}
