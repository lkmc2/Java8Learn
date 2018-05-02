package Chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by lkmc2 on 2018/5/2.
 * Stream FlatMap平铺展开（拆分单词）
 */

/*
    现在的需求是将单词列表["Hello","World"] ，返回列表 ["H","e","l", "o","W","r","d"]
 */
public class StreamFlatMap {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("Hello", "World");

        // 错误的转换方式，因为split得到的是String数组
        List<String[]> wrongResult = words.stream()
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        System.out.println(wrongResult);
        // 运行结果：[[Ljava.lang.String;@6d03e736, [Ljava.lang.String;@568db2f2]

        // 正确的转换方式
        List<String> rightResult = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream) // 将每个值都转换成一个流，再将这些流连接起来
                .distinct()
                .collect(toList());
        System.out.println(rightResult);
        // 运行结果：[H, e, l, o, W, r, d]
    }


}
