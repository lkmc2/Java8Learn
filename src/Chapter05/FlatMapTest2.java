package Chapter05;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by lkmc2 on 2018/5/2.
 * Stream FlatMap映射测试2
 */

public class FlatMapTest2 {

    public static void main(String[] args) {
        /*
            要求：将列表[1, 2, 3]和列表[3, 4]，
                转换成类似[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]的形式，
                并只返回总和能被3整除的数对
         */

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        
        List<int[]> result = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})
                )
                .collect(toList());

        for (int[] array : result) {
            System.out.print("[");
            for (int num : array) {
                System.out.print(num + ",");
            }
            System.out.print("],");
        }
        // 运行结果：[2,4,],[3,3,],
    }

}
