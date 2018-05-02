package Chapter05.Reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by lkmc2 on 2018/5/2.
 * 使用Stream Reduce求和
 */

public class ReduceSum {

    // 普通的求和方法
    private static void commonSumMethod(List<Integer> numbers) {
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        System.out.println(sum);
    }

    // 使用reduce和Lambda求和
    private static void reduceLambda(List<Integer> numbers) {
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
    }

    // 使用reduce和方法引用求和
    private static void reduceMethodReference(List<Integer> numbers) {
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    // 使用reduce无初始值求和
    private static void reduceNoInitValue(List<Integer> numbers) {
        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        System.out.println(sum);
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);

        // 普通的求和方法
        commonSumMethod(numbers);

        // 使用reduce和Lambda求和
        reduceLambda(numbers);

        // 使用reduce和方法引用求和
        reduceMethodReference(numbers);

        // 使用reduce无初始值求和
        reduceNoInitValue(numbers);

        /*
        运行结果：
        25
        25
        25
        Optional[25]
         */
    }

}
