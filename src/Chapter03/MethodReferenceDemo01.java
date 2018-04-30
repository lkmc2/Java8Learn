package Chapter03;

import Chapter01.ChooseColorAndWeightInApple.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/5/1.
 * 方法引用示例01
 */

public class MethodReferenceDemo01 {

    // 重量列表
    static List<Integer> weightList = Arrays.asList(7, 3, 12, 8, 4);
    // 苹果列表
    static List<Apple> appleList = map(weightList, Apple::new);

    /**
     * 利用重量列表生成苹果列表
     * @param list 重量列表
     * @param f 指向苹果Apple(Integer weight)构造方法的引用
     * @return 设置重量后的苹果列表
     */
    public static List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }

    public static void main(String[] args) {
        // 打印苹果列表
        printInfoInList(appleList);

        /*
        运行结果：
        Apple{color='null', weight=7}
        Apple{color='null', weight=3}
        Apple{color='null', weight=12}
        Apple{color='null', weight=8}
        Apple{color='null', weight=4}
         */
    }
}
