package Chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/4/30.
 * 使用java8自带Predicate断言条件
 */

public class UsePredicate {

    /**
     * 从参数传入的列表中获取符合Predicate断言条件
     * @param list 对象列表
     * @param p 断言条件
     * @param <T> 对象类型
     * @return 符合条件的的对象列表
     */
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }

    // 字符串非空的断言条件
    private static Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();

    public static void main(String[] args) {
        // 字符串列表
        List<String> stringList = Arrays.asList("", "Good", "", "Never");
        // 过滤列表中非空的字符串
        List<String> nonEmptyList = filter(stringList, nonEmptyStringPredicate);

        // 打印非空字符串列表
        printInfoInList(nonEmptyList);
    }

}
