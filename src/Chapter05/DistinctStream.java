package Chapter05;

import java.util.Arrays;
import java.util.List;

/**
 * Created by lkmc2 on 2018/5/1.
 * 使用Stream distinct过滤重复元素
 */

public class DistinctStream {

    public static void main(String[] args) {
        // 数字列表
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        // 使用流过滤偶数，消除重复值，并打印出来
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);
    }

}
