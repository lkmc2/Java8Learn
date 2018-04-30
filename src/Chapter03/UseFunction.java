package Chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static Chapter01.ChooseColorAndWeightInApple.ListUtils.printInfoInList;

/**
 * Created by lkmc2 on 2018/4/30.
 * 使用java8自带Function接口（转换方法）
 */

public class UseFunction {

//        java8 自带的Function接口如下：（有参数，带返回值，对象类型转换）
//        @FunctionalInterface
//        public interface Function<T, R>{
//            R apply(T t);
//        }

    /**
     * 将对象列表中的每个值转换成指定类型的新对象列表
     * @param list 对象列表
     * @param f 转换方法
     * @param <T> 参数对象类型
     * @param <R> 返回值对象类型
     * @return 指定类型的新对象列表
     */
    public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
        List<R> result = new ArrayList<>();
        for (T s : list) {
            // appply方法用与将参数转换成指定类型的对象
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        // 将字符串列表转换成字符串长度列表（Lambda）
        List<Integer> lenList = map(Arrays.asList("My", "world", "is", "simple"), (String s) -> s.length());
        // 打印列表内容
        printInfoInList(lenList);

        // 将字符串列表转换成字符串长度列表（方法引用）
        lenList = map(Arrays.asList("My", "world", "is", "simple"), String::length);
        // 打印列表内容
        printInfoInList(lenList);
    }
}
