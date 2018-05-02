package Chapter05.Reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by lkmc2 on 2018/5/2.
 * 使用Stream reduce求最大值和最小值
 */

public class ReduceMaxOrMinValue {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);

        // 使用reduce求列表中最大值
        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        // 如果最大值存在则打印出来
        max.ifPresent(System.out::println);

        // 使用reduce求列表中最小值
        Optional<Integer> min = numbers.stream().reduce(Integer::min);
        // 如果最小值存在则打印出来
        min.ifPresent(System.out::println);

        /*
        运行结果：
        9
        1
         */
    }

}
