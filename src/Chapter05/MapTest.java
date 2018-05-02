package Chapter05;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by lkmc2 on 2018/5/2.
 * Stream Map映射测试
 */

public class MapTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        // 将数字列表转换成每个数的平方构成的列表
        List<Integer> result = list.stream()
                .map(n -> n * n)
                .collect(toList());
        System.out.println(result);
    }
}
