package Chapter03.Composite;

import java.util.function.Function;

/**
 * Created by lkmc2 on 2018/5/1.
 * 函数复合
 */

public class FunctionComposite {

    static Function<Integer, Integer> f = x -> x + 1;
    static Function<Integer, Integer> g = x -> x * 2;
    static Function<Integer, Integer> h = f.andThen(g); // g(f(x))
    static Function<Integer, Integer> k = f.compose(g); // f(g(x))

    static int resultAndThen = h.apply(1); // 结果：4 =（1 + 1）* 2
    static int resultCompose = k.apply(1); // 结果：3 = （1 * 2）+ 1

    public static void main(String[] args) {
        System.out.println(resultAndThen);
        System.out.println(resultCompose);

        /*
        运行结果：
        4
        3
         */
    }

}
